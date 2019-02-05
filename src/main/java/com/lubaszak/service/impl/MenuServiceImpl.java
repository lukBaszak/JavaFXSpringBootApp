package com.lubaszak.service.impl;

import com.lubaszak.model.menu.Menu;
import com.lubaszak.repository.menu.MenuRepository;
import com.lubaszak.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;



    @Override
    public Menu save(Menu entity) {
        return menuRepository.save(entity);
    }

    @Override
    public Menu update(Menu entity) {
        return null;
    }

    @Override
    public void delete(Menu entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteInBatch(List<Menu> entities) {

    }

    @Override
    public Menu find(Integer id) {
        return null;
    }

    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    public Menu[] findByWeight(int weight) {
      return menuRepository.findByWeight(weight);
    }
}
