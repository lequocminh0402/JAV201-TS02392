package poly.com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poly.com.dao.FavoriteDao;
import poly.com.dao.impl.FavoriteDaoImpl;

import java.io.IOException;

@WebServlet("/favorite")
public class Favorite extends HttpServlet {
    FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("favorite", favoriteDao.findAll());
        req.getRequestDispatcher("/views/favorite.jsp").forward(req, resp);
    }
}
