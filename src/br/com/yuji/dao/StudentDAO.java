package br.com.yuji.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.yuji.entities.Student;

public class StudentDAO extends DAO{

	public void alterar(Student student) {
		try {
			Connection conexao = getConexao();

			PreparedStatement pstmt = conexao.prepareStatement(
					"Update tbstudent SET name = ?, telephone = ?, email = ?, dateRegister = ?" + " WHERE registration = ? ");
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getTelephone());
			pstmt.setString(3, student.getEmail());
			pstmt.setDate(4, new java.sql.Date(student.getDateRegister().getTime()));
			pstmt.setLong(5, student.getRegistration());
			pstmt.execute();
			pstmt.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Student student) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("Delete from	tbstudent where registration = ? ");
			pstm.setLong(1, student.getRegistration());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean existe(Student student) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("Select * from tbstudent where registration =	?");
			pstm.setLong(1, student.getRegistration());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				achou = true;
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achou;
	}

	public void inserir(Student student) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement(
					"Insert into	tbstudent (registration, name, telephone, email, dateRegister) values	(?,?,?,?,?)");
			pstm.setLong(1, student.getRegistration());
			pstm.setString(2, student.getName());
			pstm.setString(3, student.getTelephone());
			pstm.setString(4, student.getEmail());
			pstm.setDate(5, new java.sql.Date(student.getDateRegister().getTime()));
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> listar() {
		List<Student> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from tbstudent");
			while (rs.next()) {
				Student student = new Student();
				student.setRegistration(rs.getLong("registration"));
				student.setName(rs.getString("name"));
				student.setTelephone(rs.getString("telephone"));
				student.setEmail(rs.getString("email"));
				student.setDateRegister(new java.util.Date(rs.getDate("dateRegister").getTime()));
				lista.add(student);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Student consultar(Student student) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("Select * from tbstudent where resgitration =	?");
			pstm.setLong(1, student.getRegistration());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				student.setRegistration(rs.getLong("registration"));
				student.setName(rs.getString("name"));
				student.setTelephone(rs.getString("telephone"));
				student.setEmail(rs.getString("email"));
				student.setDateRegister(new java.util.Date(rs.getDate("dateRegister").getTime()));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
}