package com.tt.system.dao;

import com.tt.system.vo.DeptVO;
import com.tt.system.model.Dept;

import java.util.List;

public interface DeptDao {

	Dept findById(Integer id);

	List<DeptVO> findByCondition(DeptVO deptVO);

	void save(Dept user);

	int update(Dept user);

	int deleteById(Integer id);
}
