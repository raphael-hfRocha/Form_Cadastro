package Controller;

import java.io.IOException;

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
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
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
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar usuarios
	protected void usuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Registro.jsp");
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
}
