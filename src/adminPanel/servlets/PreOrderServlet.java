package adminPanel.servlets;

import dao.ItemDao;
import model.Item;
import model.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 04.05.2017.
 */
@WebServlet(name = "OrderAdminServlet", urlPatterns = "/pre_order")
public class PreOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Item item = itemDao.getItemById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setProducent(item.getProducent());
        orderItem.setModel(item.getModel());
        orderItem.setQuantity(quantity);
        orderItem.setItem_id(item.getId());
        List<OrderItem> orderItemList;

        if( (orderItemList =(List<OrderItem>)request.getSession().getAttribute("orderItemList")) != null){
            orderItemList.add(orderItem);
        }else{
            orderItemList = new ArrayList<>();
            orderItemList.add(orderItem);
        }
        request.getSession().setAttribute("orderItemList",orderItemList);
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/admin/order_admin.jsp").forward(request, response);
    }
}
