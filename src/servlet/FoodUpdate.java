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

import dao.FoodNewDao;
import dao.ItemDao;
import model.FoodNew;
import model.Item;

/**
 * Servlet implementation class FoodUpdate
 */
@WebServlet("/foodupdate")
public class FoodUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected FoodNewDao foodDao;

	@Override
	public void init() throws ServletException {
		foodDao = FoodNewDao.getInstance();
	}
	
   	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String itemId = req.getParameter("item");
        String value = req.getParameter("value");
        
        FoodNew food = null;
		try {
			food = foodDao.getValueByItemId(itemId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if (itemId == null || value.trim().isEmpty()) {
            messages.put("success", "Please enter a valid values.");
        } else {
        	try {
        		FoodNew f  = foodDao.updateValue(food, Double.parseDouble(value));
        		if(f == null) {
        			messages.put("success", "UserName does not exist.");
        		}
        		req.setAttribute("item", f);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/FoodUpdate.jsp").forward(req, resp);

		
		
		resp.getWriter().append("Served at: ").append(req.getContextPath());

   		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
