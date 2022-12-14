package com.jee.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UsersDAO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println(getServletContext().getInitParameter("DATABASE_URL"));
		// Récuperation et envoie de l'eventuel message d'erreur.
		String erreur = (String) request.getAttribute("erreur");
		request.setAttribute("erreur", erreur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erreur = "";

		// Recuperation des données du formulaire.
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirme = request.getParameter("confirme");

		// Verification des erreurs.
		if ("".equals(username))
			erreur += "Le champ username est vide.<br/>";
		if (!email.contains("@"))
			erreur += "L'email doit contenir un @.<br/>";
		if (password.length() < 3)
			erreur += "Il faut un mot de passe plus long, 3 min.<br/>";
		if (!password.equals(confirme))
			erreur += "Le mot de passe ne correspond pas au champ de confirmation.<br/>";

		// Si erreur, envoie de l'erreur a GET.
		if (!erreur.equals("")) {
			request.setAttribute("erreur", erreur);
			doGet(request, response);

			// Sinon envoie des données de l'utilisateur a la page.
		} else {

			// connexion et insertion de l'utilisateur.
			
			if (UsersDAO.createUser(username, email, password)) {
				response.sendRedirect("users");
			} else {
				doGet(request, response);
			}
		}
	}
}
