package com.tt.admin.service;

import com.tt.admin.model.Role;
import com.tt.admin.model.RoleMenu;
import com.tt.admin.vo.RoleVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

	Role findById(Integer id);

	List<Role> findByCondition(RoleVO roleVO);

	void save(Role user);

	void update(Role user);

	void deleteById(Integer id);

    List<RoleMenu> getRoleMenu(RoleMenu roleMenu);

	void addMenuPermission(RoleVO roleVO);

	List<Role> findAll(RoleVO roleVO);
}
