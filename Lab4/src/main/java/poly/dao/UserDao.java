package poly.dao;

import poly.entity.User;

public interface UserDao {
    User findIDorEmail(String email);
}
