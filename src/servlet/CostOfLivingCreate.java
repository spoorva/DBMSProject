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

/**
 * Servlet implementation class CostOfLivingCreate
 */
@WebServlet("/costoflivingcreate")
public class CostOfLivingCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
protected CostOfLivingDao itemDao;
	
	@Override
	public void init() throws ServletException {
		itemDao = CostOfLivingDao.getInstance();
		System.out.println("Inside item create");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
		
		
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/ItemCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

       
        	String place = req.getParameter("place");
        	String meal = req.getParameter("meal");
        	
        	String water = req.getParameter("water");
        	String milk = req.getParameter("milk");
        	
        	String whitebread = req.getParameter("whitebread");
        	String eggs = req.getParameter("eggs");
        	
        	String localcheese = req.getParameter("localcheese");
        	String chicken = req.getParameter("chicken");
        	
        	String apples = req.getParameter("apples");
        	String oranges = req.getParameter("oranges");
        	
        	String potato = req.getParameter("potato");
        	String lettuce = req.getParameter("lettuce");
        	
        	String cappuccino  = req.getParameter("cappuccino");
        	String rice = req.getParameter("rice");
        	
        	String tomato = req.getParameter("tomato");
        	String banana = req.getParameter("banana");
        	

        	String onion = req.getParameter("onion");
        	String beef = req.getParameter("beef");
        	
        	
        	
	        try {
	        	// Exercise: parse the input for StatusLevel.
	         CostOfLiving i = new CostOfLiving(place,  meal,  water, milk,  whitebread,  eggs, localcheese,  chicken,  apples,  oranges,  potato,  lettuce, cappuccino, 
	        		 rice,  tomato,  banana,  onion,  beef);
	        	itemDao.create(i);
	        	messages.put("success", "Successfully created!");
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        

        req.getRequestDispatcher("/CostOfLivingCreate.jsp").forward(req, resp);
	        
	      //  req.getRequestDispatcher("/success.jsp");
    
	}

       
 
}
