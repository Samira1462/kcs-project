package ir.karafarinbank.util;


import ir.karafarinbank.model.WorkStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebUtil
{
    private static HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public static WorkStation getWorkStation() {

        String ip = "";
        String name = "";
        WorkStation result = new WorkStation();

        if (request != null) {
            name = request.getServerName();
            ip = request.getHeader("X-FORWARDED-FOR");
            if (ip == null || "".equals(ip)) {
                ip = request.getRemoteAddr();
            }
        }

        result.setIp(ip.equalsIgnoreCase("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip);
        result.setName(name);
        return result;
    }

}
