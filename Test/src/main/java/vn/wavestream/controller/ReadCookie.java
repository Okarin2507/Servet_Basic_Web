package vn.wavestream.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/read-cookie")
public class ReadCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Lấy một mảng tất cả các cookie từ request của trình duyệt
        Cookie[] cookies = request.getCookies();

        out.println("<html><body>");
        // Kiểm tra xem có cookie nào không
        if (cookies != null) {
            out.println("<h2>Các Cookie đã tìm thấy:</h2>");
            // Duyệt qua mảng cookie và in ra tên và giá trị của từng cookie
            for (Cookie cookie : cookies) {
                out.print("<b>Tên:</b> " + cookie.getName() + ", ");
                out.print("<b>Giá trị:</b> " + cookie.getValue() + "<br/>");
            }
        } else {
            out.println("<h2>Không tìm thấy cookie nào.</h2>");
        }
        out.println("</body></html>");
    }
}
