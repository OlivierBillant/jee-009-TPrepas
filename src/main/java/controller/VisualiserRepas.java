package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bll.BusinessException;
import model.bll.RepasManager;
import model.bo.Ingredient;
import model.bo.Repas;

/**
 * Servlet implementation class VisualiserRepas
 */
@WebServlet("/VisualiserRepas")
public class VisualiserRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepasManager repasManager = new RepasManager();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualiserRepas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Repas> listeRepas = repasManager.show();
			
			//syso de vérification de la liste de repas
			String test = listeRepas.get(0).getDate().toString();
			System.out.println(test);
			for (Repas repas : listeRepas) {
				System.out.println(repas);
			}
			request.setAttribute("listeRepas", listeRepas);
			
//			Integer id = (Integer) request.getAttribute("id");
			System.out.println("Test id");
			Integer id = 2;
			System.out.println(id);
			System.out.println("Avant boucle");

			if(id != null) {
				System.out.println(id);
				ArrayList<Ingredient> listeIngredient = repasManager.detail(id);
				request.setAttribute("listeIngredient", listeIngredient);
				for (Ingredient ingredient : listeIngredient) {
					System.out.println(ingredient);
				}
			}
		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/Historique.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);	}
		
}