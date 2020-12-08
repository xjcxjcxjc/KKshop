package com.example.kkshop.Dao.Imp;


import com.example.kkshop.Dao.LocationDao;
import com.example.kkshop.Po.DeliverLocation;

import org.litepal.LitePal;

import java.util.List;

public class LocationDaoImp implements LocationDao {

    @Override
    public boolean addLocation(DeliverLocation location) {
        location.save();
        return true;
    }

    @Override
    public boolean updateLocation(DeliverLocation location) {
        location.update(location.getId());
        return true;
    }

    @Override
    public boolean delteLocation(DeliverLocation location) {
        LitePal.delete(DeliverLocation.class,location.getId());
        return true;
    }

    @Override
    public DeliverLocation findLocationById(int id) {
        return LitePal.find(DeliverLocation.class,id);
    }

    @Override
    public List<DeliverLocation> findAllLocationsByUserId(int user_id) {
        return LitePal.where("user_id = ?",Integer.toString(user_id)).find(DeliverLocation.class);
    }
}
