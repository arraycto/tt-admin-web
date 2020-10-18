package com.tt.admin.service;

import com.tt.admin.model.User;
import com.tt.admin.vo.UserVO;

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
