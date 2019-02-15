package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TXTDataToExcel {

	public static void main(String[] args) throws Exception {

		int rownum = 0;
		String filexls = "C:\\DEVDUTT JADEJA\\WORKSPACE_STS\\yoyotransport\\ReleaseNote_2.2.xls";

		File filetxt = new File("C:\\DEVDUTT JADEJA\\WORKSPACE_STS\\yoyotransport\\test.txt");
		File file = new File(filexls);

		Scanner scanner = new Scanner(filetxt);

		while (scanner.hasNextLine()) {

			String nextLine = scanner.nextLine();
			System.out.println(nextLine);

			if (!file.exists()) {

				// createExcelFile
				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFSheet sheet = workbook.createSheet();

				// header
				HSSFRow row = sheet.createRow(rownum);
				row.createCell(0).setCellValue("Author");
				row.createCell(1).setCellValue("Time Stamp");
				row.createCell(2).setCellValue("Description");
				row.createCell(3).setCellValue("Type");
				row.createCell(4).setCellValue("Files Changed");

				FileOutputStream fileOut = new FileOutputStream(filexls);
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();
				System.out.println("excel file has been generated!");

				// FileInputStream inputStream = new FileInputStream(file); // Note : it wont
				// create new file, this will give FileNotFoundException if file is not present
				// at given path
				// HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);

			}

			FileInputStream inputStream = new FileInputStream(file); // Note : it wont create new file, this will give
																		// FileNotFoundException if file is not present
																		// at given path
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			FileOutputStream fileOut = new FileOutputStream(filexls);

			if (nextLine.charAt(0) != 'A' && nextLine.charAt(0) != 'M' && nextLine.charAt(0) != 'D') {

				String[] strings = nextLine.split(",");

				rownum++;
				HSSFRow row = workbook.getSheetAt(0).createRow(rownum);
				row.createCell(0).setCellValue(strings[0]);
				row.createCell(1).setCellValue(strings[1]);
				row.createCell(2).setCellValue(strings[2]);

				workbook.write(fileOut);
				// fileOut.close();
				// workbook.close();

				// System.out.println(string);

			} else {

				String[] strings = nextLine.split("\t");

				int lastRowNum = workbook.getSheetAt(0).getLastRowNum();
				HSSFRow row = workbook.getSheetAt(0).getRow(lastRowNum);

				row.createCell(3).setCellValue(strings[0]);
				row.createCell(4).setCellValue(strings[1]);
				workbook.write(fileOut);

			}

			fileOut.close();
			workbook.close();

		}

		scanner.close();

	}

}
