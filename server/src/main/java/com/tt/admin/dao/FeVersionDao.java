package com.tt.admin.dao;

import com.tt.admin.model.FeVersion;
import com.tt.admin.vo.FeVersionVO;

import java.util.List;

public interface FeVersionDao {

    FeVersion findById(Integer id);

    List<FeVersion> findByCondition(FeVersionVO feVersionVO);

    void save(FeVersion user);

    int update(FeVersion user);

    int deleteById(Integer id);

}