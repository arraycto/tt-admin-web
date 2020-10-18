package com.tt.admin.dao;


import com.tt.admin.model.Log;
import com.tt.admin.vo.LogVO;

import java.util.List;

public interface LogDao {

    Log findById(Integer id);

    List<Log> findByCondition(LogVO logVO);

    void save(Log log);

    int update(Log log);

    int deleteById(Integer id);

}