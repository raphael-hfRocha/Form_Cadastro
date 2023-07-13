package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/edit", "/update" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans cadastro = new JavaBeans();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			usuarios(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else if (action.equals("/edit")) {
			listarUsuario(request, response);
		} else if (action.equals("/update")) {
			editarUsuario(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar usuarios
	protected void usuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Criando um objeto que irá receber os dados JavaBeans

		ArrayList<JavaBeans> lista = dao.listarUsuarios();

//		Encaminhar a lista ao documento na pasta Registro.jsp

		request.setAttribute("usuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Registro.jsp");
		rd.forward(request, response);

//		//	Teste de recebimento da lista
//		
//		for (int i = 0; i < lista.size(); i++) {
//			
//			System.out.println(lista.get(i).getId_user());
//			System.out.println(lista.get(i).getNome());
//			System.out.println(lista.get(i).getSobrenome());
//			System.out.println(lista.get(i).getEmail());
//			System.out.println(lista.get(i).getSenha());
//		}

	}

	// Novo usuario
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//			//	Teste de recebimento dos dados do formulário			
//			System.out.println(request.getParameter("nome"));
//			System.out.println(request.getParameter("sobrenome"));
//			System.out.println(request.getParameter("email"));
//			System.out.println(request.getParameter("senha"));

		// Setando as variávieis JavaBeans
		cadastro.setNome(request.getParameter("nome"));
		cadastro.setSobrenome(request.getParameter("sobrenome"));
		cadastro.setEmail(request.getParameter("email"));
		cadastro.setSenha(request.getParameter("senha"));

		dao.inserirUsuario(cadastro);

		response.sendRedirect("main");
	}

	// Editar contato
	protected void listarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebendo o id do usuario que será editado
		String id_user = request.getParameter("id_user");
		System.out.println(id_user);

		// Setando a variável JavaBeans
		cadastro.setId_user(id_user);

		// Executar o método selecionarUsuario (DAO)

		dao.selecionarUsuario(cadastro);

		// teste de recebimento UPDATE

//			System.out.println(cadastro.getId_user());
//			System.out.println(cadastro.getNome());
//			System.out.println(cadastro.getSobrenome());
//			System.out.println(cadastro.getEmail());
//			System.out.println(cadastro.getSenha());

		// Setando atributos do formulário com o conteúdo JavaBeans

		request.setAttribute("id_user", cadastro.getId_user());
		request.setAttribute("nome", cadastro.getNome());
		request.setAttribute("sobrenome", cadastro.getSobrenome());
		request.setAttribute("email", cadastro.getEmail());
		request.setAttribute("senha", cadastro.getSenha());

		// Encaminhando ao documento Editar.jsp

		RequestDispatcher rd = request.getRequestDispatcher("Editar.jsp");
		rd.forward(request, response);
	}

	protected void editarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	teste de recebimento
//		System.out.println(request.getParameter("id_user"));
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("sobrenome"));
//		System.out.println(request.getParameter("email"));
//		System.out.println(request.getParameter("senha"));
		
		
		//	Setando as variáveis JavaBeans
		
		cadastro.setId_user(request.getParameter("id_user"));
		cadastro.setNome(request.getParameter("nome"));
		cadastro.setSobrenome(request.getParameter("sobrenome"));
		cadastro.setEmail(request.getParameter("email"));
		cadastro.setSenha(request.getParameter("senha"));
		
		//	Executando o método alterarUsuario
		
		dao.alterarUsuario(cadastro);
		
		//	Redirecionando para o documento Editar.jsp (atualizando alterações)
		
		response.sendRedirect("main");
	}
}
