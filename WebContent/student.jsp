<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Aluno</title>
</head>
<body>
	<div align="center">
		<form method="post" action="StudentServlet">
			<fieldset>
				<legend>Cadastro de Alunos</legend>
				<label>Matrícula: </label><input name="registration" required
					value="${student.registration}" placeholder="2236541" /><br /> <label>Name:</label><input
					name="name" autofocus="autofocus" placeholder="Nome"
					value="${student.name}" /><br /> <label>Telefone:</label><input
					type="tel" name="telephone" placeholder="9999-9999"
					value="${student.telephone}" /><br /> <label>Email:</label><input
					type="email" name="email" placeholder="andre@feltex.com.br"
					value="${student.email}" /><br /> <label>Data Cadastro:</label><input
					type="date" name="dateRegister" value="${student.dateRegister}"
					placeholder="10/10/2014" /><br /> <label>Ação</label> <select
					name="acao" required>
					<option selected value="Incluir">Incluir</option>
					<option value="Alterar">Alterar</option>
					<option value="Excluir">Excluir</option>
					<option value="Consultar">Consultar</option>
				</select><br /> <input type="submit" value="Enviar"> <input
					type="reset" value="Limpar"> <br />
			</fieldset>
		</form>
	</div>

</body>
</html>