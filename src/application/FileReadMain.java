package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Pessoa;

public class FileReadMain {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream is = new FileInputStream(
				new File("src/application/file.txt"));

		Scanner sc = new Scanner(is, "UTF-8");

		List<Pessoa> list = new ArrayList<Pessoa>();
		
		while (sc.hasNext()) {
			
			String linha = sc.nextLine();
			
			if(linha != null && !linha.isEmpty()) {
				
				String[] dados = linha.split("\\;");
				
				Pessoa p = new Pessoa();
				p.setNome(dados[0]);
				p.setEmail(dados[1]);
				p.setIdade(Integer.parseInt(dados[2]));
				
				list.add(p);
			}
		}
		
		for (Pessoa pessoa : list) {
			System.out.println(pessoa);
		}
		
		sc.close();
	}
}
