package vn.wavestream.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/create-session")
public class CreateSession extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Khởi tạo session. Nếu chưa có session, server sẽ tạo mới.
        HttpSession session = request.getSession();

        // Gán dữ liệu vào session dưới dạng cặp key-value
        session.setAttribute("ten", "Nguyễn Hữu Trung");
        session.setAttribute("tuoi", 40); // Lưu ý: tuổi là Integer, không phải String

        // Thiết lập thời gian session hết hạn nếu không hoạt động (30 giây)
        session.setMaxInactiveInterval(30);

        // Hiển thị thông báo lên web
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h3>Xin chào bạn, session đã được tạo!</h3>");
        out.println("<a href='show-session'>Đi đến trang hiển thị session</a>");
    }
}