package com.ahmadzia.targetWebSiteTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ReadExcelFile {
	Cell email;
	Cell firstName;
	Cell lastName;
	Cell Address;
	Cell City;
	Cell State;
	Cell phone, ZipCode, CreditCard, Exp, Cvv;
	
	
	
	@SuppressWarnings("resource")
	public void ExecelContent(){
		try {
			FileInputStream file = new FileInputStream(new File("deliveryFile.xls"));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell C_email,C_phone, C_firstName,C_lastName,
			C_Address, C_City, C_State, C_ZipCode, C_CreditCard,
			C_Exp, C_Cvv;

			//Update the value of cell
			C_email = sheet.getRow(1).getCell(0);
			C_phone = sheet.getRow(1).getCell(1);
			C_firstName = sheet.getRow(1).getCell(2);
			C_lastName = sheet.getRow(1).getCell(3);
			
			C_Address = sheet.getRow(1).getCell(4);
			C_City = sheet.getRow(1).getCell(5);
			C_State = sheet.getRow(1).getCell(6);
			C_ZipCode = sheet.getRow(1).getCell(7);
			C_CreditCard = sheet.getRow(1).getCell(8);
			C_Exp = sheet.getRow(1).getCell(9);
			C_Cvv = sheet.getRow(1).getCell(10);
			
			email = C_email;
			firstName = C_firstName;
			lastName = C_lastName;
			Address = C_Address;
			City = C_City;
			State = C_State;
			phone = C_phone;
			ZipCode = C_ZipCode;
			CreditCard = C_CreditCard;
			Exp = C_Exp;
			Cvv = C_Cvv;
			
			file.close();
			
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


