package bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Module;
import bbs.entity.Response;
import bbs.entity.Theme;
import bbs.service.IResponseService;
import bbs.service.IThemeService;
import bbs.service.impl.ResponseServiceImpl;
import bbs.service.impl.ThemeServiceImpl;
import bbs.util.Common;

/**
 * Servlet implementation class ResponseServlet
 */
//@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected IThemeService themeService = new ThemeServiceImpl();
	protected IResponseService responseService = new ResponseServiceImpl();
	protected String method;
    protected String result; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	method = request.getParameter("method");
    	int visit = 1; 
		Theme theme;
		List<Response> replies = null;
    	
    	switch(method){
    	case "add":
    		result = responseService.add(request, response);
    		if(result.equals("NoUser")){
    			out.println(Common.AlertBack("请登录后进行回复"));
    		} else if(result.equals("ok")) {
    			out.println(Common.Alert("回复成功！"));
    			theme = themeService.find(request, response);
    			visit = themeService.getVisit(request, response);
    			replies = themeService.getReply(request, response);
    			request.setAttribute("theme", theme);
    			request.setAttribute("visit", visit);
    			request.setAttribute("replies", replies);
    			request.getRequestDispatcher("/jsp/themeDetail.jsp").forward(
    					request, response);
    		}
    		out.close();
    		break;
    	case "getAllReplies":
    		
    		break;
    	case "delete":
    		
    		break;
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
