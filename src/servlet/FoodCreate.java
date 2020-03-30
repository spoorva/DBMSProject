package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodDao;
import dao.FoodNewDao;
import dao.ItemDao;
import model.FoodNew;
import model.Item;

/**
 * Servlet implementation class FoodCreate
 */
@WebServlet("/foodcreate")
public class FoodCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected FoodNewDao foodDao;

	@Override
	public void init() throws ServletException {
		foodDao = FoodNewDao.getInstance();
		System.out.println("Inside food create");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/FoodCreate.jsp").forward(req, resp);
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   Map<String, String> messages = new HashMap<String, String>();
	        req.setAttribute("messages", messages);

	       
	        	String item = req.getParameter("item");
	        	String year = req.getParameter("year");
	        	
	        	String period = req.getParameter("period");
	        	String value = req.getParameter("value");
	        	
	        	
	        	
		        try {
		        	// Exercise: parse the input for StatusLevel.
		        	FoodNew food = new FoodNew(item, year, period, value);
		        	foodDao.create(food);
		        	messages.put("success", "Successfully created food and food_new" + item);
		        } catch (SQLException e) {
					e.printStackTrace();
					throw new IOException(e);
		        }
	        

	        req.getRequestDispatcher("/FoodCreate.jsp").forward(req, resp);


	}

}
