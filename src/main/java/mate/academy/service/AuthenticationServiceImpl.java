package mate.academy.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Method login was called with login={}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        logger.trace("Method findByLogin was called with login={}", login);
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        logger.trace("User login={}, userID={} was found", user.getLogin(), user.getUserId());
        return user;
    }
}
