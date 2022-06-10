package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

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
   @Override
   public void findUser(int series, String model) {
      List<User> users = listUsers();
      int empty = 0;
      for (User user: users) {
         if(series == user.getCar().getSeries() && model.equals(user.getCar().getModel())){
            System.out.println(user);
            empty = 1;
         }
      }
      if(empty == 0){
         System.out.println("Юзер с такой машиной не найден");
      }
   }

}
