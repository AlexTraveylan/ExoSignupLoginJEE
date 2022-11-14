package com.jee.hello;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UtilConnexion;
import com.jee.beans.PasswordAuthentication;
@WebServlet("/connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connect.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "Pas de message";
		String pass = "";
		
		try {
			String username = request.getParameter("username_text");
			String password = request.getParameter("password_text");
			
			Connection con = UtilConnexion.seConnecter();
		
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users WHERE username = '" + username + "';");
			if (rs.next()) {
				pass = rs.getString("password");
				
				
//				if (pass.equals(password)) {
//					msg = username + " est connecté";		
//				} else {
//					msg = "Pas le bon mot de passe pour l'utilisateur " + username;
//				}
				PasswordAuthentication pa = new PasswordAuthentication();
				if (pa.authenticate(password.toCharArray(), pass)) {
					msg = username + " est connecté";	
				} else {
					msg = "Pas le bon mot de passe pour l'utilisateur " + username;
				}
				
			} else {
				msg = "Cet utilisateur n'existe pas dans la base de donnée";
			}
			
			rs.close();
			con.close();
			request.setAttribute("msg", msg);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Connect.jsp").forward(request, response);
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				request.setAttribute("msg", "Erreur dans la requete");
				doGet(request, response);
			}
	
	}

}
