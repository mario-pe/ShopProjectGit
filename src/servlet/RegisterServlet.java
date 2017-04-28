package servlet;

import dao.AddressDao;
import dao.CustomerDao;
import model.Address;
import model.Customer;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 26.04.2017.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao custDao = (CustomerDao) request.getAttribute("customerDao");
        AddressDao addressDao = (AddressDao) request.getAttribute("addressDao");

        String fn = request.getParameter("firstName");
        String ln = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String house = request.getParameter("house");
        String zip = request.getParameter("zip");


        System.out.println(fn + ln + login + password);

        if (login != null && password != null && password2 != null && password.equals(password2) && !"".equals(password)
                && fn != null && ln != null && city != null && street != null && house != null && zip != null) {

            try {
                custDao.getCustomerByLogin(login);
                request.setAttribute("error", "taki login juz istnieje");
                doGet(request, response);

            } catch (NoResultException e) {

                Customer customer = new Customer();
                customer.setFirstName(fn);
                customer.setLastName(ln);
                customer.setLogin(login);
                customer.setPassword(password);

                Address address = new Address();
                address.setCity(city);
                address.setStreet(street);
                address.setHouse(house);
                address.setZip(zip);
                address.setCustomer(customer);
                System.out.println(city);


                if(custDao.addCustomer(customer) && addressDao.addAddress(address))
                {
                    request.getSession().setAttribute("customer", customer);
                    response.sendRedirect(request.getContextPath() + "/shop");
                }
                else{
                    request.setAttribute("error", "Nie udało sie dodac użytkownika");
                    doGet(request, response);
                }
            }
        }
        else {
            request.setAttribute("error", "problem z danymi");
            doGet(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
    }
}
