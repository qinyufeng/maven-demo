package com.qyf.maven_demo.utils.outputExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.ObjectUtils;

public class OutputExcelModel {
	OutputStream os;
	
	private Integer irow = -1; // 记录行
    HSSFWorkbook wb = new HSSFWorkbook();  //第一步创建workbook                
    HSSFSheet sheet = wb.createSheet("测试"); //第二步创建sheet 
    HSSFRow row ;     //第三步创建行row 
    
    public OutputExcelModel() {
    }
    public OutputExcelModel(HttpServletResponse response, String fileName, String sheetName) throws IOException {
    }
	
    /**
     * 设置表头
     * @param excelTitle
     */
	public void setExcelTitle(String[] excelTitle) {
		irow++;
		//添加表头0行 
		row= sheet.createRow(irow);
		int i=0;
		for(String cellValue:excelTitle){
	        //第四步创建单元格  			
	        HSSFCell cell = row.createCell(i); //第一个单元格  
			cell.setCellValue(cellValue); 
			i++;
		}
	}
	/**
	 * 添加行
	 * @param rowData
	 */
	public void addRow(String[] rowData) {

		irow++;
		row = sheet.createRow(irow); 
		int i=0;
		for(String cellValue:rowData){			
	        HSSFCell cell = row.createCell(i);
			cell.setCellValue(cellValue); 
			i++;
		}
	}
	/**
	 * 导出excel到指定路径
	 * @param url 文件保存的路径和文件名
	 * @param fileType文件类型
	 */
	public void loadExcel(String url,String fileType) throws IOException{
    	if(ObjectUtils.isEmpty(fileType)) {
    		fileType=".xls";
    	}else if(fileType.equals(".xls")) {
    		fileType=".xls";
    	}else if(fileType.equals(".xlsx")) {
    		fileType=".xlsx";
    	}else if(fileType.equals(".et")) {
    		fileType=".et";
    	}else if(fileType.equals(".csv")) {
    		fileType=".csv";
    	}else {
    		fileType=".xls";
    	}
    	
       os = new FileOutputStream(url+fileType);
        wb.write(os);
        os.close();
        
        System.out.println("Excel文件生成成功..."); 

	}
}
