package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import model.Item;


@WebServlet("/itemcreate")
public class ItemCreate extends HttpServlet {
	
	protected ItemDao itemDao;
	
	@Override
	public void init() throws ServletException {
		itemDao = ItemDao.getInstance();
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

       
        	String item = req.getParameter("item");
        	String item_name = req.getParameter("item_name");
        	
        	String display_level = req.getParameter("display_level");
        	String selectable = req.getParameter("selectable");
        	String sort_seq = req.getParameter("sort_sequence");
        	
        	
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Item i = new Item(item, item_name, display_level, selectable, sort_seq);
	        	itemDao.create(i);
	        	messages.put("success", "Successfully created " + item_name);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        

        req.getRequestDispatcher("/ItemCreate.jsp").forward(req, resp);
	        
	      //  req.getRequestDispatcher("/success.jsp");
    
	}
	
} 
