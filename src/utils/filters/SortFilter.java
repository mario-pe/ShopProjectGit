package utils.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by mario on 05.05.2017.
 */
@WebFilter(filterName = "SortFilter", value = "/*")
public class SortFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String link = request.getRequestURL().toString();
//        System.out.println("link do sortu: " + link);
        if (!link.equals("http://localhost:8080/sort") && !link.equals("http://localhost:8080/style.css")) {
            if ((request.getSession().getAttribute("visitHistory") == null)) {
                Deque<String> visitHistory = new ArrayDeque<String>(); // stack is keeping url of two last pages visited by user
                visitHistory.push(link);
                request.getSession().setAttribute("visitHistory", visitHistory);
            } else {
                Deque<String> visitHistory = (Deque<String>) request.getSession().getAttribute("visitHistory");
                if (visitHistory.size() == 2) {
                    visitHistory.pollLast();
                    visitHistory.push(link);

                } else if (visitHistory.size() == 1)
                    visitHistory.push(link);

                request.getSession().setAttribute("visitHistory", visitHistory);
//                for (Object s : visitHistory)
//                    System.out.println("linki " + s);
            }
        }
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
