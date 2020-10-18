package com.tt.admin.dao;

import com.tt.admin.model.Menu;
import com.tt.admin.vo.MenuVO;

import java.util.List;

public interface MenuDao {

	Menu findById(Integer id);

	List<MenuVO> findByCondition(MenuVO menuVO);

	void save(Menu user);

	int update(Menu user);

	int deleteById(Integer id);

    List<MenuVO> findPermissionMenu(MenuVO menuVO);
}
