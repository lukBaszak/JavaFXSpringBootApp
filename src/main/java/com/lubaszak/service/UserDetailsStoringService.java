package com.lubaszak.service;

import com.lubaszak.model.UserDetail;

import java.time.LocalDate;


public interface UserDetailsStoringService {

    public UserDetail getUserMeasurement();
    public void saveUserMeasurement(UserDetail userDetail);

}
