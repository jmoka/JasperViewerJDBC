package top.jota.jasper.JDBC;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sf.jasperreports.engine.JRException;
import services.ServiceJasperViewer;
import top.jota.db.Db;
import top.jota.db.properties.DbProperties;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
			}
	
	 @Override
	    public void run(String... args) throws Exception {
		 
		// arquvioSemParametros();
		 //arquvioComParametros(9l);
		 //abrirPDF();
		  abrirHTML();
	    	
	    }
	 
	 
	 private void arquvioSemParametros() throws JRException {
		 
		 DbProperties dbProperties = null;
		 Db db = new Db(dbProperties);
		
		 ServiceJasperViewer servicie = new ServiceJasperViewer();
		 
		 
		 
		 servicie.abrirJasperViewer("relatorios/jrxml/nivelTodosOrderID.jrxml",  db.connection());
		 db.closeConnection();
		 
		 
	 }
	 
private void arquvioComParametros(Long id) throws JRException {
		 
		 DbProperties dbProperties = null;
		 Db db = new Db(dbProperties);
		
		 ServiceJasperViewer servicie = new ServiceJasperViewer();
		 
		 servicie.addParams("idNivel", id);
		 
		 servicie.abrirJasperViewer("relatorios/jrxml/nivelPorID.jrxml",  db.connection());
		 db.closeConnection();
		 
		 
	 }


	private void abrirPDF() {
		 DbProperties dbProperties = null;
		 Db db = new Db(dbProperties);
		
		 ServiceJasperViewer servicie = new ServiceJasperViewer();
		 
		 String caminhoSaida =  "C:\\Users\\jotac\\Documents\\pdf\\" + "arqJasper-pdf-"+ UUID.randomUUID()+ ".pdf";
		 String jrxml = "relatorios/jrxml/nivelTodosOrderID.jrxml";
		 try {
			 
			servicie.exportarPDF(jrxml,  db.connection(), caminhoSaida);
			 db.closeConnection();
			 
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	private void abrirHTML() {
		 DbProperties dbProperties = null;
		 Db db = new Db(dbProperties);
		
		 ServiceJasperViewer servicie = new ServiceJasperViewer();
		 
		 String caminhoSaida =  "C:\\Users\\jotac\\Documents\\pdf\\" + "arqJasper-html-"+ UUID.randomUUID()+ ".html";
		 String jrxml = "relatorios/jrxml/nivelTodosOrderID.jrxml";
		 try {
			 
			servicie.exportarPDF(jrxml,  db.connection(), caminhoSaida);
			 db.closeConnection();
			 
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	 

}
