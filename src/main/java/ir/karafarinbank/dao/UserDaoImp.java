package ir.karafarinbank.dao;

import ir.karafarinbank.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String username) {
        return sessionFactory.getCurrentSession().get(User.class, username);
    }

    public void add(User entity){
        User user = new User();
        user.setPassword(entity.getPassword());
        user.setUsername(entity.getUsername());
        user.setEnabled(true);
        user.setFirstLogin(true);
        Branch branch = sessionFactory.getCurrentSession().find(Branch.class,entity.getBranch().getCode());
        user.setBranch(branch);
        Role role = entity.getRole();
        user.setRole(role);
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> findAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("select u from User u");
        List<User> list = q.list();

//        List<User2> u2 = new ArrayList<>();
//        for(User u : list)
//        {
//            User2 user = new User2();
//            Branch b = u.getBranch();
//            Role r = u.getRole();
//            Branch2 b2 = new Branch2();
//            b2.setName(b.getName());
//            user.setBranch(b2);
//            Role2 r2 = new Role2();
//            r2.setName(r.getName());
//            user.setBranch(b2);
//            user.setEnabled(u.isEnabled());
//            user.setFirstLogin(u.isFirstLogin());
//            u2.add(user);
//        }


        return list;
    }

}
