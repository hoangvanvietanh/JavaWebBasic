package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entities.Product;
import model.ProCarModel;
import model.ProductModel;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ProCarModel proCarModel = new ProCarModel();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page="";
		String masp = request.getParameter("masp");
		HttpSession session = request.getSession();
		proCarModel.addPro(masp);
		request.setAttribute("list", proCarModel.getListItems());
		page = "showProduct.jsp";
		proCarModel.removeProduct(masp);
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Vao productSe");
		String page ="";
		String action = request.getParameter("action");
		String msp = request.getParameter("txtmsp");
		String tensp = request.getParameter("txttensp");
		String gia1 = request.getParameter("txtgia");
		int gia = Integer.parseInt(gia1);
		String hinh = request.getParameter("txthinh");
		System.out.println("Hinh la: |"+hinh+"|");
		String madm = request.getParameter("txtmadm");
		
		Part file = request.getPart("file");
		ProductModel pm = new ProductModel(file);
		String hinh2 = pm.getFileName(file);
		Product product;
		if(hinh2.equals(""))
		{
			product = new Product(msp, tensp, gia, hinh, madm);
		}
		else
		{
			product = new Product(msp, tensp, gia, hinh2, madm);
		}
		
		ProductModel productModel = new ProductModel(product);
		
		
		/*if(action.equals("upload"))
		{
			Part file = request.getPart("file");
			ProductModel pm = new ProductModel(file);
			String uploadRootPath = request.getServletContext().getRealPath("images");
			pm.uploadFile(uploadRootPath);
		}*/
		if(action.equals("insert"))
		{
			System.out.println("vao insert");
			int kq = productModel.insertProduct();
			if(kq==0)
			{
				System.out.println("Insert that bai");
			}
			page="insert.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
		if(action.equals("update"))
		{
			System.out.println("Vao update");
			int kq = productModel.updateProduct();
			if(kq==0)
			{
				System.out.println("update that bai");
			}
			else
			{
				System.out.println("Update thanh cong");
			}
			page="update.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
