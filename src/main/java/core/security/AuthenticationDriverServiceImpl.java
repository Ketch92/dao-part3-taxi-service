package core.security;

import core.dao.driver.DriverDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.Driver;
import core.model.exception.AuthenticationException;

@Service
public class AuthenticationDriverServiceImpl implements AuthenticationDriverService {
    
    @Inject
    private DriverDao dao;
    
    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        String message = "No matches for such login or password.";
        Driver driver = dao.getByLogin(login)
                .orElseThrow(() -> new AuthenticationException(message));
        if (password.equals(driver.getPassword())) {
            return driver;
        }
        throw new AuthenticationException(message);
    }
}