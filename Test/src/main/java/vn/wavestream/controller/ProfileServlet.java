package vn.wavestream.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Lấy session hiện có, không tạo mới nếu chưa có
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("name") != null) {
            String name = (String) session.getAttribute("name");
            out.print("Chào bạn, " + name + " đến với trang quản lý tài khoản");
            out.print("<br><a href='logout'>Logout</a>");
        } else {
            out.print("Xin vui lòng đăng nhập");
            request.getRequestDispatcher("LoginSession.html").include(request, response);
        }
    }
}