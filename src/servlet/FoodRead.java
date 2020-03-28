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

import dao.FoodNewDao;
import dao.ItemDao;
import model.FoodNew;
import model.Item;

/**
 * Servlet implementation class FoodRead
 */
@WebServlet("/foodread")
public class FoodRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
public FoodNewDao foodDao;
	
	@Override
	public void init() throws ServletException {
		foodDao = FoodNewDao.getInstance();
		System.out.println("Debug 0");
	}
	
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		Map<String, String> messages = new HashMap<String, String>();
    		request.setAttribute("messages", messages);
    		List<FoodNew> itemList = new ArrayList<FoodNew>();
    		
    		String test = "test";
            
    		FoodNew f = null;;

    		
    		String item = request.getParameter("item");
    		if (item == null || item.trim().isEmpty()) {
    			messages.put("success", "Please enter a valid item id.");
    		} else {
    			// Retrieve BlogUsers, and store as a message.
    			try {
    				f = foodDao.getValueByItemId(item);
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

    		request.getRequestDispatcher("/FoodRead.jsp").forward(request, response);

    		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
