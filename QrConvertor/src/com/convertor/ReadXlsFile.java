package com.convertor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXlsFile {

	String excelFilePath;
	GenerateQrCode generateQrCode;
	ConvertorMain convertorMain;

	public ReadXlsFile(String excelFilePath, ConvertorMain convertorMain) {
		this.excelFilePath = excelFilePath;
		generateQrCode = new GenerateQrCode();
		this.convertorMain = convertorMain;
	}

	public void readValueAndGenerateImage() throws Exception {
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = null;

			workbook = WorkbookFactory.create(inputStream);

			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> iterator = sheet.iterator();
			
			while (iterator.hasNext()) {

				Row nextRow = iterator.next();
				
				if (nextRow.getCell(0) != null) {
					GenerateQrCode.createQRImage(nextRow.getCell(0).toString() + nextRow.getCell(1).toString(),
							nextRow.getCell(2).toString(), 125, "png");

//					nextRow = iterator.next();
					System.out.println(nextRow.getCell(0));
				}
				 

			} 

			System.out.println("Outside Loop");
			
			convertorMain.enableConvertButton();

			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
