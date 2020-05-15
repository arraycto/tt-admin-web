package com.tt.system.service;

import com.tt.system.vo.UserVO;
import com.tt.system.model.User;

import java.util.List;

public interface UserService {

	User findById(Integer id);

	List<UserVO> findByCondition(UserVO userVO);

	void save(UserVO userVO);

	void update(UserVO userVO);

	void deleteById(Integer id);

	/**
	 * 根据用户名查询
	 * @param username
	 * @return
	 */
	UserVO findByUsername(String username);

    void updateCurrentUser(UserVO userVO);
}
