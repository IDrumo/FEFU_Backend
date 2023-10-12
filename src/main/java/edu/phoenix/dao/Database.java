package edu.phoenix.dao;

import edu.phoenix.SuperExeption;
import edu.phoenix.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<User> dataBase = new ArrayList<>();

    public static void addUser(String name, String login, String password) throws SuperExeption {
        try {
            if (login.equals(""))
                throw new SuperExeption("Пустая строка не может быть логином");
        } catch (SuperExeption e) {
            System.out.println(e.getMessage());
        }

        try {
            if (getUser(login, password) != null)
                throw new SuperExeption("Пользователь уже есть");
            else
                dataBase.add(new User(name, login, password));
        } catch (SuperExeption e) {
            System.out.println(e.getMessage());
        }
    }

    public static User getUser(String login, String password) throws SuperExeption {
        try {
            for (User user : dataBase) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password))
                    return user;
            }
            throw new SuperExeption("Такого пользователя нет");
        } catch (SuperExeption e) {
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
