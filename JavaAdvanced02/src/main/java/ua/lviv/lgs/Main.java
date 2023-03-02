package ua.lviv.lgs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<User> userList = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        userList.add(new User("Діма", "Тетеренко", "dima@gmail.com", "555", "user"));
        userList.add(new User("Остап", "Нечипуренко", "ostap@gmail.com", "555", "user"));
        userList.add(new User("Руслан", "Ярич", "rus@gmail.com", "555", "user"));
        userList.add(new User("Ігор", "Бук", "bug@gmail.com", "555", "user"));
        userList.add(new User("Руся", "Шевченко", "br@gmail.com", "555", "user"));
        userList.add(new User("Марина", "Тарасенко", "mar@gmail.com", "555", "user"));
        userList.forEach(user -> {
            try {
                userDAO.insert(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
                        user.getAccessLevel());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        userDAO.delete(6);

        FilmDAO filmDAO = new FilmDAO();
        List<Film> filmList = new ArrayList<>();

        filmList.add(new Film("Avatar", "Detailed description", LocalDate.parse("2023-04-03"), 1050));
        filmList.add(new Film("Spider-Man", "Detailed description", LocalDate.parse("2023-04-03"), 1050));
        filmList.add(new Film("Top Gun", "Detailed description", LocalDate.parse("2023-04-03"), 1050));
        filmList.add(new Film("Jurassic World", "Detailed description", LocalDate.parse("2023-04-03"), 1050));
        filmList.add(new Film("Hi, Mom", "Detailed description", LocalDate.parse("2023-04-03"), 1050));
        filmList.add(new Film("Black Panther", "Detailed description", LocalDate.parse("2023-04-03"), 1050));
        filmList.add(new Film("The Batman", "Detailed description", LocalDate.parse("2023-04-03"), 1050));

        filmList.forEach(film -> {
            try {
                filmDAO.insert(film.getTitle(), film.getDescription(), film.getDate(), film.getPrice());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        userDAO.updateByLastName("Остапус", "Нечипуренко", "ostap@gmail.com", "55577", "userMain");
        filmDAO.delete("The Batman");
        SubscribeDAO subscribeDAO = new SubscribeDAO();
        System.out.println(subscribeDAO.insert(3, 2, true, LocalDate.parse("2023-03-01"), 12));
        System.out.println(subscribeDAO.insert(4, 3, true, LocalDate.parse("2023-03-01"), 12));
        System.out.println(subscribeDAO.insert(5, 4, true, LocalDate.parse("2023-03-01"), 12));

        userDAO.readAll().forEach(System.out::println);
        filmDAO.readAll().forEach(System.out::println);
        subscribeDAO.readAll().forEach(System.out::println);
    }
}
