package utility;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelUtils {
	
	   private static HSSFSheet ExcelWSheet;
 	   private static HSSFWorkbook ExcelWBook;
   	   private static HSSFCell Cell;
   
   	   public static void setExcelFile(String Path,String SheetName) throws Exception 
         {
        
    	  try {

// Open the Excel file
               FileInputStream ExcelFile = new FileInputStream(Path);
// Access the required test data sheet
			   ExcelWBook = new HSSFWorkbook(ExcelFile);
               ExcelWSheet = ExcelWBook.getSheet(SheetName);
			  } catch (Exception e){
                    throw (e); }
           }
	
       public static String getCellData(int RowNum, int ColNum) throws Exception
	     {
        try{
      	   ExcelWBook.getCreationHelper().createFormulaEvaluator().evaluateAll();
      	   Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
      	   String CellData = Cell.getStringCellValue().trim();
			   return CellData;
            } catch (Exception e)
             		{
                   return" "; 
             		 }
	      }
	
  }