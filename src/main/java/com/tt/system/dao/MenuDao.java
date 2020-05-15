package com.tt.system.dao;

import com.tt.system.vo.MenuVO;
import com.tt.system.model.Menu;

import java.util.List;

public interface MenuDao {

	Menu findById(Integer id);

	List<MenuVO> findByCondition(MenuVO menuVO);

	void save(Menu user);

	int update(Menu user);

	int deleteById(Integer id);

    List<MenuVO> findPermissionMenu(MenuVO menuVO);
}
