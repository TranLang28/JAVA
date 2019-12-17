 package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.KhachHangBL;
import javaBeans.KhachHang;

@WebServlet("/ThemKhachHangServlet")
public class ThemKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemKhachHangServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //Thi sinh viet them cac lenh vao day de thuc hien
        KhachHang newOne = new KhachHang();
        newOne.setEmail(request.getParameter("txtEmail"));
        newOne.setDienThoai(request.getParameter("txtDienThoai"));
        newOne.setDiaChi(request.getParameter("txtDiaChi"));
        newOne.setPhai(request.getParameter("rdbPhai")=="Nam");
        newOne.setTenKH(request.getParameter("txtTenKH"));
        newOne.setMaKH(request.getParameter("txtMaKH"));
        KhachHangBL.themKhachHang(newOne);
        request.getRequestDispatcher("views/them-khach-hang.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
