package com.tt.admin.dao;

import com.tt.admin.model.UserRole;

import java.util.List;

public interface UserRoleDao {

	UserRole findById(Integer id);

	List<UserRole> findByCondition(UserRole user);

	void save(UserRole user);

	int update(UserRole user);

	int deleteById(Integer id);

    UserRole findByUserId(Integer id);
}
