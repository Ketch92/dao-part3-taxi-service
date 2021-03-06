package core.controller.car;

import core.lib.Injector;
import core.service.car.CarService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCarController extends HttpServlet {
    private static final Injector injector
            = Injector.getInstance("core");
    private final CarService carService
            = (CarService) injector.getInstance(CarService.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        carService.delete(Long.valueOf(id));
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
