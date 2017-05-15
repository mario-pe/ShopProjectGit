package servlet;

import dao.ItemDao;
import model.Item;
import utils.comparators.ComparatorItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
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
        Deque<String> visitHistory = (Deque<String>) request.getSession().getAttribute("visitHistory");
        String link = visitHistory.getFirst();

        if (group.equals("producent") && orderBy.equals("asc")) {         //sort column in table with <Item> by name of producent
            Collections.sort(itemList, ComparatorItem.itemProducentComparator());
        } else if (group.equals("producent") && orderBy.equals("desc")) { //sort and reverse results column in table with <Item> by name of producent
            Collections.sort(itemList, ComparatorItem.itemProducentComparator());
            Collections.reverse(itemList);
        } else if (group.equals("id") && orderBy.equals("asc")) {    //sort column in table with <Item> by Id
            Collections.sort(itemList, ComparatorItem.itemIdComparator());
        } else if (group.equals("id") && orderBy.equals("desc")) {   //sort and reverse results column in table with <Item> by Id
            Collections.sort(itemList, ComparatorItem.itemIdComparator());
            Collections.reverse(itemList);
        }else if (group.equals("model") && orderBy.equals("asc")) {    //sort column in table with <Item> by name of model
            Collections.sort(itemList, ComparatorItem.itemModelComparator());
        } else if (group.equals("model") && orderBy.equals("desc")) {   //sort and reverse results column in table with <Item> by name of model
            Collections.sort(itemList, ComparatorItem.itemModelComparator());
            Collections.reverse(itemList);

        } else if (group.equals("price") && orderBy.equals("asc")) {    //sort column in table with <Item> by name of price
            Collections.sort(itemList, ComparatorItem.itemPriceComparator());
        } else if (group.equals("price") && orderBy.equals("desc")) {   //sort and reverse results column in table with <Item> by name of price
            Collections.sort(itemList, ComparatorItem.itemPriceComparator());
            Collections.reverse(itemList);
        } else if (group.equals("stock") && orderBy.equals("asc")) {    //sort column in table with <Item> by name of stock
            Collections.sort(itemList, ComparatorItem.itemStockComparator());
        } else if (group.equals("stock") && orderBy.equals("desc")) {   //sort and reverse results column in table with <Item>
            Collections.sort(itemList, ComparatorItem.itemStockComparator());
            Collections.reverse(itemList);
        }


//        System.out.println("servlet "+request.getRequestURI().toString());
        request.getSession().setAttribute("itemList", itemList);
        request.getSession().setAttribute("orderBy", orderBy);
        request.getSession().setAttribute("group",group );

        if (link.equals("http://localhost:8080/shop"))
            request.getRequestDispatcher("WEB-INF/view/shop.jsp").forward(request, response);
        else if (link.equals("http://localhost:8080/admin"))
            request.getRequestDispatcher("WEB-INF/admin/admin.jsp").forward(request, response);
        else if (link.equals("http://localhost:8080/order_form"))
            request.getRequestDispatcher( "WEB-INF/admin/order_admin.jsp").forward(request, response);

//        request.getRequestDispatcher("/shop").forward(request, response);

    }
}
