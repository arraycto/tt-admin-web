package com.tt.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.tt.admin.dao.LogDao;
import com.tt.admin.model.Log;
import com.tt.admin.service.LogService;
import com.tt.admin.vo.LogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;

	@Override
	public Log findById(Integer id) {
		return logDao.findById(id);
	}

	@Override
	public List<Log> findByCondition(LogVO logVO) {
		PageHelper.startPage(logVO.getPageNum(), logVO.getPageSize());
		return logDao.findByCondition(logVO);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(Log log) {
		logDao.save(log);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(Log log) {
		logDao.update(log);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteById(Integer id) {
		logDao.deleteById(id);
	}

	@Override
	public List<Log> findAll(LogVO logVO) {
		return logDao.findByCondition(logVO);
	}
}
