package ir.karafarinbank.service;

import ir.karafarinbank.dao.UserDao;
import ir.karafarinbank.message.Response;
import ir.karafarinbank.message.enums.ResponseStatusEnum;
import ir.karafarinbank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public Response add(User entity) {

        Response response = new Response();
        try
        {
            userDao.add(entity);
            response.setStatus(ResponseStatusEnum.SUCCESS);
            response.setData(entity);
            response.setDescription("موفق");

        } catch (Exception e)
        {

            response.setDescription("اكسپشن");
            response.setStatus(ResponseStatusEnum.ERROR);

            e.printStackTrace();
        }

        return response;
    }

    public Response findAll()
    {
        Response response = new Response();
        try
        {

            response.setData(userDao.findAll());
            response.setStatus(ResponseStatusEnum.SUCCESS);
            response.setDescription("success");

        } catch (Exception e)
        {

            response.setDescription("Exception");
            response.setStatus(ResponseStatusEnum.ERROR);

            e.printStackTrace();
        }

        return response;
    }
}
