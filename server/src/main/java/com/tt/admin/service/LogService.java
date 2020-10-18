package com.tt.admin.service;


import com.tt.admin.model.Log;
import com.tt.admin.vo.LogVO;

import java.util.List;

public interface LogService {

    Log findById(Integer id);

    List<Log> findByCondition(LogVO logVO);

    void save(Log user);

    void update(Log user);

    void deleteById(Integer id);

    List<Log> findAll(LogVO logVO);

}