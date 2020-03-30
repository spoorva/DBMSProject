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

import dao.CostOfLivingDao;
import dao.ItemDao;
import model.CostOfLiving;
import model.Item;


@WebServlet("/colupdate")
public class CostOfLivingUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected CostOfLivingDao itemDao;

	@Override
	public void init() throws ServletException {
		itemDao = CostOfLivingDao.getInstance();
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
		if (itemId == null || itemDetails.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	CostOfLiving item = null;;
			req.setAttribute("item", item);
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
		if (itemId == null || itemDetails.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	Class<? extends CostOfLivingDao> item = itemDao.getClass();
			messages.put("success", "Successfully updated!");
			if(item == null) {
				messages.put("success", "UserName does not exist.");
			}
			
			req.setAttribute("item", item);
        }
        
        req.getRequestDispatcher("/ItemUpdate.jsp").forward(req, resp);


	}

}
