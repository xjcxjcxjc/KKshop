package com.example.kkshop.Dao;

import com.example.kkshop.Po.DeliverLocation;
import com.example.kkshop.Po.User;

public interface UserDao {

    User findUserById(int Id);
    User findUserByPhone(String phone);
    User findUserByEmail(String Email);
    boolean addUser(User user);
    boolean deleteUser(User user);
    boolean updateUser(User user);
    boolean InitDb();

}
