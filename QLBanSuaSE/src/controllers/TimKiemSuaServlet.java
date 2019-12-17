package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.Sua;

@WebServlet("/TimKiemSuaServlet")
public class TimKiemSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimKiemSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //Thi sinh viet them cac lenh vao day de thuc hien
        request.setAttribute("dsls", LoaiSuaBL.docTatCa());
        request.setAttribute("dshs", HangSuaBL.docTatCa());
        //if(request.getParameter("txtTenSuaTim") == null) 
        	request.setAttribute("dss", new ArrayList<Sua>());
        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");

	        //Thi sinh viet them cac lenh vao day de thuc hien
	        request.setAttribute("dsls", LoaiSuaBL.docTatCa());
	        request.setAttribute("dshs", HangSuaBL.docTatCa());
	        request.setAttribute("dss", SuaBL.timSua(request.getParameter("txtTenSuaTim")));
	        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	            
	}

}
