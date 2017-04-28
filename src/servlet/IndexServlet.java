package servlet;

import dao.ItemDao;
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
@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
        List<Item> itemList = itemDao.getItems();

        request.setAttribute("itemList",itemList);
//        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
//        request.getRequestDispatcher(request.getContextPath()+"/index").forward(request,response);

    }
}
