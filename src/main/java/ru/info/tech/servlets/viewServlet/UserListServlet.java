package ru.info.tech.servlets.viewServlet;

import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.UsersDao;
import ru.info.tech.models.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sulaymon on 15.10.2017.
 */
public class UserListServlet extends HttpServlet {
    private UsersDao usersDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        usersDao = context.getBean(UsersDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersDao.findAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
