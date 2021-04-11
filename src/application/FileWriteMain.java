package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Pessoa;

public class FileWriteMain {

	
	public static void main(String[] args) throws IOException {
	
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
		
		File file = new File("src/application/file.txt");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fileWriter = new FileWriter(file);
		
		for (Pessoa pessoa : pessoas) {
			fileWriter.write(pessoa.getNome() + ";" 
					+ pessoa.getEmail() + ";" +
					+ pessoa.getIdade() + "\n");
		}
		
		fileWriter.flush(); // Persiste as alterações no arquivo
		fileWriter.close();		
	}
}
