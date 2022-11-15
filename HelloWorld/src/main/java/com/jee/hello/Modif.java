package com.jee.hello;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.beans.User;
import com.jee.dao.UtilConnexion;
import com.jee.beans.PasswordAuthentication;

@WebServlet("/modif")
public class Modif extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));

			Connection con = UtilConnexion.seConnecter();

			String query = "SELECT * FROM users WHERE id=?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				request.setAttribute("user", user);
				request.setAttribute("id", id);

				this.getServletContext().getRequestDispatcher("/WEB-INF/Modif.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			request.setAttribute("msg", "Erreur");
			response.sendRedirect("users");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String username = (String) request.getParameter("username_text");
			String email = (String) request.getParameter("email_text");
			String password = (String) request.getParameter("password_text");
			PasswordAuthentication pa = new PasswordAuthentication();
			password = pa.hash(password.toCharArray());
			Connection con = UtilConnexion.seConnecter();

			String query = "UPDATE users SET username =?, email=?, password=? WHERE id=?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setInt(4, id);
			ps.executeUpdate();
			con.close();

			response.sendRedirect("users");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			request.setAttribute("msg", "Erreur");
			doGet(request, response);
		}
	}

}
