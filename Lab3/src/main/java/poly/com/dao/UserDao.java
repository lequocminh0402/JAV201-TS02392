package poly.com.dao;

import poly.com.entity.User;

import java.util.List;

public interface UserDao<User , String> {

    List<User> findAll();
    User findById(String id);
    User create(User user);
    User update(User user);
    void deleteById(String id);

}
