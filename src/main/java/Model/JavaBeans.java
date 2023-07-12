package Model;

public class JavaBeans {
	private String id_user;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	
	
	public JavaBeans() {
		super();
	}
	
	

	public JavaBeans(String id_user, String nome, String sobrenome, String email, String senha) {
		super();
		this.id_user = id_user;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
	}


	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getSenha() {
		return senha;
	}
	
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
