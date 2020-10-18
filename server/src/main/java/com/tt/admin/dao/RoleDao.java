package com.tt.admin.dao;

import com.tt.admin.model.Role;

import java.util.List;

public interface RoleDao {

	Role findById(Integer id);

	List<Role> findByCondition(Role user);

	void save(Role user);

	int update(Role user);

	int deleteById(Integer id);

}
