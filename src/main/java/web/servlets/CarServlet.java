package web.servlets;

import enums.CarType;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Car;
import services.CarService;
import services.impl.CarServiceImpl;

import java.io.IOException;
import java.util.UUID;


@WebServlet(name = "carServlet", urlPatterns = "/cars")
public class CarServlet extends HttpServlet {
    private CarService carService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        carService = CarServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("carService", carService);
        getServletContext().getRequestDispatcher("/cars.jsp").forward(req, resp);
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
        Car car = new Car(
                CarType.fromString(req.getParameter("type")),
                req.getParameter("brand"),
                req.getParameter("model")
        );
        carService.save(car);

        resp.sendRedirect("/cars");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        carService.removeById(id);

        resp.sendRedirect("/cars");
    }

    private void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car(
                UUID.fromString(req.getParameter("id")),
                CarType.fromString(req.getParameter("type")),
                req.getParameter("brand"),
                req.getParameter("model")
        );
        carService.update(car);

        resp.sendRedirect("/cars");
    }
}
