package servlet;

import dao.ItemDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.ShippingDao;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by mario on 26.04.2017.
 */
@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShippingDao shippingDao = (ShippingDao) request.getAttribute("shippingDao");
        OrderDao orderDao = (OrderDao) request.getAttribute("orderDao");
        OrderItemDao orderItemDao = (OrderItemDao) request.getAttribute("orderItemDao");
        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");

        String payment = request.getParameter("payment");
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        List<OrderItem> orderItems = (List<OrderItem>) request.getSession().getAttribute("orderItems");
        Shipping shipping = shippingDao.getShippingById(Integer.parseInt(request.getParameter("shipping")));
        /*
        * preparing of new order
         */
        Timestamp date = new Timestamp(new Date().getTime());
        Order order = new Order();
        order.setCustomer(customer);
        order.setPayment(payment);
        order.setShipping(shipping.getType());
        order.setShippingCost(shipping.getPrice());
        order.setDate(date);
        /*
         *    adding  new order
         */
        if (orderItems != null) {
            order.setWholeValue(order.wholeValueOrder(orderItems, shipping.getPrice()));
            if (orderDao.addOrder(order)) {
                String info = "złożyłes zamówienie, numer zamoweinia to " + order.getId();
                for (OrderItem oi : orderItems) {
                    oi.setOrder(order);                 //making connections between orderItems and order
                    Item item = itemDao.getItemById(oi.getItem_id());  // updating current stock
                    item.setStock(item.getStock() - oi.getQuantity());
                    orderItemDao.addOrderItem(oi);      // orderItem added to database
                }
                request.setAttribute("info", info);
                request.getSession().removeAttribute("orderItems");
            } else request.setAttribute("info", "nie dodano zamowienia, próbuj jeszcze raz ");
        } else request.setAttribute("info", "nie masz produktow w koszyku ");

        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/view/order.jsp").forward(request, response);
    }

}
