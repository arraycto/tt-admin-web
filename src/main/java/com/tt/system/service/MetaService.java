package com.tt.system.service;

import com.tt.system.model.Column;
import com.tt.system.model.Table;
import com.tt.system.vo.ColumnVO;
import com.tt.system.vo.TableVO;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

public interface MetaService {

    List<Table> listTable(TableVO tableVO);

    List<Column> listColumn(ColumnVO columnVO);

    List<Map<String, Object>> querySql(String sql);

    ByteArrayOutputStream generateCode(TableVO tableVO);
}
