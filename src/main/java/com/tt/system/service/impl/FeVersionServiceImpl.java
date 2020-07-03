package com.tt.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.tt.system.dao.FeVersionDao;
import com.tt.system.handler.UserHandler;
import com.tt.system.model.FeVersion;
import com.tt.system.service.FeVersionService;
import com.tt.system.vo.FeVersionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FeVersionServiceImpl implements FeVersionService {

    @Autowired
    private FeVersionDao feVersionDao;

    @Override
    public FeVersion findById(Integer id) {
        return feVersionDao.findById(id);
    }

    @Override
    public List<FeVersion> findByCondition(FeVersionVO feVersionVO) {
        PageHelper.startPage(feVersionVO.getPageNum(), feVersionVO.getPageSize());
        return feVersionDao.findByCondition(feVersionVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(FeVersion feVersion) {
        feVersion.setCreateTime(new Date());
        feVersion.setCreateUser(UserHandler.getCurrentUser().getUsername());
        feVersion.setUpdateTime(new Date());
        feVersionDao.save(feVersion);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(FeVersion feVersion) {
        feVersion.setUpdateTime(new Date());
        feVersionDao.update(feVersion);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        feVersionDao.deleteById(id);
    }

    @Override
    public List<FeVersion> findAll(FeVersionVO feVersionVO) {
        return feVersionDao.findByCondition(feVersionVO);
    }

}
