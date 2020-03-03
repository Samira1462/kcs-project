package ir.karafarinbank.service;

import ir.karafarinbank.dao.UserDao;
import ir.karafarinbank.model.Branch;
import ir.karafarinbank.model.User;
import ir.karafarinbank.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private WebUtil webUtil;


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findUserByUsername(username);
        UserBuilder builder = null;
        if (user != null) {
        Branch branch = user.getBranch();
        boolean includeIpRange = isIncludeIpRange(branch.getFirstIp(), branch.getLastIp(), webUtil.getWorkStation().getIp());



            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
//            String[] authorities = user.getRole()
//                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);

//            builder.authorities(authorities);
            builder.accountLocked(!includeIpRange);
            builder.authorities(user.getRole().getName());

        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    private boolean isIncludeIpRange(String firstIp, String lastIp, String remoteIp)
    {
        try
        {
            Long ipLo = ipTolong(InetAddress.getByName(firstIp));
            Long ipHi = ipTolong(InetAddress.getByName(lastIp));
            Long ipToTest = ipTolong(InetAddress.getByName(remoteIp));
            if (ipToTest >= ipLo && ipToTest <= ipHi) return true;
            else return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    private long ipTolong(InetAddress ip)
    {
        byte[] octets = ip.getAddress();
        long result = 0;
        for (byte octet : octets)
        {
            result <<= 8;
            result |= octet & 0xff;
        }
        return result;
    }
}
