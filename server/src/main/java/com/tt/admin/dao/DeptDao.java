package com.tt.admin.dao;

import com.tt.admin.model.Dept;
import com.tt.admin.vo.DeptVO;

import java.util.List;

public interface DeptDao {

	Dept findById(Integer id);

	List<DeptVO> findByCondition(DeptVO deptVO);

	void save(Dept user);

	int update(Dept user);

	int deleteById(Integer id);
}
