package com.tt.admin.service;


import com.tt.admin.model.Dept;
import com.tt.admin.vo.DeptVO;

import java.util.List;


public interface DeptService {

	Dept findById(Integer id);

	List<DeptVO> findByCondition(DeptVO deptVO);

	void save(Dept dept);

	void update(Dept dept);

	void deleteById(Integer id);

    List<DeptVO> findAll(DeptVO deptVO);
}
