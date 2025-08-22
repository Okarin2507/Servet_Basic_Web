package vn.wavestream.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/create-cookie")
public class CreateCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận dữ liệu từ FORM thông qua các tham số 'ten' và 'holot'
        String ten = request.getParameter("ten");
        String holot = request.getParameter("holot");

        // Tạo hai đối tượng Cookie: một cho tên và một cho họ lót
        Cookie firstName = new Cookie("ten", ten);
        Cookie lastName = new Cookie("holot", holot);

        // Thiết lập thời gian tồn tại của cookie là 24 giờ (tính bằng giây)
        // 60 giây * 60 phút * 24 giờ
        firstName.setMaxAge(60 * 60 * 24);
        lastName.setMaxAge(60 * 60 * 24);

        // Thêm cả hai cookie vào HTTP response header để gửi về cho trình duyệt
        response.addCookie(firstName);
        response.addCookie(lastName);

        // Gửi thông báo về cho người dùng
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h3>Cookie đã được tạo thành công!</h3>");
        out.println("<a href='read-cookie'>Đi đến trang đọc cookie</a>");
    }
}