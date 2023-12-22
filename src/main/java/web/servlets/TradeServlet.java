package web.servlets;

import enums.Gender;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Customer;
import services.TradeService;
import services.impl.TradeServiceImpl;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "tradeServlet", urlPatterns = "/trades")
public class TradeServlet extends HttpServlet {
    private TradeService tradeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        tradeService = TradeServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tradeService", tradeService);
        getServletContext().getRequestDispatcher("/trades.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer(
                req.getParameter("customerLastName"),
                req.getParameter("customerFirstName"),
                req.getParameter("customerMiddleName"),
                Integer.parseInt(req.getParameter("customerAge")),
                Gender.fromString(req.getParameter("customerGender"))
        );
        UUID carID = UUID.fromString(req.getParameter("carId"));
        tradeService.sellCar(carID, customer);

        resp.sendRedirect("/trades");
    }
}
