package com.lubaszak.service;

import com.lubaszak.model.Menu;

import java.util.Date;

public interface MenuService extends GenericService<Menu> {

    Menu[] findByDateAndUserID(Date date, int userID);



}
