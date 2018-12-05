package user.dao;


import user.entity.User;

import java.util.List;

public interface UserDao {
    int create(User user);

    List<User> getUsers();
}
