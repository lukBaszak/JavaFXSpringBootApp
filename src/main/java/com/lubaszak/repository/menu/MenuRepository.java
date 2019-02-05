package com.lubaszak.repository.menu;

import com.lubaszak.model.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu[] findByWeight(int weight);

}
