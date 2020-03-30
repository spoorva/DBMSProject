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

import dao.CostOfLivingDao;
import dao.ItemDao;
import model.Item;

/**
 * Servlet implementation class ItemRead
 */
@WebServlet("/colread")
public class CostOfLivingRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CostOfLivingDao itemDao;
	
	@Override
	public void init() throws ServletException {
		itemDao = CostOfLivingDao.getInstance();
		System.out.println("Debug 0");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		List<Item> itemList = new ArrayList<Item>();
        
		Item i = null;

		// Retrieve and validate name.
		// firstname is retrieved from the URL query string.
		String item = request.getParameter("item");
		if (item == null || item.trim().isEmpty()) {
			messages.put("success", "Please enter a valid item id.");
		} else {
			// Retrieve BlogUsers, and store as a message.
			try {
				i = itemDao.getItemByItemId(item);
				itemList.add(i);
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

		request.getRequestDispatcher("/ItemRead.jsp").forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		List<Item> itemList = new ArrayList<Item>();

		Item i = null;

		String item = request.getParameter("item");

		System.out.println(item);
		System.out.println("Debug 1");

		if (item == null || item.trim().isEmpty()) {
			messages.put("success", "Please enter a valid item id.");
		} else {
			System.out.println("Here in item!");

			System.out.println(i.getItem());
			System.out.println(i.getItem_name());
			messages.put("success", "Displaying results for " + item);
			messages.put("test", "debug2");
			// Save the previous search term, so it can be used as the default
			// in the input box when rendering FindUsers.jsp.
			messages.put("entered item id", item);
		}
		request.setAttribute("i", itemList);

		request.getRequestDispatcher("/ItemRead.jsp").forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

}
