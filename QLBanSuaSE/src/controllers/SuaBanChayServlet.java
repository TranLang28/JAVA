package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaBL;
import businessLogics.SuaBL;
import javaBeans.Sua;

@WebServlet("/SuaBanChayServlet")
public class SuaBanChayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaBanChayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        List<Sua> ret = SuaBL.docSuaBanNhieu();
        //Thi sinh viet them cac lenh vao day de thuc hien
        request.setAttribute("dss", ret);
        String maSua = request.getParameter("maSua");
        if(maSua == null)
        	request.setAttribute("Choosen", ret.get(0));
        else {
        	for(Sua ms: ret) {
        		if(ms.getMaSua().equals(maSua)) {
        			request.setAttribute("Choosen", ms);
        			break;
        		}
        	}
        }
        request.getRequestDispatcher("views/sua-ban-chay.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
