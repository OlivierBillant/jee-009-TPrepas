package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltreCookies
 */
@WebFilter("*")
public class FiltreCookies extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		System.out.println("url qui passe le filtre : " + httpRequest.getServletPath());

//		httpRequest.getRequestDispatcher("/WEB-INF/cgu.jsp").forward(httpRequest, httpResponse);

		Cookie[] cookies = httpRequest.getCookies();
		System.out.println("----- Liste des cookies ------");
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getValue());
		}

		System.out.println();
		Boolean laisserPasser = false;

		if (httpRequest.getServletPath().contains("/CookiesServlet")) {
			laisserPasser = true;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getValue().equals("valeur_ok")) {
				laisserPasser = true;
			}
		}
		if (laisserPasser) {
//			System.out.println(laisserPasser);
			chain.doFilter(request, response);

		} else {
			httpRequest.getRequestDispatcher("/WEB-INF/cgu.jsp").forward(httpRequest, httpResponse);
			System.out.println(laisserPasser);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
