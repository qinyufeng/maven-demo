package com.qyf.maven_demo.utils.outputExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SimpleExcelWrite {
    public static void main(String[] args) {
         
         //第一步创建workbook  
         HSSFWorkbook wb = new HSSFWorkbook();  
           
         //第二步创建sheet  
         HSSFSheet sheet = wb.createSheet("测试");  
           
         //第三步创建行row:添加表头0行  
         HSSFRow row = sheet.createRow(0);  
         HSSFCellStyle  style = wb.createCellStyle();      
         //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
           
           
         //第四步创建单元格  
         HSSFCell cell = row.createCell(0); //第一个单元格  
         cell.setCellValue("姓名");  
         cell.setCellStyle(style);  
         
         
         
         cell = row.createCell(1);         //第二个单元格     
         cell.setCellValue("年龄");  
         cell.setCellStyle(style);  
           
        
         //第五步插入数据  
        
         for (int i = 0; i < 5; i++) {  
             //创建行  
             row = sheet.createRow(i+1);  
             //创建单元格并且添加数据  
             row.createCell(0).setCellValue("aa"+i);  
             row.createCell(1).setCellValue(i);  
             
         }  
           
         //第六步将生成excel文件保存到指定路径下  
         try {  
             FileOutputStream fout = new FileOutputStream("E:\\qyf\\a.xls");  
             wb.write(fout);  
             fout.close();  
             System.out.println("Excel文件生成成功...");  
         } catch (IOException e) {  
             e.printStackTrace();  
             System.out.println("Excel文件生成失败：."+ e.getMessage());  
         }  
           

     }  
}
