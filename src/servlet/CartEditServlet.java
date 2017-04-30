package servlet;

import model.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mario on 28.04.2017.
 */
@WebServlet(name = "CartEditServlet",urlPatterns = "/editCart")
public class CartEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int index = Integer.parseInt(request.getParameter("index"));


        List<OrderItem> orderItems = (List<OrderItem>) request.getSession().getAttribute("orderItems");

        if(action.equals("remove")){
            for(int i=0; i <= orderItems.size(); i++ )
            if(i==index){
                orderItems.remove(i);
            }

            request.getSession().setAttribute("orderItems",orderItems);
            response.sendRedirect("/cart");
        }
        else{
            int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
            for(int i=0; i <= orderItems.size(); i++ )
                if(i==index) {
                    orderItems.get(i).setQuantity(newQuantity);
                }
            request.getSession().setAttribute("orderItems",orderItems);
            response.sendRedirect("/cart");
//            response.sendRedirect(request.getContextPath()+"WEB-INF/view/cart.jsp");
        }

    }
}
