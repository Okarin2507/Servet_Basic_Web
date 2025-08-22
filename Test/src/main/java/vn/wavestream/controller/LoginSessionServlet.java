package vn.wavestream.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-session")
public class LoginSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("Okarin") && password.equals("12345")) {
            out.print("Chào mừng bạn, " + username);
            // Lấy hoặc tạo mới session
            HttpSession session = request.getSession();
            // Gán thuộc tính vào session
            session.setAttribute("name", username);
            // Chuyển hướng đến trang profile
            response.sendRedirect("profile");
        } else {
            out.print("Tài khoản hoặc mật khẩu không chính xác");
            request.getRequestDispatcher("LoginSession.html").include(request, response);
        }
    }
}