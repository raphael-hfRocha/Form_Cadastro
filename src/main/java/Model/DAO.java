package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	/*	Módulos de conexão */
	
	//	Parâmetros de conexão
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/form_Cadastro?useTimeZone=true&serverTimeZone=UTC";
	private String user = "root";
	private String password = "Raphael#24";
	
	
	//	Métodos de conexão
	
	private Connection conectar()
	{
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
	}
	
//	Teste de conexão
	
//	public void testeConexao()
//	{
//		try {
//			Connection con = conectar();
//			System.out.println(con);
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
}
