package com.tt.admin.service;

import com.tt.admin.model.Column;
import com.tt.admin.model.Table;
import com.tt.admin.vo.ColumnVO;
import com.tt.admin.vo.TableVO;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

public interface MetaService {

    List<Table> listTable(TableVO tableVO);

    List<Column> listColumn(ColumnVO columnVO);

    List<Map<String, Object>> querySql(String sql);

    ByteArrayOutputStream generateCode(TableVO tableVO);
}
