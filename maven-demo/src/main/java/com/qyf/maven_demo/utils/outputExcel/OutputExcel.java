package com.qyf.maven_demo.utils.outputExcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author qinyufeng
 * @since 2018-11-22
 * 导出Excel
 */
public class OutputExcel {
	public static void main(String[] args) {
		OutputExcelModel excelModel=new OutputExcelModel();
		//前端参数
		String[] excelTitle=getExcelTitle();
		 Map<String,Integer> columnSort=getColumnSort();
		excelModel.setExcelTitle(excelTitle);
		
		List<Map<String,Object>> list=getTestData();
		Set<Entry<String, Integer>> entrySet=columnSort.entrySet();
		List<String> keys = new ArrayList<>();
		for(Entry<String,Integer> entry:entrySet) {
			keys.add(entry.getKey());
		}
		for (Map<String,Object> map:list) {

			String[] rowData = new String[excelTitle.length];
			
			for(String key:keys) {
				rowData[columnSort.get(key)] = map.get(key).toString();
			}
			excelModel.addRow(rowData);
		}
		//支持.xls  .xlsx  .et   .csv 格式
		try {
			excelModel.loadExcel("E:\\qyf\\b5",".xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	private static String[] getExcelTitle() {
		String[] excelTitle = {"计量标准号","物料号","物料描述","计量标准描述","工序"};//excel表头列名
		return excelTitle;
	}
	private static Map<String,Integer> getColumnSort(){
		Map<String,Integer> columnSort=new HashMap<>();//字段的列顺序
		columnSort.put("key1", 1);
		columnSort.put("key2", 2);
		columnSort.put("key3", 3);
		columnSort.put("key4", 4);
		columnSort.put("key5", 0);
		return columnSort;
	}
	private static List<Map<String,Object>> getTestData(){
		
		List<Map<String,Object>> list=new ArrayList<>();
		for(int i=0;i<5;i++) {
			Map<String,Object> map=new HashMap<>();
			map.put("key1", "test1");
			map.put("key2", "test2");
			map.put("key3", "test3");
			map.put("key4", "test4");
			map.put("key5", "test5");
			list.add(map);
		}
		return list;
	}
}
