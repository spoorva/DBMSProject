package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodDao;
import dao.FoodEtlDao;
import dao.FoodNewDao;
import dao.ItemDao;
import model.Food;
import model.FoodEtl;
import model.FoodNew;
import model.Item;

/**
 * Servlet implementation class FoodRead
 */
@WebServlet("/food_read")
public class Food_Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
public FoodEtlDao foodDao;
	
	@Override
	public void init() throws ServletException {
		foodDao = FoodEtlDao.getInstance();
		System.out.println("Debug 0");
	}
	
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		Map<String, String> messages = new HashMap<String, String>();
    		request.setAttribute("messages", messages);
    		List<FoodEtl> itemList = new ArrayList<FoodEtl>();
    		
    		String test = "test";
            
    		FoodEtl f = null;;

    		
    		String item = request.getParameter("item");
    		String year = request.getParameter("year");
    		String period = request.getParameter("period");
    		
    		if (item == null || item.trim().isEmpty()) {
    			messages.put("success", "Please enter a valid item id.");
    		} else {
    			// Retrieve BlogUsers, and store as a message.
    			try {
    				f = foodDao.getNameByItemId(item, year, period);
    				itemList.add(f);
    			} catch (SQLException e) {
    				e.printStackTrace();
    				throw new IOException(e);
    			}
    			messages.put("success", "Displaying results for " + item);
    			// Save the previous search term, so it can be used as the default
    			// in the input box when rendering FindUsers.jsp.
    			messages.put("entered item id", item);
    		}
    		request.setAttribute("i", itemList);
    		
    		request.setAttribute("test", test);

    		request.getRequestDispatcher("/Food_Read.jsp").forward(request, response);

    		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
