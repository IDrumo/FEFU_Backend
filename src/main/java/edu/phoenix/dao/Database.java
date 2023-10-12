package edu.phoenix.dao;

import edu.phoenix.SuperExeption;
import edu.phoenix.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<User> dataBase = new ArrayList<>();

    public static void addUser(String name, String login, String password) throws Exception {
        try {
            if (login.equals(""))
                throw new Exception("Пустая строка не может быть логином");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getUser(login, password);
        } catch (Exception e) {
            dataBase.add(new User(name, login, password));
        }
    }

    public static User getUser(String login, String password) throws Exception {
        try {
            for (User user : dataBase) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password))
                    return user;
            }
            throw new Exception("Такого пользователя нет");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void deleteUser(String login) {
        for (User user : dataBase) {
            if (user.getLogin().equals(login)) {
                dataBase.remove(user);
                return;
            }
        }
    }

    public static void updateUser(User user) throws SuperExeption {
        try {
            if (user.getName().equals("Гитлер"))
                throw new SuperExeption("Осуждаю");
            for (User user_from_array : dataBase) {
                if (user_from_array.getName().equals(user.getName())) {
                    user_from_array.setLogin(user.getLogin());
                    user_from_array.setPassword(user.getPassword());
                    return;
                }
            }
        } catch (SuperExeption e) {
            System.out.println(e.getMessage());
        }
    }

}
