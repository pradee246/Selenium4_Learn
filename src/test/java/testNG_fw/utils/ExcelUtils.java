package testNG_fw.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testNG_fw.constant.FrameworkConstants;


public final class ExcelUtils {
	private ExcelUtils() {}

	public static List<Map<String, String>> getTestDetails(String sheetName)  {
		FileInputStream fs = null;
		Map<String, String> map = null;
		List<Map<String, String>> list = new ArrayList<>();
		try {
			fs = new FileInputStream(new File(FrameworkConstants.TESTEXCEL_FILEPATH));
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(0).getLastCellNum());

			int lastRowNum = sheet.getLastRowNum();
			int lastColNum = sheet.getRow(0).getLastCellNum();

			for(int i = 1; i<=lastRowNum; i++) {
				map = new HashMap<>();
				for(int j=0; j<lastColNum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					if(sheet.getRow(i) == null){
						map.put(key, ""); break;
					}
					else if(sheet.getRow(i).getCell(j) == null || sheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_BLANK) {
						map.put(key, ""); break;
					}
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(Objects.nonNull(fs))
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return list;
	}

}
