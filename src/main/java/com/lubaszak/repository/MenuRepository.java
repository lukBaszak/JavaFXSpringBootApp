package com.lubaszak.repository;

import com.lubaszak.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu[] findAllByDateAndAndUser(Date date, String user);


}
