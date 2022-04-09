package org.shulgin.api.dao;

import org.hibernate.SessionFactory;
import org.shulgin.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return sessionFactory.getCurrentSession()
                .get(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        String query = "delete from User where id=:userId";
        sessionFactory.getCurrentSession()
                .createQuery(query)
                .setParameter("userId", id).executeUpdate();
    }
}
