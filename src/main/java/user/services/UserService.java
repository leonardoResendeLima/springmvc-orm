package user.services;

import user.entity.User;

import java.util.List;

public interface UserService {
    int save(User user);

    List<User> getUsers();

    User findUser(Integer id);
}
