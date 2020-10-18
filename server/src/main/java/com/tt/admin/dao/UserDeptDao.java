package com.tt.admin.dao;

import com.tt.admin.model.UserDept;


public interface UserDeptDao {

	UserDept findByUserId(Integer userId);

	void save(UserDept user);

	void update(UserDept user);

	void deleteById(Integer id);

	void deleteByUserId(Integer userId);
}
