package practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TXTDataToExcel {

	public static void main(String[] args) throws Exception {

		
		
		
		File file1 = new File("C:\\Users\\devdutt.jadeja\\Desktop\\TEMP\\Release_Notes_Excel_Format\\ReleaseNote_2.2.txt");

		int i = 0;
		Scanner scanner = new Scanner(file1);

		while (scanner.hasNextLine()) {
			
			String nextLine = scanner.nextLine();
			System.out.println(nextLine);
			
			
			if(nextLine.startsWith("Author")) {
				createExcelFile();
				
				
			}
			
			
		}
		
		
		
		
		
		

        
		
	}

	private static void createExcelFile() throws IOException {
		
		String filexls = "C:\\Users\\devdutt.jadeja\\Desktop\\TEMP\\Release_Notes_Excel_Format\\ReleaseNoteExcel_2.2.xls";
        HSSFWorkbook workbook = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream(filexls);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Your excel file has been generated!");
		
	}
	
	
	
	
	

}
