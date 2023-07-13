package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		String create = "INSERT INTO Cadastro(nome, sobrenome, email, senha) VALUES (?, ?, ?, ?)";
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

	/* Método READ/CRUD */

	public ArrayList<JavaBeans> listarUsuarios() {
		ArrayList<JavaBeans> usuarios = new ArrayList<>();
		String read = "SELECT * FROM Cadastro";

		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				// variáveis de apoio que recebem os dados do banco

				String id_user = rs.getString(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				String email = rs.getString(4);
				String senha = rs.getString(5);

				// populando o ArrayList

				usuarios.add(new JavaBeans(id_user, nome, sobrenome, email, senha));
			}

			con.close();
			return usuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	/* Método UPDATE/CRUD */
	
	//Selecionando usuario
	
	public void selecionarUsuario(JavaBeans cadastro)
	{
		String read2 = "SELECT * FROM Cadastro WHERE id_user = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, cadastro.getId_user());
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				//	Setando as variáveis do JavaBeans				
				cadastro.setId_user(rs.getString(1));
				cadastro.setNome(rs.getString(2));
				cadastro.setSobrenome(rs.getString(3));
				cadastro.setEmail(rs.getString(4));
				cadastro.setSenha(rs.getString(5));
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//	Editar usuario
	
	public void alterarUsuario(JavaBeans cadastro)
	{
		String create = "UPDATE Cadastro SET nome=?, sobrenome=?, email=?, senha=? WHERE id_user=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, cadastro.getNome());
			pst.setString(2, cadastro.getSobrenome());
			pst.setString(3, cadastro.getEmail());
			pst.setString(4, cadastro.getSenha());
			pst.setString(5, cadastro.getId_user());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	/* Método DELETE/CRUD */
	
	public void deletarUsuario(JavaBeans cadastro)
	{
		String delete = "DELETE FROM Cadastro WHERE id_user = ?";
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(delete);
					pst.setString(1, cadastro.getId_user());
					pst.executeUpdate();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
	}
}