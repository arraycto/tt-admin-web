package com.tt.system.service;

import com.tt.system.model.FeVersion;
import com.tt.system.vo.FeVersionVO;

import java.util.List;

public interface FeVersionService {

    FeVersion findById(Integer id);

    List<FeVersion> findByCondition(FeVersionVO feVersionVO);

    void save(FeVersion user);

    void update(FeVersion user);

    void deleteById(Integer id);

    List<FeVersion> findAll(FeVersionVO feVersionVO);

}