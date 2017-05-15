package servlet;

import dao.ItemDao;
import model.Customer;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mario on 26.04.2017.
 */
@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
        List<Item> itemList = itemDao.getItems();
        request.getSession().setAttribute("itemList", itemList);
        Customer c = (Customer) request.getSession().getAttribute("customer");


        request.getRequestDispatcher("WEB-INF/view/shop.jsp").forward(request, response);



    }
}
