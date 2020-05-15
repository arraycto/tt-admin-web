package com.tt.system.service;

import com.tt.system.vo.RoleVO;
import com.tt.system.model.Role;
import com.tt.system.model.RoleMenu;
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
