package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	/* Módulos de conexão */

	// Parâmetros de conexão

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/form_Cadastro?useTimeZone=true&serverTimeZone=UTC";
	private String user = "root";
	private String password = "Raphael#24";

	// Métodos de conexão

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
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

	/* Método CREATE/CRUD */

	public void inserirUsuario(JavaBeans cadastro) {
		String create = "insert into Cadastro(nome, sobrenome, email, senha) values (?, ?, ?, ?)";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, cadastro.getNome());
			pst.setString(2, cadastro.getSobrenome());
			pst.setString(3, cadastro.getEmail());
			pst.setString(4, cadastro.getSenha());

			// Executando a query

			pst.executeUpdate();

			// Encerrando a conexão com o banco

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
