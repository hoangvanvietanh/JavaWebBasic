package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Danhmuc;
import model.Danhmucmodel;

/**
 * Servlet implementation class danhMucServlet
 */
@WebServlet("/danhMucServlet")
public class danhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //Danhmucmodel dmModel = new Danhmucmodel();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public danhMucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page ="";
		String action = request.getParameter("action");
		String madm = request.getParameter("txtmadm");
		String tendm = request.getParameter("txttendm");
		Danhmuc dm = new Danhmuc(madm, tendm);
		Danhmucmodel dmModel = new Danhmucmodel(dm);
		if(action.equals("insert"))
		{
			System.out.println("vao insert");
			int kq = dmModel.insertDM();
			if(kq==0)
			{
				System.out.println("Them that bai!!!");
			}
			else
			{
				System.out.println("Them thanh cong");
			}
		}
	}

}
