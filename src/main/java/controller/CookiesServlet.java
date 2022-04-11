package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlet
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cgu = null;
		Cookie[] cookies = request.getCookies();
		System.out.println("----- Liste des cookies ------");
		System.out.println("Ici on aimerait modifier la valeur d'un cookie");
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("nom=" + cookie.getName() + ", valeur=" + cookie.getValue());
			}
		}
		cgu = "ok";
		Cookie nouveauCookie = new Cookie("cookie_" + cgu , "valeur_" + cgu);
		nouveauCookie.setMaxAge(20); // IMPORTANT : je définit une durée de vie en secondes pour le cookie (si j'oublie, le cookie sera détruit à la fermeture du navigateur)
		response.addCookie(nouveauCookie);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
