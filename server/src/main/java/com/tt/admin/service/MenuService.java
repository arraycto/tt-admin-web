package com.tt.admin.service;

import com.tt.admin.model.Menu;
import com.tt.admin.vo.MenuVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {

	Menu findById(Integer id);

	List<MenuVO> findByCondition(MenuVO menuVO);

	void save(Menu user);

	void update(Menu user);

	void deleteById(Integer id);

    List<MenuVO> findAll(MenuVO menuVO);

	List<MenuVO> getPermissionList(MenuVO menuVO);
}
