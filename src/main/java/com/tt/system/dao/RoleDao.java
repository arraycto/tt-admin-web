package com.tt.system.dao;

import com.tt.system.model.Role;

import java.util.List;

public interface RoleDao {

	Role findById(Integer id);

	List<Role> findByCondition(Role user);

	void save(Role user);

	int update(Role user);

	int deleteById(Integer id);

}
