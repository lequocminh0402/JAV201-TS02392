package poly.com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poly.com.dao.impl.UserDAOImpl;
import poly.com.entity.User;

import java.io.IOException;

@WebServlet("/youtube")
public class UserFavoriteServlet extends HttpServlet {
    UserDAOImpl userdao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userdao.findById("U01"); // Lê Quốc Minh
        req.setAttribute("user", user);

        req.getRequestDispatcher("/views/youtube.jsp").forward(req, resp);
    }
}
