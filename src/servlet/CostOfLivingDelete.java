package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import model.Item;

@WebServlet("/coldelete")
public class CostOfLivingDelete extends HttpServlet {

	protected ItemDao itemDao;

	@Override
	public void init() throws ServletException {
		itemDao = ItemDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		// Provide a title and render the JSP.
		messages.put("title", "Delete BlogUser");
		req.getRequestDispatcher("/ItemDelete.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve and validate name.
		String item = req.getParameter("item");

		Item i2 = null;
		try {
			i2 = itemDao.getItemByItemId(item);

			Item i3 = itemDao.delete(i2);
			// Update the message.
			if (i3 == null) {
				messages.put("title", "Successfully deleted " + item);
				messages.put("disableSubmit", "true");
			} else {
				messages.put("title", "Failed to delete " + item);
				messages.put("disableSubmit", "false");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		req.getRequestDispatcher("/ItemDelete.jsp").forward(req, resp);
	}
}
