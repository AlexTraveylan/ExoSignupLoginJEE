package com.jee.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.beans.User;
import com.jee.dao.UsersDAO;

@WebServlet("/connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connect.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String msg = "Pas de message";
		String username = request.getParameter("username_text");
		String password = request.getParameter("password_text");
		User user = UsersDAO.GetUserByUsername(username);
		System.out.println(user);
		
		if ( user != null) {
			msg = UsersDAO.tryLogin(user, password)?"Connection de " + user.getUsername() + " réussie":"Mauvais mot de passe pour " + user.getUsername();
		} else {
			msg="L'utilisateur n'existe pas dans la base de donnée";
		}
		
		request.setAttribute("msg", msg);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connect.jsp").forward(request, response);

	}

}
