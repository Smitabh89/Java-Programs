import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel 
{
	@Test
	public void getdata() throws IOException
	  {
		FileInputStream fs=new FileInputStream("C:\\Users\\santo\\OneDrive\\Desktop\\Database1.xlsx");
		XSSFWorkbook xs=new XSSFWorkbook(fs);  //WorkBook
		XSSFSheet sheet=xs.getSheetAt(0);      //select Sheet
		int rowcount=sheet.getPhysicalNumberOfRows(); // Row Count here
		System.out.println(rowcount);
		XSSFRow row=sheet.getRow(0);        // select one Row
		int colcount=row.getLastCellNum();  //Column Count here
		
		Object data[][]=new Object[rowcount-1][colcount];
		for(int i=0;i<rowcount-1;i++)
		{
			row=sheet.getRow(i+1);
			for(int j=0;j<colcount;j++)
			{
				data[i][j]=row.getCell(j);
				System.out.println(data[i][j]);
			}
		}
	  }
}
