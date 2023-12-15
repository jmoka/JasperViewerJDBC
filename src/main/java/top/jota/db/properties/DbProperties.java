package top.jota.db.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import top.jota.db.exception.DbExcepition;


public class DbProperties {

	
	public static Properties dbPropretiesMysqlLocal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o nome do Banco de Dados");
		System.out.println("cpanel ou localhost");
		String nomeDB = sc.next();

		try (FileInputStream fs = new FileInputStream("src/main/resources/"+nomeDB+".properties")) {
		
			Properties props = new Properties();
			props.load(fs);
			System.out.println("Arquivo properties encontrado");
			return props;

		} catch (IOException e) {
			System.out.println("Arquivo properties não encontrado");
			throw new DbExcepition(e.getMessage());
		}
	}

}
