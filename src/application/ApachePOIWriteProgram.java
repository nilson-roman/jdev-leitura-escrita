package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import entities.Pessoa;

public class ApachePOIWriteProgram {

	public static void main(String[] args) throws IOException {
		
		File file = new File("src/application/file.xls");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(25);
		pessoa1.setNome("Nilson");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(28);
		pessoa2.setNome("Roberto");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(33);
		pessoa3.setNome("Roman");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // Usado para escrever a planilha
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas JDev Treinamentos"); // Criar a planilha
		
		int numeroLinha = 0;
		
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha ++);
			
			int celula = 0;
			
			Cell celNome= linha.createCell(celula ++);
			celNome.setCellValue(p.getNome());
			
			Cell celEmail= linha.createCell(celula ++);
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade= linha.createCell(celula ++);
			celIdade.setCellValue(p.getIdade());
		
		} // Termino da criação da planilha
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		hssfWorkbook.close();
		
		System.out.println("Planilha criada");
	}
}
