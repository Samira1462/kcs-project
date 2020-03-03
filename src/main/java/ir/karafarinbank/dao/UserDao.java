package ir.karafarinbank.dao;

import ir.karafarinbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository {
    User findUserByUsername(String username);
    void add(User user);
    List<User> findAll();
}




