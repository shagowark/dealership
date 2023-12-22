package web.configs;


import controllers.CarController;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
//public class ContextConfig implements ServletContextListener {
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        ServletContextListener.super.contextInitialized(sce);
//        ServletContext servletContext = sce.getServletContext();
//        servletContext.setAttribute("carController", CarController.getInstance());
//    }
//}
