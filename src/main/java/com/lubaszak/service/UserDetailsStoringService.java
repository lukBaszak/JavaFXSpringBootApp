package com.lubaszak.service;

import com.lubaszak.bean.UserDetail;



public interface UserDetailsStoringService {

    public UserDetail getUserMeasurement();
    public void saveUserMeasurement(UserDetail userDetail);

}
