package vn.wavestream.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Nên giữ lại dòng này

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Login.html");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); // Thêm charset=UTF-8 để hỗ trợ tiếng Việt
        req.setCharacterEncoding("UTF-8"); // Thêm dòng này

        // Lấy dữ liệu từ tham số của form
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        // Giả sử kiểm tra đăng nhập thành công
        if ("Okarin".equals(user) && "12345".equals(pass)) { // Dùng .equals() để so sánh chuỗi
            // Khởi tạo cookie
            Cookie cookie = new Cookie("username", user);
            // Thiết lập thời gian tồn tại 30s của cookie
            cookie.setMaxAge(30);
            // Thêm cookie vào response
            resp.addCookie(cookie);
            // Chuyển sang trang HelloServlet
            resp.sendRedirect("hello"); // Giả sử bạn có một HelloServlet ở URL /hello
        } else {
            // Chuyển về lại trang Login nếu sai
            resp.getWriter().print("<h1>Username or password is incorrect!</h1>");
            req.getRequestDispatcher("Login.html").include(req, resp);
        }
    }
}