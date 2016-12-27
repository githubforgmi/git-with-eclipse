package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class excelusing_jxl<WorkBook> {
	
	FileInputStream f =null;
	Workbook  wb=null;
	Sheet sh=null;
  @Test
  public void f() throws Exception {
	  
	   f = new FileInputStream("./Testdata/DM_Testdata.xls");
	   wb=Workbook.getWorkbook(f);
	   sh=wb.getSheet(0);
	  int rows=sh.getRows();
	  int cols=sh.getColumns();
	  System.out.println("a:"+sh.getCell(1,0).getContents());
	  System.out.println(sh.getCell(1,0).getRow());
	  
	  System.out.println("rows:"+rows);
	  
	  List<String> list=new ArrayList<String>();
	  
	  List<String> list2=new ArrayList<String>();
	  
	  list2.equals(list);
	  
	  
	  for(int i=0;i<rows;i++){
		  System.out.println(sh.getCell(0, i).getContents());
		  String s=sh.getCell(0, i).getContents();
		  if(s!=null&&s.length()>0)
		  list.add(sh.getCell(0, i).getContents());
		  
	  }
	  
	  System.out.println("list size:"+list.size());
	  
	  
	  
	  
  }
}
