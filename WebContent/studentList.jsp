<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Alunos</title>
</head> 
<body>
<div align="center">
		<P>Lista de Alunos</P>
		<table border="1">
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Telefone</td>
				<td>Data Cadastro</td>
				<td>Comandos</td>
			</tr>
			<c:forEach var="student" items="${listaStudent}">
				<tr>
					<td>${student.registration}</td>
					<td>${student.name}</td>
					<td>${student.telephone}</td>
					<td><fmt:formatDate value="${student.dateRegister}" type="both" pattern="dd/MM/yyyy"/>  
					<td><a href="StudentServlet?acao=Excluir&registration=${student.registration}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(listaStudent) > 0}">
   		Existem ${fn:length(listaStudent)} alunos!
 		</c:if><br> 		
	</div>
	<a href="menu.jsp">Voltar</a>

</body>
</html>