package com.tt.system.dao;

import com.tt.system.model.FeVersion;
import com.tt.system.vo.FeVersionVO;

import java.util.List;

public interface FeVersionDao {

    FeVersion findById(Integer id);

    List<FeVersion> findByCondition(FeVersionVO feVersionVO);

    void save(FeVersion user);

    int update(FeVersion user);

    int deleteById(Integer id);

}