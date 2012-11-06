package baseDeDonneesApachePOI;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.POIDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class BaseDeDonneesApachePOI {

	public static void main(
			String[] args) {

//		creerDocumentExcel("baseDeDonnees");
		HSSFWorkbook wb = new HSSFWorkbook(); //Instancie un objet de la classe HSSWokrbook
		
		HSSFSheet sheet1 = wb.createSheet("InfoEmployes"); //Creer nouvelle feuille Excel
		HSSFSheet sheet2 = wb.createSheet("Plats"); //Creer nouvelle feuille Excel

		afficherDate(wb, sheet1, 1, 1); //Attention necessite une ligne de 4 cellules
		afficherDate(wb, sheet2, 1, 1);

//		Exemple de fonction !!!
		creerNewCellule(wb, sheet1, 0, 6, "Cellule"); //Attention la valeur dans la cellule est au format d'un String
//		fusionCellule(wb, sheet1, 0, 7, 1, 9);


		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("baseDeDonnees.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Fichier 'baseDeDonnees.xls' --> Well Created!");

	}


//	private static HSSFWorkbook creerDocumentExcel(String nomFichierExcel) {
//		// TODO Auto-generated method stub
//		HSSFWorkbook wb = new HSSFWorkbook();
//		FileOutputStream fileOut;
//		try {
//			fileOut = new FileOutputStream(nomFichierExcel+".xls");
//			wb.write(fileOut);
//			fileOut.close();	
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return wb;
//	}


	private static void fusionCellule(HSSFWorkbook wb, HSSFSheet sheet, int ligneCellule, int colonneCellule, int ligneCellule1, int colonneCellule1) {
		sheet.addMergedRegion(new Region(ligneCellule,(short)colonneCellule,ligneCellule1,(short)colonneCellule1));

	}

	private static void afficherDate(HSSFWorkbook wb, HSSFSheet sheet1, int ligneCellule, int colonneCellule) {
		HSSFCellStyle cellStyle = null;

		HSSFRow row1 = sheet1.createRow(ligneCellule);
		HSSFRow row2 = sheet1.createRow(ligneCellule);
		HSSFCell cell1 = null;
		HSSFCell cell2 = null;

		cell1 = row1.createCell((short)colonneCellule);
		cell1.setCellValue("Date - Heure:Min:Sec");
		cell2 = row2.createCell((short)colonneCellule+2);
		cell2.setCellValue(new Date());
		cellStyle = wb.createCellStyle();
		HSSFDataFormat hssfDataFormat = wb.createDataFormat();
		cellStyle.setDataFormat(hssfDataFormat.getFormat("dd/mm/yyyy h:mm:ss"));
		cell2.setCellStyle(cellStyle);

		int colonneCellule1 = colonneCellule+1;
		sheet1.addMergedRegion(new Region(ligneCellule,(short)colonneCellule,ligneCellule,(short)colonneCellule1));
		colonneCellule = colonneCellule+2;
		colonneCellule1 = colonneCellule+1;
		sheet1.addMergedRegion(new Region(ligneCellule,(short)colonneCellule,ligneCellule,(short)colonneCellule1));
	}

	private static void creerNewCellule(HSSFWorkbook wb, HSSFSheet sheet, int ligneCellule, int colonneCellule, String valeurCellule) {
		HSSFRow row = sheet.createRow(ligneCellule);
		HSSFCell cell = row.createCell((short)colonneCellule);
		cell.setCellValue(valeurCellule);

	}
	
//	public static String getValueCellule(String string1, String string2, int ligneCellule, int colonneCellule) {
//		HSSFRow row = string2.createRow(ligneCellule);
//		HSSFCell cell = row.createCell((short)colonneCellule);
//		String cellValue = cell.getStringCellValue();
//		
//		return cellValue;
//	}
	
}