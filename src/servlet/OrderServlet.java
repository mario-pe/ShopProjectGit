package servlet;

import dao.NewOrderDao;
import dao.OrderItemDao;
import model.Customer;
import model.Order;
import model.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by mario on 26.04.2017.
 */
@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NewOrderDao orderDao = (NewOrderDao) request.getAttribute("orderDao");
        OrderItemDao orderItemDao = (OrderItemDao) request.getAttribute("orderItemDao");

        String payment = request.getParameter("payment");
        String shipping = request.getParameter("shipping");
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        List<OrderItem> orderItems = (List<OrderItem>) request.getSession().getAttribute("orderItems");
        Timestamp date = new Timestamp(new Date().getTime());

        Order order = new Order();
        order.setCustomer(customer);
        order.setPayment(payment);
        order.setShipping(shipping);
        order.setDate(date);

        orderDao.addOrder(order);
        response.getWriter().println(order.getId());

        for(OrderItem oi: orderItems){
            oi.setOrder(order);
            orderItemDao.addOrderItem(oi);

        }
    }
}
