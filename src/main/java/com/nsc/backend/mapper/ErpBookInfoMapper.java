package com.nsc.backend.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nsc.backend.entity.ErpBookInfo;


public interface ErpBookInfoMapper {
	
         public  List<ErpBookInfo> selData();
         
         public void insert(@Param("list")List<  ErpBookInfo > list);
         
         /*public  Map<String, Object> selData2();
         
         public void insert2(Map<String, Object> list);*/
}
