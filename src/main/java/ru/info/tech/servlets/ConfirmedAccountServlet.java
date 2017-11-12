package ru.info.tech.servlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.UserTempDao;
import ru.info.tech.dao.UsersDao;
import ru.info.tech.models.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sulaymon on 05.11.2017.
 */
@WebServlet("/confirm")
public class ConfirmedAccountServlet extends HttpServlet {
    private Logger log = Logger.getLogger(ConfirmedAccountServlet.class);
    private UserTempDao userTempDao;
    private UsersDao usersDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute("context");
        userTempDao = applicationContext.getBean(UserTempDao.class);
        usersDao = applicationContext.getBean(UsersDao.class);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String control_phrase = req.getParameter("control");
        log.info("We took control_phrase "+ control_phrase);
        User user = userTempDao.findUserByControlPhrase(control_phrase);
        log.info(" Name of user: "+ user.getName());
        if (user != null) {
            usersDao.save(user);
            userTempDao.delete(user.getEmail());
            user =null;
        }
        log.info(user);
        resp.sendRedirect("/home");

    }
}
