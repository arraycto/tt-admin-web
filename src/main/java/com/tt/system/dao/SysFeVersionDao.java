package com.tt.system.dao;

import com.tt.system.vo.SysFeVersionVO;
import com.tt.system.model.SysFeVersion;

import java.util.List;

public interface SysFeVersionDao {

    SysFeVersion findById(Integer id);

    List<SysFeVersion> findByCondition(SysFeVersionVO sysFeVersionVO);

    void save(SysFeVersion user);

    int update(SysFeVersion user);

    int deleteById(Integer id);

}