package com.jee.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.beans.User;
import com.jee.dao.UsersDAO;

@WebServlet("/modif")
public class Modif extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("user", UsersDAO.GetUserById(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/Modif.jsp").forward(request, response);		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = new User
				.Builder(Integer.parseInt(request.getParameter("id")) , (String) request.getParameter("username_text"))
				.email((String) request.getParameter("email_text"))
				.password((String) request.getParameter("password_text"))
				.build();

		request.setAttribute("msg", UsersDAO.updateUser(user)?"Utiliseur " + user.getId() + " modifié": "Erreur");
		response.sendRedirect("users");
	}

}
