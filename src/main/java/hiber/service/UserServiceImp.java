package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.TypedQuery;
import java.util.List;

@Service

public class UserServiceImp implements UserService {

   @Autowired
   private UserDaoImp userDao;

   @Autowired
   private SessionFactory sessionFactory;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   public User getUserByCar(String name, int series) {
      TypedQuery query=sessionFactory.getCurrentSession().createQuery("from User where car.name = :name and car.series = :series");
      return (User) query.getSingleResult();
   }

}
