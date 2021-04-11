package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import entities.Pessoa;

public class ApachePOIReadProgram {

	public static void main(String[] args) throws IOException {

		FileInputStream entrada = new FileInputStream(
				new File("src/application/file.xls"));

		HSSFWorkbook hw = new HSSFWorkbook(entrada); /* Prepara a entrada do arquivo excel para ler */
		HSSFSheet planilha = hw.getSheetAt(0); /* pega a primeira planilha */

		Iterator<Row> linhaIterator = planilha.iterator();

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (linhaIterator.hasNext()) { // Enquanto tiver linha no arquivo excel

			Row linha = linhaIterator.next(); /* Dados pessoa nalinha */

			Iterator<Cell> celulas = linha.iterator();

			Pessoa pessoa = new Pessoa();

			while (celulas.hasNext()) { // Percorre as células
				Cell cell = celulas.next();

				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
					
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
					
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}
			}
			pessoas.add(pessoa);
		}
		entrada.close(); // Terminou de ler o arquivo excel.
		hw.close();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}
