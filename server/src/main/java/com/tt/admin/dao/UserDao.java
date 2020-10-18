package com.tt.admin.dao;

import com.tt.admin.model.User;
import com.tt.admin.vo.UserVO;

import java.util.List;


public interface UserDao {

	User findById(Integer id);

	List<UserVO> findByCondition(UserVO userVO);

	void save(User user);
	
	int update(User user);
	
	int deleteById(Integer id);
}
