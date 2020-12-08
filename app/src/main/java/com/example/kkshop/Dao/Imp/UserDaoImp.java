package com.example.kkshop.Dao.Imp;


import com.example.kkshop.Dao.UserDao;
import com.example.kkshop.Po.User;
import com.example.kkshop.Utils.logUtil;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {

    private static final String TAG = "UserDaoImp";
    private static UserDao userDao=null;


    @Override
    public boolean InitDb() {
        LitePal.getDatabase();
        return true;
    }


    @Override
    public boolean addUser(User user) {
        user.save();
        try{
        }catch (Exception e){
            logUtil.e(TAG,"addUser");
            return false;
        }
        return true;
    }

    @Override
    public User findUserById(int Id) {
        User user=null;
        user=LitePal.find(User.class,Id);
        return user;
    }

    @Override
    public User findUserByPhone(String phone) {
        User user=null;
        List<User> list=new ArrayList();
        logUtil.e(TAG,"phone"+phone);
        list=LitePal.where(" phone = ? ",phone).find(User.class);
        for(User temp:list){
            user=temp;
        }
        return user;
    }

    @Override
    public User findUserByEmail(String Email) {
        User user=null;
        List<User> list=new ArrayList();
        list=LitePal.where("Email = ?",Email).find(User.class);

        for(User temp:list){
            user=temp;
        }
        return user;
    }


    @Override
    public boolean deleteUser(User user) {
        try{
            LitePal.delete(User.class,user.getId());
        }catch (Exception e){
            logUtil.e(TAG,"deleteUser");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        try{
            user.update(user.getId());
        }catch (Exception e){
            logUtil.e(TAG,"updateUser");
            return false;
        }
        return true;
    }



}
