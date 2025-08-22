package vn.wavestream.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        String name = "";
        // Nhận cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    name = c.getValue();
                }
            }
        }

        if (!name.equals("")) {
            // Hiển thị lên trang bằng đối tượng PrintWriter()
            printWriter.println("Xin chao " + name);
        } else {
            // Chuyển sang trang LoginServlet nếu không có cookie
            printWriter.println("<h1>Please login first!</h1>");
            req.getRequestDispatcher("Login.html").include(req, resp);
        }
    }
}