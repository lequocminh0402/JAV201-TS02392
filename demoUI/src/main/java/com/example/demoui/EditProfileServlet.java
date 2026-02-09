package com.example.demoui;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EditProfileServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO dao = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Kiểm tra xem người dùng đã đăng nhập chưa
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            // Nếu chưa đăng nhập, chuyển hướng về trang login
            response.sendRedirect("login");
            return;
        }

        // 2. Nếu đã đăng nhập, hiển thị trang edit-profile.jsp
        request.getRequestDispatcher("/views/edit-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); // Đọc tiếng Việt từ form
        response.setCharacterEncoding("utf-8");

        try {
            // 1. Lấy thông tin user hiện tại từ Session
            User currentUser = (User) request.getSession().getAttribute("user");

            if (currentUser != null) {
                // 2. Sử dụng BeanUtils để map dữ liệu từ Form vào một đối tượng tạm
                // Lưu ý: Tên trường trong form (name="fullname",...) phải trùng với field trong class User
                BeanUtils.populate(currentUser, request.getParameterMap());

                // 3. Gọi DAO để cập nhật vào Database (Sử dụng JPA merge)
                dao.update(currentUser);

                // 4. Cập nhật lại Session để các trang khác hiển thị thông tin mới ngay lập tức
                request.getSession().setAttribute("user", currentUser);

                request.setAttribute("message", "Cập nhật thông tin thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
        }

        // Quay lại trang edit để hiển thị thông báo
        request.getRequestDispatcher("/views/edit-profile.jsp").forward(request, response);
    }
}
