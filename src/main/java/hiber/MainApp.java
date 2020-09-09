package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car ferrari = new Car("Ferrari", 3);
      System.out.println(ferrari.getName());

      user1.addCarToUser(ferrari);
      System.out.println(user1.getCar().getName());
      userService.add(user1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car ford = new Car("Ford", 2);
      ford.setUser(user2);
      user2.addCarToUser(ford);
      userService.add(user2);


      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car lada = new Car("Lada", 5);
      lada.setUser(user3);
      user3.addCarToUser(lada);
      userService.add(user3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car yaz = new Car("Yaz", 4);
      yaz.setUser(user3);
      user4.addCarToUser(yaz);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
