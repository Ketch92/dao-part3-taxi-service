package core.service.car;

import core.dao.car.CarDao;
import core.dao.driver.DriverDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.Car;
import core.model.Driver;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private CarDao carDao;
    
    @Inject
    private DriverDao driverDao;
    
    @Override
    public Car add(Car car) {
        return carDao.add(car);
    }
    
    @Override
    public Car get(Long id) {
        return carDao.get(id).get();
    }
    
    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }
    
    @Override
    public Car update(Car car) {
        return carDao.update(car);
    }
    
    @Override
    public boolean delete(Long id) {
        return carDao.delete(id);
    }
    
    @Override
    public void addDriverToCar(Driver driver, Car car) {
        car.addDriver(driver);
        carDao.update(car);
    }
    
    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        car.getDriverList().remove(driver);
        carDao.update(car);
    }
    
    @Override
    public List<Car> getAllByDriver(Long driverId) {
        return carDao.getAllByDriver(driverId);
    }
}
