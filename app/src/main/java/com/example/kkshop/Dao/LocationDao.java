package com.example.kkshop.Dao;

import com.example.kkshop.Po.DeliverLocation;

import java.util.List;

public interface LocationDao {

    boolean addLocation(DeliverLocation location);
    boolean updateLocation(DeliverLocation location);
    boolean delteLocation(DeliverLocation location);

    DeliverLocation findLocationById(int id);
    List<DeliverLocation> findAllLocationsByUserId(int user_id);

}
