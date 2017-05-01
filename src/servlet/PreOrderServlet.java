package servlet;

import dao.PaymentDao;
import dao.ShippingDao;
import model.Customer;
import model.OrderItem;
import model.Payment;
import model.Shipping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mario on 30.04.2017.
 */
@WebServlet(name = "PreOrderServlet", urlPatterns = "/preOrder")
public class PreOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDao paymentDao = (PaymentDao) request.getAttribute("paymentDao");
        ShippingDao shippingDao = (ShippingDao) request.getAttribute("shippingDao");

        List<OrderItem> orderItems = (List<OrderItem>) request.getSession().getAttribute("orderItems");
        List<Payment> payments = paymentDao.getPayments();
        List<Shipping> shipping = shippingDao.getShipping();
        Customer customer = (Customer) request.getSession().getAttribute("customer");

        if(orderItems == null){
            request.setAttribute("info", "niemasz żadnych produktów w koszyku");
            request.setAttribute("orderItems", null);
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/view/preorder.jsp").forward(request, response);
        }
        else {
            request.setAttribute("info", "złóż zamóweinie");
            request.setAttribute("orderItems", orderItems);
            request.setAttribute("payments", payments);
            request.setAttribute("shipping", shipping);
            request.setAttribute("customer", customer);

            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/view/preorder.jsp").forward(request, response);
        }



    }
}
