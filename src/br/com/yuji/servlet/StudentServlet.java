package br.com.yuji.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yuji.dao.StudentDAO;
import br.com.yuji.entities.Student;

@WebServlet("/StudentServlet")

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "sucesso.jsp";
		String mensagem = "";
		List<Student> lista = new ArrayList<>();

		Student student = new Student();
		StudentDAO dao = new StudentDAO();

		try {

			// Se a a��o for DIFERENTE de Listar s�o lidos os dados da tela
			if (!acao.equalsIgnoreCase("Listar")) {
				student.setRegistration(Long.parseLong(request.getParameter("registration")));
				student.setName(request.getParameter("name"));
				student.setTelephone(request.getParameter("telephone"));
				student.setEmail(request.getParameter("email"));

				// Faz a leitura da data de cadastro. Caso ocorra um erro de formata��o
				// o sistema utilizar� a data atual
				try {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					student.setDateRegister(df.parse(request.getParameter("dateRegister")));
				} catch (Exception e) {
					student.setDateRegister(new Date());
				}

			}

			if (acao.equalsIgnoreCase("Incluir")) {
				// Verifica se a matr�cula informada j� existe no Banco de Dados
				// Se existir enviar uma mensagem sen�o faz a inclus�o
				if (dao.existe(student)) {
					mensagem = "Matr�cula informada j� existe!";
				} else {
					dao.inserir(student);
				}
			} else if (acao.equalsIgnoreCase("Alterar")) {
				dao.alterar(student);
			} else if (acao.equalsIgnoreCase("Excluir")) {
				dao.excluir(student);
			} else if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("student", student);
				student = dao.consultar(student);
				destino = "student.jsp";
			}
		} catch (Exception e) {
			mensagem += e.getMessage();
			destino = "erro.jsp";
			e.printStackTrace();
		}

		// Se a mensagem estiver vazia significa que houve sucesso!
		// Sen�o ser� exibida a tela de erro do sistema.
		if (mensagem.length() == 0) {
			mensagem = "Aluno Cadastrado com sucesso!";
		} else {
			destino = "erro.jsp";
		}

		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		request.setAttribute("listaStudent", lista);
		request.setAttribute("mensagem", mensagem);

		// O sistema � direcionado para a p�gina
		// sucesso.jsp Se tudo ocorreu bem
		// erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
}
