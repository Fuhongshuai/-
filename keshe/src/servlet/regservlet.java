package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.dao;

import user.Users;

public class regservlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public regservlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		request.setCharacterEncoding("utf-8");
		Users u=new Users();
		String email,name,password,passwords,phone,address;
		
		try {
			email=request.getParameter("email");
			password=request.getParameter("password");
			passwords=request.getParameter("passwords");
			name=request.getParameter("name");
			phone=request.getParameter("phone");
			address=request.getParameter("address");
			System.out.println();
			if(!email.equals("")&&!password.equals("")&&!passwords.equals("")&&!name.equals("")&&!phone.equals("")&&!address.equals(""))
			{
				
			if(password.equals(passwords)&&!password.equals(""))
			{
			System.out.println(request.getParameter("get"));	
				if(((String)request.getParameter("get")).equals("change"))
				{

					
					
					dao d=new dao();
						u.setEmail(email);
						u.setPassword(password);
						u.setPhone(phone);
						u.setUername(name);
						u.setAddress(address);
						if(d.changeAdm(u))
					//ע��
						{
						System.out.println("�޸ĳɹ�");
						request.getSession().setAttribute("regUser", u);
						response.sendRedirect(request.getContextPath()+"/articles.jsp");
						}
						else 
						{
							System.out.println("�޸�ʧ��");
							request.getSession().setAttribute("regUser", u);
							response.sendRedirect(request.getContextPath()+"/articles.jsp");
						}
					}
					
				}
				else {
					
				
				dao d=new dao();
				if(!d.SearchEmail(email))
				{
					
					u.setEmail(email);
					u.setPassword(password);
					u.setPhone(phone);
					u.setUername(name);
					u.setAddress(address);
					if(d.InsertAdm(u))
				//ע��
					{
					System.out.println("ע��ɹ�");
					request.getSession().setAttribute("regUser", u);
					response.sendRedirect(request.getContextPath()+"/articles.jsp");
					}
					else 
					{
						System.out.println("ע��ʧ��");
						response.sendRedirect(request.getContextPath()+"/reg.jsp");
					}
				}
				else 
				{
					System.out.println("�����Ѵ���"+email);
					response.sendRedirect(request.getContextPath()+"/reg.jsp");
					//���ص�¼����ʾ����
				}
				}
			/////
			}
			
			
			else {
				
				System.out.println("��Ϣ����Ϊ��");
				response.sendRedirect(request.getContextPath()+"/reg.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("��Ϣ����ȷ");
			response.sendRedirect(request.getContextPath()+"/reg.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
		// Put your code here
	}
	 public static void main(String[] args)
	 {
		
	 }
}
