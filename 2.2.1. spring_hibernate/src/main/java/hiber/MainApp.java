package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Раби", "Ицхак", "rabiIchak@mail.ru", new Car("Mercedes-benz", 1)));
        userService.add(new User("Мордехай", "Элияху", "mordehayElyiahuuser2@mail.ru", new Car("Tesla", 1)));
        userService.add(new User("Псой", "Короленко", "psoyKorolenko3@mail.ru", new Car("Ferrari", 1)));
        userService.add(new User("Иван", "Иванов", "ivanIvanovIvanovich@mail.ru", new Car("jiguli", 2107)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println();
        }

        List <User> userTest = userService.getUserByCar("jiguli", 2107);
        System.out.println(userTest);

        context.close();
    }
}
