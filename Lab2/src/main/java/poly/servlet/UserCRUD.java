package poly.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import poly.entity.User;
import poly.dao.UserDao;
import poly.dao.UserDaoImpl;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet ({
        "/user",
        "/user/crud/index",
        "/user/crud/edit/*",
        "/user/crud/create",
        "/user/crud/delete",
        "/user/crud/update",
        "/user/crud/reset"
})
public class UserCRUD extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao = new UserDaoImpl();
        User form = new User();
        try {
            BeanUtils.populate(form,req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        String message = "Enter user information";
        String path = req.getServletPath();
        if (path.contains("edit")) {
            String id = req.getPathInfo().substring(1);
            form = dao.findById(id);
            message = "Edit" + id;
        }else if (path.contains("create")) {
            dao.create(form);
            message = "Create user" + form.getId();
            form = new User();
        }else if (path.contains("delete")) {
            dao.deleteById(form.getId());
            message = "Delete user" + form.getId();
            form = new User();
        }else if (path.contains("update")) {
            dao.update(form);
            message = "Update user" + form.getId();
        }else if (path.contains("reset")) {
            form = new User();
        }
        List<User> list = dao.findAll();

        req.setAttribute("message",message );
        req.setAttribute("users",list);
        req.setAttribute("user",form);
        req.getRequestDispatcher("/pages/user-crud.jsp").forward(req,resp);
    }
}
