package servlet;

import dao.ItemDao;
import model.Item;
import utils.Compar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by mario on 05.05.2017.
 */
@WebServlet(name = "SortServlet", urlPatterns = "/sort")
public class SortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String group = request.getParameter("group");
        String orderBy = request.getParameter("orderBy");

        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
        List<Item> itemList = itemDao.getItems();

        System.out.println("url niby ze strronki" + request.getAttribute("javax.servlet.forward.request_uri")  );

        if (group.equals("producent") && orderBy.equals("asc")) {         //sort column in table with <Item> by name of producent
            Collections.sort(itemList,Compar.itemProducentComparator());
        } else if (group.equals("producent") && orderBy.equals("desc")) { //sort and reverse results column in table with <Item> by name of producent
            Collections.sort(itemList, Compar.itemProducentComparator());
            Collections.reverse(itemList);

        } else if (group.equals("model") && orderBy.equals("asc")) {    //sort column in table with <Item> by name of model
            Collections.sort(itemList, Compar.itemModelComparator());
        } else if (group.equals("model") && orderBy.equals("desc")) {   //sort and reverse results column in table with <Item> by name of model
            Collections.sort(itemList, Compar.itemModelComparator());
            Collections.reverse(itemList);

        } else if (group.equals("price") && orderBy.equals("asc")) {    //sort column in table with <Item> by name of price
            Collections.sort(itemList, Compar.itemPriceComparator());
        } else if (group.equals("price") && orderBy.equals("desc")) {   //sort and reverse results column in table with <Item> by name of price
            Collections.sort(itemList, Compar.itemPriceComparator());
            Collections.reverse(itemList);
        }


        System.out.println("servlet "+request.getRequestURI().toString());
        request.getSession().setAttribute("itemList", itemList);
        request.getRequestDispatcher("WEB-INF/view/shop.jsp").forward(request, response);
//        request.getRequestDispatcher("/shop").forward(request, response);

    }
}
