package adminPanel.servlets;
import dao.ItemDao;
import model.Item;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mario on 03.05.2017.
 */

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
@DeclareRoles("admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");


        if(request.getSession().getAttribute("itemList") != null)
            request.getRequestDispatcher( "WEB-INF/admin/admin.jsp").forward(request, response);
        else{
            ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
           List<Item> itemList =  itemDao.getItems();
           request.getSession().setAttribute("itemList",itemList);
            request.getRequestDispatcher( "WEB-INF/admin/admin.jsp").forward(request, response);
        }




    }
}
