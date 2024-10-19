package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if(action.equals("/insert")) {
			novoContato(request, response);
		} else if(action.equals("/select")) {
			selecionaContato(request, response);
		} else if(action.equals("/update")) {
			editarContato(request, response);
		}else if(action.equals("/delete")) {
			removerContato(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}


	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();
		//encaminhar lista ao agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//pega valores do forms enviados pela requisição e armazena no objeto contato
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		//passa objeto ao model para inserção
		dao.inserirContato(contato);
		//redireciona para o endpoint main que chama contatos, atualizando a lista e trocando o post para get
		response.sendRedirect("main");
	}
	
	protected void selecionaContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setIdcont(request.getParameter("idcont"));
		
		dao.selecionarContato(contato);
		//seta os atributos
		request.setAttribute("idcont", contato.getIdcont());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		//encaminhar ao editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setar variaveis JavaBeans
		contato.setIdcont(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		//passa objeto ao model para atualização
		dao.atualizarContato(contato);
		//redireciona para o endpoint main que chama contatos, atualizando a lista e trocando o post para get
		response.sendRedirect("main");
	}
	
	protected void removerContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setIdcont(request.getParameter("idcont"));
		
		dao.deletarContato(contato);
		//redireciona para o endpoint main que chama contatos, atualizando a lista e trocando o post para get
		response.sendRedirect("main");
	}	
	
}
