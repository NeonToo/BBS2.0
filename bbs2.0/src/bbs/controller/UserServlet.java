package bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.entity.User;
import bbs.service.IUserService;
import bbs.service.impl.UserServiceImpl;
import bbs.util.Common;
import bbs.util.Constant;

/**
 * Servlet implementation class UserServlet
 */
// @WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected IUserService userService = new UserServiceImpl();
	protected String method;
	protected boolean result;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		method = request.getParameter("method");

		switch (method) {
		case "add":
			result = userService.add(request, response);
			if (!result) {
				out.println(Common.AlertBack("此账号已被注册！请使用其他账号！"));
			} else {
				out.println(Common.AlertTo("注册成功！", "/bbs2.0/InitServlet"));
			}
			out.close();
			break;
		case "search":

			break;
		case "modify":

			break;
		case "delete":

			break;
		case "login":
			result = userService.login(request, response);
			if (result) {
				response.sendRedirect("/bbs2.0/InitServlet");
			} else {
				out.println(Common.AlertBack("账号或密码错误！请重新输入！"));
			}
			out.close();
			break;
		case "logout":
			request.getSession().removeAttribute(Constant.USERID_MARK);
			request.getSession().removeAttribute(Constant.USER_NAME_MARK);
			response.sendRedirect("/bbs2.0/InitServlet");
			break;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
}
