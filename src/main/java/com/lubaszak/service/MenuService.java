package com.lubaszak.service;

import com.lubaszak.model.menu.Menu;

import java.util.Date;

public interface MenuService extends GenericService<Menu> {

    Menu[] findByDate(Date date);
}
