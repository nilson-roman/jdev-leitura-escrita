package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ApachePOIEditProgram2 {

	public static void main(String[] args) throws IOException {
		
		File file = new File("src/application/file.xls");

		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hw = new HSSFWorkbook(entrada); /* Prepara a entrada do arquivo excel para ler */
		HSSFSheet planilha = hw.getSheetAt(0); /* pega a primeira planilha */

		Iterator<Row> linhaIterator = planilha.iterator();

		while (linhaIterator.hasNext()) { // Enquanto tiver linha no arquivo excel

			Row linha = linhaIterator.next(); /* Dados pessoa na linha */
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(valorCelula + " Valor gravado na celula");

		}
		entrada.close(); // Terminou de ler o arquivo excel.
		
		FileOutputStream saida = new FileOutputStream(file);
		hw.write(saida);
		saida.flush();
		saida.close();
		hw.close();
		
		System.out.println("Planilha atualizada.");
	}
}
