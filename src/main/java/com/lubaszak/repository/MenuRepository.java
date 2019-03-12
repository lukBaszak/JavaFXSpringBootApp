package com.lubaszak.repository;

import com.lubaszak.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu[] findAllByDateAndUserID(Date date, int userId);


}
