package com.tt.system.service;


import com.tt.system.vo.DeptVO;
import com.tt.system.model.Dept;

import java.util.List;


public interface DeptService {

	Dept findById(Integer id);

	List<DeptVO> findByCondition(DeptVO deptVO);

	void save(Dept dept);

	void update(Dept dept);

	void deleteById(Integer id);

    List<DeptVO> findAll(DeptVO deptVO);
}
