package com.tt.system.dao;

import com.tt.system.vo.UserVO;
import com.tt.system.model.User;

import java.util.List;


public interface UserDao {

	User findById(Integer id);

	List<UserVO> findByCondition(UserVO userVO);

	void save(User user);
	
	int update(User user);
	
	int deleteById(Integer id);
}
