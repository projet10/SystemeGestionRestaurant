package poi;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

public class POI {

	public static void main(
			String[] args) {

		creerNewDocument("fichierExcelXav");
		creerNewFeuille("fichierExcelXav","nouvelleFeuille");
		creerNewCellule("fichierExcelXav", "nouvelleFeuille", 1, 1, "100"); //Attention la valeur dans la cellule est au format d'un String
		GregorianCalendar date = new GregorianCalendar();
		System.out.println(date.getTime());

		
		afficherDate("fichierExcelXav", "nouvelleFeuille", 0, 0);
		afficherDate("fichierExcelXav", "nouvelleFeuille", 1, 1);
		fusionCellule("fichierExcelXav", "nouvelleFeuille", 1, 2, 3, 4);

	}


	private static void fusionCellule(String nomFichier, String nomFeuille, int ligneCellule, int colonneCellule, int ligneCellule1, int colonneCellule1) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(nomFeuille);
		sheet.addMergedRegion(new Region(ligneCellule,(short)colonneCellule,ligneCellule1,(short)colonneCellule1));

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("monfichier.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void afficherDate(String nomFichier, String nomFeuille, int ligneCellule, int colonneCellule) {
		HSSFCellStyle cellStyle = null;

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(nomFeuille);

		HSSFRow row = sheet.createRow(ligneCellule);
		HSSFCell cell = null;

		cell = row.createCell((short)colonneCellule);
		cell.setCellValue(new Date());
		cellStyle = wb.createCellStyle();
		HSSFDataFormat hssfDataFormat = wb.createDataFormat();
		cellStyle.setDataFormat(hssfDataFormat.getFormat("dd/mm/yyyy h:mm"));
		cell.setCellStyle(cellStyle);

		int colonneCellule1 = colonneCellule+1;
		sheet.addMergedRegion(new Region(ligneCellule,(short)colonneCellule,ligneCellule,(short)colonneCellule1));

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("monfichier.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void creerNewCellule(String nomFichier, String nomFeuille, int ligneCellule, int colonneCellule, String valeurCellule) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(nomFeuille);

		HSSFRow row = sheet.createRow(ligneCellule);
		HSSFCell cell = row.createCell((short)colonneCellule);
		cell.setCellValue(valeurCellule);

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("monfichier.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void creerNewFeuille(String nomFichier, String nomFeuille) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(nomFeuille);

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("monfichier.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void creerNewDocument(String nomFichier) {
		HSSFWorkbook wb = new HSSFWorkbook();	

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("monfichier.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}