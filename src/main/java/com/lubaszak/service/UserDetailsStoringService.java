package com.lubaszak.service;

import com.lubaszak.bean.UserDetails;



public interface UserDetailsStoringService {

    public UserDetails getUserMeasurement();
    public void saveUserMeasurement(UserDetails userDetails);

}
