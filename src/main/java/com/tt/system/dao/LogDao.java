package com.tt.system.dao;


import com.tt.system.model.Log;
import com.tt.system.vo.LogVO;

import java.util.List;

public interface LogDao {

    Log findById(Integer id);

    List<Log> findByCondition(LogVO logVO);

    void save(Log log);

    int update(Log log);

    int deleteById(Integer id);

}