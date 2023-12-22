package web.servlets;

import enums.Gender;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Customer;
import services.CustomerService;
import services.impl.CustomerServiceImpl;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "customerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        customerService = CustomerServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customerService", CustomerServiceImpl.getInstance());
        getServletContext().getRequestDispatcher("/customers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "post" -> post(req, resp);
            case "delete" -> delete(req, resp);
            case "put" -> put(req, resp);
        }

    }

    private void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer(
                req.getParameter("lastName"),
                req.getParameter("firstName"),
                req.getParameter("middleName"),
                Integer.parseInt(req.getParameter("age")),
                Gender.fromString(req.getParameter("gender"))
        );
        customerService.save(customer);

        resp.sendRedirect("/customers");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        customerService.removeById(id);

        resp.sendRedirect("/customers");
    }

    private void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer(
                UUID.fromString(req.getParameter("id")),
                req.getParameter("lastName"),
                req.getParameter("firstName"),
                req.getParameter("middleName"),
                Integer.parseInt(req.getParameter("age")),
                Gender.fromString(req.getParameter("gender"))
        );
        customerService.update(customer);

        resp.sendRedirect("/customers");
    }
}
