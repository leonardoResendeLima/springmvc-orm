package user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.dao.UserDao;
import user.entity.User;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public int save(User user) {
        // Bussiness Logic - Multiple Methods
        return userDao.create(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userDao.getUsers();
        Collections.sort(users);
        return users;
    }

    @Override
    public User findUser(Integer id) {
        return userDao.findUser(id);
    }
}
