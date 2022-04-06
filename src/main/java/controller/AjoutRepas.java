package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
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
 * Servlet implementation class AjoutRepas
 */
@WebServlet("/AjoutRepas")
public class AjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[] temp;
	private ArrayList<Ingredient> composition = new ArrayList<>();
	private RepasManager repasManager = new RepasManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutRepas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Ajout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
			try {
			LocalDate date = LocalDate.parse(request.getParameter("date"));
			LocalTime heure = LocalTime.parse(request.getParameter("heure"));
			
			
			temp = request.getParameter("ingredients").split(",");
			
			for (String string : temp) {
				Ingredient ingredient_temp = new Ingredient();
				ingredient_temp.setLibelle(string.trim());
				composition.add(ingredient_temp);
			}
			
			Repas repas = new Repas(date, heure, composition);
			System.out.println(repas);
			
				this.repasManager.add(repas);
				request.setAttribute("messageConfirmation", "Repas test : " + repas);

			} catch (DateTimeParseException e) {
				request.setAttribute("messageErreur", "Une erreur s'est glissée dans la saisie");
			
			} catch (BusinessException e) {
				request.setAttribute("messageErreur", e.getMessage());
				e.printStackTrace();
			}
			
		
		
		request.getRequestDispatcher("/WEB-INF/Ajout.jsp").forward(request, response);
	}

}
