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

import dao.ItemDao;
import model.Item;


@WebServlet("/itemupdate")
public class ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected ItemDao itemDao;

	@Override
	public void init() throws ServletException {
		itemDao = ItemDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String itemId = req.getParameter("item");
        String itemDetails = req.getParameter("item_name");
        
        Item i2 = null;
		try {
			i2 = itemDao.getItemByItemId(itemId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if (itemId == null || itemDetails.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		Item item = itemDao.updateItemDetails(i2, itemDetails);
        		if(item == null) {
        			messages.put("success", "UserName does not exist.");
        		}
        		req.setAttribute("item", item);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ItemUpdate.jsp").forward(req, resp);

		
		
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String itemId = req.getParameter("item");
        String itemDetails = req.getParameter("item_name");
        
        Item i2 = null;
		try {
			i2 = itemDao.getItemByItemId(itemId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if (itemId == null || itemDetails.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		Item item = itemDao.updateItemDetails(i2, itemDetails);
        		messages.put("success", "Successfully updated!");
        		if(item == null) {
        			messages.put("success", "UserName does not exist.");
        		}
        		
        		req.setAttribute("item", item);
        		
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ItemUpdate.jsp").forward(req, resp);


	}

}
