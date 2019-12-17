package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.Sua;

@WebServlet("/ThemSuaMoiServlet")
public class ThemSuaMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemSuaMoiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setAttribute("dsls", LoaiSuaBL.docTatCa());
	      request.setAttribute("dshs", HangSuaBL.docTatCa());
	      request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("dsls", LoaiSuaBL.docTatCa());
	    request.setAttribute("dshs", HangSuaBL.docTatCa());
        //Thi sinh viet them cac lenh vao day de thuc hien
        Sua newOne = new Sua();
        newOne.setHinh(request.getParameter("txtHinh"));
        newOne.setDonGia(Integer.parseInt(request.getParameter("txtDonGia")));
        newOne.setLoiIch(request.getParameter("txtLoiIch").toString());
        newOne.setTpDinhDuong(request.getParameter("txtTPDinhDuong"));
        newOne.setTrongLuong(Integer.parseInt(request.getParameter("txtTrongLuong")));
        newOne.setMaLoaiSua(request.getParameter("cboLoaiSua"));
        newOne.setMaHangSua(request.getParameter("cboHangSua"));
        newOne.setTenSua(request.getParameter("txtTenSua"));
        newOne.setMaSua(request.getParameter("txtMaSua"));
        
        SuaBL.themSua(newOne);
        
        request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

}
