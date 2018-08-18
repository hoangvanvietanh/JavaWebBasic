package com.green.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.green.example.entity.Contact;
import com.green.example.model.ContactDetailModel;

/**
 * Servlet implementation class userServlet
 */

public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("action");
		System.out.println(mode);
		String name = request.getParameter("name");
		Part file = request.getPart("file");
		ContactDetailModel pm = new ContactDetailModel(file);
		String photo = pm.getFileName(file);
		String uploadRootPath = request.getServletContext().getRealPath("resources/images/");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("gender");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		if(mode.equals("insert"))
		{
			pm.uploadFile(uploadRootPath);
			Contact us = new Contact(name,photo, birthday, sex, address, phone, email, note);
			ContactDetailModel user = new ContactDetailModel(us);
			int kq = user.insertUser();
			if(kq==0)
			{
				System.out.println("Insert that bai");
			}
			else
			{
				System.out.println("insert thanh cong");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
		        dispatcher.forward(request, response);
			}
		}
	}

}
