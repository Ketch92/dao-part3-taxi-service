package core.controller.car;

import core.lib.Injector;
import core.model.Car;
import core.service.car.CarService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetMyCurrentCarsController extends HttpServlet {
    private static final Injector injector
            = Injector.getInstance("core");
    private static final String DRIVER_ID = "driverId";
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long driverId = (Long) req.getSession().getAttribute(DRIVER_ID);
        List<Car> cars = carService
                .getAllByDriver(driverId);
        req.setAttribute("cars", cars);
        req.setAttribute("title", "Cars of driver " + driverId);
        req.getRequestDispatcher("/WEB-INF/views/car/get_cars.jsp").forward(req, resp);
    }
}