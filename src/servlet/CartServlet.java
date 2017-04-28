package servlet;

import dao.ItemDao;
import model.Cart;
import model.Item;
import model.OrderItem;

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
@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.getWriter().println("twoj koszyk  servlet   /cart");
        List<OrderItem> orderItems = (List<OrderItem>) request.getSession().getAttribute("orderItems");
//        for(OrderItem oi: orderItems){
//            response.getWriter().println(oi.getProducent()+" " + oi.getModel()+" "+ oi.getPrice() +" " +oi.getQuantity());
//        }
        request.setAttribute("orderItems",orderItems);
        request.getRequestDispatcher(request.getContextPath()+"WEB-INF/view/cart.jsp").forward(request,response);

    }
}
