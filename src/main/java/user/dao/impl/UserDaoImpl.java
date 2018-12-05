package user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import user.dao.UserDao;
import user.entity.User;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public int create(User user) {
        Integer result = (Integer) hibernateTemplate.save(user);
        return result;
    }

    @Override
    public List<User> getUsers() {
        return hibernateTemplate.loadAll(User.class);
    }

}
