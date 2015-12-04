package bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Module;
import bbs.entity.Theme;
import bbs.service.IModuleService;
import bbs.service.IThemeService;
import bbs.service.impl.ModuleServiceImpl;
import bbs.service.impl.ThemeServiceImpl;
import bbs.util.Common;

/**
 * Servlet implementation class ModuleServlet
 */
//@WebServlet("/ModuleServlet")
public class ModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected IModuleService moduleService = new ModuleServiceImpl();
	protected IThemeService themeService = new ThemeServiceImpl();
	protected String method;
	protected boolean result;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	method = request.getParameter("method");
    	Module module;
    	List<Module> modules = null;
    	List<Theme> themes = null;
		
    	switch(method){
    	case "add":
    		result = moduleService.add(request, response);
    		if(result){
    			out.println(Common.AlertTo("模块添加成功！", "/bbs2.0/ModuleServlet?method=getAll"));
    		} else {
    			out.println(Common.AlertBack("此模块已存在！请使用其他模块名！"));
    		}
    		out.close();
    		break;
    	case "search":
    		modules = moduleService.search(request, response);
    		request.setAttribute("modules", modules);
    		request.getRequestDispatcher("/jsp/searchModule.jsp").forward(
					request, response);
    		break;
    	case "get":
    		module = moduleService.find(request, response);
    		modules = moduleService.getAll(request, response);
    		request.setAttribute("module", module);
    		request.setAttribute("modules", modules);
    		request.getRequestDispatcher("/jsp/modifyModule.jsp").forward(
					request, response);
    		break;
    	case "goto":
    		module = moduleService.find(request, response);
    		themes = moduleService.getModuleTheme(module.getId());
    		request.setAttribute("module", module);
    		request.setAttribute("themes", themes);
    		request.getRequestDispatcher("/jsp/moduleDetail.jsp").forward(
					request, response);
    		break;
    	case "getAll":
    		modules = moduleService.getAll(request, response);
    		request.setAttribute("modules", modules);
    		request.getRequestDispatcher("/jsp/modules.jsp").forward(
					request, response);
    		break;
    	case "showAll":
    		modules = moduleService.getAll(request, response);
    		request.setAttribute("modules", modules);
    		request.getRequestDispatcher("/jsp/moduleManage.jsp").forward(
					request, response);
    		break;
    	case "modify":
    		result = moduleService.update(request, response);
    		if(result){
    			out.println(Common.AlertTo("模块修改成功！", "/bbs2.0/ModuleServlet?method=showAll"));
    		}
    		break;
    	case "delete":
    		result = moduleService.delete(request, response);
    		if(result){
    			out.println(Common.AlertTo("模块删除成功!", "/bbs2.0/ModuleServlet?method=showAll"));
    		}
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
