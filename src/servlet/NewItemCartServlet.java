package servlet;

import dao.ItemDao;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 27.04.2017.
 */
@WebServlet(name = "NewItemCartServlet",urlPatterns = "/new_item_cart")
public class NewItemCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");

        int id = Integer.parseInt(request.getParameter("id"));
        Item item = itemDao.getItemById(id);
        request.setAttribute("item",item);


        request.getRequestDispatcher(request.getContextPath()+"WEB-INF/view/addToCart.jsp").forward(request,response);
//        response.sendRedirect();
    }
}
