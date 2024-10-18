package controller;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.DAO;
import model.JavaBeans;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class ControllerTest {

	private Controller controller;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher rd;
	private DAO dao;

	@BeforeEach
	void setUp() {
		controller = new Controller();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		rd = mock(RequestDispatcher.class);
		dao = mock(DAO.class);

		// Substituindo o DAO por um mock
		controller.dao = dao;
	}

	@Test
	void testContatos() throws Exception {
		// Preparando o cenário
		ArrayList<JavaBeans> lista = new ArrayList<>();
		when(dao.listarContatos()).thenReturn(lista);
		when(request.getRequestDispatcher("agenda.jsp")).thenReturn(rd);

		// Executando o método
		controller.contatos(request, response);

		// Verificando as interações
		verify(request).setAttribute("contatos", lista);
		verify(rd).forward(request, response);
	}

	@Test
	void testNovoContato() throws Exception {
		// Preparando o cenário
		when(request.getParameter("nome")).thenReturn("John Doe");
		when(request.getParameter("fone")).thenReturn("123456789");
		when(request.getParameter("email")).thenReturn("john@example.com");

		// Executando o método
		controller.novoContato(request, response);

		// Verificando as interações
		verify(dao).inserirContato(any());
		verify(response).sendRedirect("main");
	}

	@Test
	void testSelecionaContato() throws Exception {
		// Preparando o cenário
		when(request.getParameter("idcont")).thenReturn("1");
		when(request.getRequestDispatcher("editar.jsp")).thenReturn(rd);

		// Executando o método
		controller.selecionaContato(request, response);

		// Verificando as interações
		verify(dao).selecionarContato(any());
		verify(request).setAttribute(eq("idcont"), any());
		verify(rd).forward(request, response);
	}

	@Test
	void testEditarContato() throws Exception {
		// Preparando o cenário
		when(request.getParameter("idcon")).thenReturn("1");
		when(request.getParameter("nome")).thenReturn("Jane Doe");
		when(request.getParameter("fone")).thenReturn("987654321");
		when(request.getParameter("email")).thenReturn("jane@example.com");

		// Executando o método
		controller.editarContato(request, response);

		// Verificando as interações
		verify(dao).atualizarContato(any());
		verify(response).sendRedirect("main");
	}

	@Test
	void testRemoverContato() throws Exception {
		// Preparando o cenário
		when(request.getParameter("idcont")).thenReturn("1");

		// Executando o método
		controller.removerContato(request, response);

		// Verificando as interações
		verify(dao).deletarContato(any());
		verify(response).sendRedirect("main");
	}
}