package adminPanel.servlets;

import dao.ItemDao;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 15.05.2017.
 */
@WebServlet(name = "OrderFormServlet", urlPatterns = "/order_form")
public class OrderFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       if(request.getSession().getAttribute("itemList")==null) {
           ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
           List<Item> itemList = itemDao.getItems();
           request.getSession().setAttribute("itemList", itemList);
       }
       else{
           ArrayList<Item> itemlist = (ArrayList<Item>) request.getSession().getAttribute("itemlist");
           request.setAttribute("itemlist",itemlist );
       }
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/admin/order_admin.jsp").forward(request, response);
    }
}
