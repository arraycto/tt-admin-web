package com.tt.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.tt.admin.dao.FeVersionDao;
import com.tt.admin.handler.UserHandler;
import com.tt.admin.model.FeVersion;
import com.tt.admin.service.FeVersionService;
import com.tt.admin.vo.FeVersionVO;
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
