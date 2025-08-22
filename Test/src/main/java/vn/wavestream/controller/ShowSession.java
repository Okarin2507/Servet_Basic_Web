package vn.wavestream.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/show-session")
public class ShowSession extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Lấy session hiện tại. Không tạo mới nếu chưa có (truyền false)
        HttpSession session = request.getSession(false);

        // Kiểm tra xem session có tồn tại không
        if (session != null) {
            // Truy xuất dữ liệu từ session bằng key
            String ten = (String) session.getAttribute("ten");
            Integer tuoi = (Integer) session.getAttribute("tuoi");

            // Kiểm tra xem dữ liệu trong session có thực sự tồn tại không
            if (ten != null && tuoi != null) {
                out.println("<h2>Thông tin Session:</h2>");
                out.println("Xin chào bạn: " + ten + "<br/>");
                out.println("Tuổi: " + tuoi);
            } else {
                out.println("<h3>Dữ liệu trong session không tồn tại.</h3>");
                out.println("<a href='create-session'>Khởi tạo lại session</a>");
            }

        } else {
            // Nếu session không tồn tại, chuyển hướng người dùng về trang tạo session
            out.println("<h3>Session chưa được tạo. Đang chuyển hướng...</h3>");
            response.sendRedirect("create-session");
        }
    }
}