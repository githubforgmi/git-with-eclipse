package keyword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import wrappers.GenericWrappers;

public class CallWrappersUsingKeyword extends GenericWrappers {


	public void getAndCallKeyword(String fileName) throws Exception{
		
		FileInputStream file = new FileInputStream(new File(fileName));
		
		
		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		
		Class<GenericWrappers> wrapper = GenericWrappers.class;
	    Object wM = wrapper.newInstance();
	    
		// Get first/desired sheet from the workbook
		XSSFSheet sh = workbook.getSheetAt(0);
		
		for (int i = 1; i <= sh.getLastRowNum(); i++) {

			String keyword = "" ;
			String locator = "" ;
			String data = "" ;
			try {
				keyword = sh.getRow(i).getCell(2).getStringCellValue();
				locator = sh.getRow(i).getCell(3).getStringCellValue();
				data = sh.getRow(i).getCell(4).getStringCellValue();
			} catch (NullPointerException e) {
				// ignore
			}
			
			
			Method[] methodName = wrapper.getDeclaredMethods();
			
			for (Method method : methodName) {
				
				if(method.getName().toLowerCase().equals(keyword.toLowerCase())){

					if(locator.equals("") && data.equals("")){
							boolean a=(Boolean) method.invoke(wM);
							if(a)
							sh.getRow(i).getCell(5).setCellValue("pass");
							else
								sh.getRow(i).getCell(5).setCellValue("fail");
					}
					else if(locator.equals("")){
						boolean b=(Boolean)method.invoke(wM,data);
						if(b)
							sh.getRow(i).getCell(5).setCellValue("pass");
						else
							sh.getRow(i).getCell(5).setCellValue("fail");
					}
					else if(data.equals("")){
						boolean c=(Boolean)method.invoke(wM,locator);
						if(c)
						sh.getRow(i).getCell(5).setCellValue("pass");
						else
							sh.getRow(i).getCell(5).setCellValue("fail");
					}
					else{
						boolean d=(Boolean)method.invoke(wM,locator,data);
						System.out.println("d:before if:"+d);
						if(d){
							System.out.println("d"+d);
						sh.getRow(i).getCell(5).setCellValue("pass");
						}
						else
							sh.getRow(i).getCell(5).setCellValue("fail");
					}
					
					// go out of for
					break;

				}				
			}			
		}
		
		
		file.close();
		FileOutputStream fileOut = new FileOutputStream(fileName);
		workbook.write(fileOut);
		fileOut.close();
		
	}
}
