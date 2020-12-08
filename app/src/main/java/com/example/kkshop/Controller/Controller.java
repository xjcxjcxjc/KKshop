package com.example.kkshop.Controller;

import com.example.kkshop.Dao.Imp.LocationDaoImp;
import com.example.kkshop.Dao.Imp.UserDaoImp;
import com.example.kkshop.Dao.LocationDao;
import com.example.kkshop.Dao.UserDao;
import com.example.kkshop.Po.DeliverLocation;
import com.example.kkshop.Po.User;


import java.util.List;

public class Controller {
    private static User user;
    private static DeliverLocation defaultlocation;

    //提供对user的数据操作
    private static UserDao userDao;
    //提供对DeliverLocation的数据操作
    private static LocationDao locationDao;

    public static void setUser(User user) {
        Controller.user = user;
    }

    public static DeliverLocation getDefaultlocation() {
        return defaultlocation;
    }

    public static void setDefaultlocation(DeliverLocation defaultlocation) {
        Controller.defaultlocation = defaultlocation;
    }

    //单例模式
    private static Controller controller =null;

    public static Controller Instance() {
        if(controller ==null){
            controller =new Controller();
            userDao=new UserDaoImp();
            locationDao=new LocationDaoImp();
        }
        return controller;
    }

    public static User getUser() {
        return user;
    }


    //登陆
    public static final int UserNotExist=-1;
    public static final int PasswordError=-2;
    public static final int LoginSuccess=1;

    /**
     * @param arg1  User's phone or Email
     * @param password pd
     * @return 返回登陆的状态
     */
    public int Login(String arg1,String password){
        User finduser ;
        if(arg1.contains("@")){
            finduser=userDao.findUserByEmail(arg1);
        }else{
            finduser=userDao.findUserByPhone(arg1);
        }
        if(finduser==null)
            return UserNotExist;

        if(!password.equals(finduser.getPassword()))
            return PasswordError;

        user=finduser;
        List<DeliverLocation> locations=locationDao.findAllLocationsByUserId(user.getId());
        for (DeliverLocation deliverLocation:locations){
            if (deliverLocation.getIsdefault()==1){
                defaultlocation=deliverLocation;
            }
        }

        return LoginSuccess;
    }

    //注册
    public static final int PhoneExist=-1;
    public static final int EmailExist=-2;
    public static final int RegisterSuccess=1;
    /**
     * 注册
     * @return 返回注册的状态
     */
    public int  Register(User user){
        User finduser;
        finduser=userDao.findUserByEmail(user.getEmail());
        if (finduser!=null)
            return EmailExist;

        finduser=userDao.findUserByPhone(user.getPhone());
        if (finduser!=null)
            return PhoneExist;

        userDao.addUser(user);
        return RegisterSuccess;
    }



    public List<DeliverLocation> provideLocations(){
        return locationDao.findAllLocationsByUserId(user.getId());
    }


    /**
     * 添加location
     * @param newdeliverLocation 要添加的location
     */
    public void addLocation(DeliverLocation newdeliverLocation){

        newdeliverLocation.setUser_id(user.getId());
        locationDao.addLocation(newdeliverLocation);
        /*
         * 如果是默认地址就修改conroller中的默认地址
         */
        if(newdeliverLocation.getIsdefault()==1){
            if (defaultlocation!=null){

                //这里updatelocation的时候总是不能update它的isdefault属性，所以这里直接删了，然后重新插入。
                DeliverLocation location=defaultlocation;
                location.setIsdefault(0);
                location.setId(0);
                locationDao.delteLocation(defaultlocation);
                locationDao.addLocation(location);
            }
            defaultlocation=newdeliverLocation;
        }
    }

    
    /**
     *  更新location
     * @param newdeliverLocation 要更新的location
     */
    public void updateLocation(DeliverLocation newdeliverLocation){
        List<DeliverLocation> deliverLocations= provideLocations();

        for(DeliverLocation location:deliverLocations){
            if(location.getId()==newdeliverLocation.getId()){
                locationDao.delteLocation(location);
            }
        }
        addLocation(newdeliverLocation);
    }
}
