package adminPanel.servlets;

import model.OrderItem;
import utils.FileAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mario on 03.05.2017.
 */
@WebServlet(name = "AdminOrderServlet",urlPatterns = "/admin_order")
public class AdminOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        private static final String userFileName = "src\\user.ser";
        response.setContentType("text/plain;charset=utf-8");
        ArrayList<OrderItem> orderItemList = (ArrayList<OrderItem>) request.getSession().getAttribute("orderItemList");

        String webInfPath = getServletConfig().getServletContext().getRealPath("WEB-INF");
        File newFile = new File(webInfPath +"\\orders\\ new\\1.xml");
        String filePath =  webInfPath +"\\orders\\new\\1.xml";
        System.out.println("sout "+ filePath);


        FileAction.writeOrderListToFile(orderItemList,filePath);


        response.sendRedirect(request.getContextPath()+"/admin");

    }
}
