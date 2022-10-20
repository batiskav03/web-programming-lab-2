package server;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/check")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestType = request.getParameter("requestType");
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher;
        switch (requestType) {
            case "checkLimits":
                dispatcher = context.getRequestDispatcher("/DotTradeServlet");
                dispatcher.forward(request, response);
                break;
            case "get_from_DB":
            case "write_into_DB":
                dispatcher = context.getRequestDispatcher("/AreaServlet");
                dispatcher.forward(request, response);
                break;
            default:
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
