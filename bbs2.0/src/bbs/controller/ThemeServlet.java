package bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Module;
import bbs.entity.Response;
import bbs.entity.Theme;
import bbs.entity.Visit;
import bbs.service.IModuleService;
import bbs.service.IResponseService;
import bbs.service.IThemeService;
import bbs.service.IVisitService;
import bbs.service.impl.ModuleServiceImpl;
import bbs.service.impl.ResponseServiceImpl;
import bbs.service.impl.ThemeServiceImpl;
import bbs.service.impl.VisitServiceImpl;
import bbs.util.Common;

/**
 * Servlet implementation class ThemeServlet
 */
// @WebServlet("/ThemeServlet")
public class ThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected IThemeService themeService = new ThemeServiceImpl();
	protected IModuleService moduleService = new ModuleServiceImpl();
	protected IResponseService responseService = new ResponseServiceImpl();
	protected IVisitService visitService = new VisitServiceImpl();
	protected String method;
	protected String result;
	private Map<Theme, Response> lastReply = new HashMap<Theme, Response>();
	private Map<Theme, Integer> replyCount = new HashMap<Theme, Integer>();
	private Map<Theme, Integer> visitCount = new HashMap<Theme, Integer>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		method = request.getParameter("method");
		int visit = 1;
		Theme theme;
		List<Theme> themes = null;
		List<Module> modules = null;
		List<Response> replies = null;

		switch (method) {
		case "add":
			result = themeService.add(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("发帖成功！", "/bbs2.0/InitServlet"));
			} else if (result.equals("ThemeExist")) {
				out.println(Common.AlertBack("此主题已存在！请使用其他主题名！"));
			} else if (result.equals("NoLogin")) {
				out.println(Common.AlertBack("请登录后发帖！"));
			} else if (result.equals("NoModule")) {
				out.println(Common.AlertBack("请选择所属模块！"));
			} else if (result.equals("error")) {
				out.println(Common.AlertBack("发帖失败！"));
			}
			out.close();
			break;
		case "visit":
			theme = themeService.visit(request, response);
			visit = themeService.getVisit(request, response);
			replies = themeService.getReply(request, response);
			request.setAttribute("theme", theme);
			request.setAttribute("visit", visit);
			request.setAttribute("replies", replies);
			request.getRequestDispatcher("/jsp/themeDetail.jsp").forward(
					request, response);
			out.close();
			break;
		case "search":
			themes = themeService.search(request, response);
			request.setAttribute("themes", themes);
			request.getRequestDispatcher("/jsp/searchTheme.jsp").forward(
					request, response);
			out.close();
			break;
		case "searchTheme":
			themes = themeService.searchTheme(request, response);
			for (int i = 0; i < themes.size(); i++) {
				Response reply = responseService.findLastReply(themes.get(i)
						.getId());
				int visit_num = visitService.getVisitCount(themes.get(i)
						.getId());
				int reply_num = responseService.getReplyCount(themes.get(i)
						.getId());
				if (reply != null) {
					lastReply.put(themes.get(i), reply);
				}
				replyCount.put(themes.get(i), reply_num);
				visitCount.put(themes.get(i), visit_num);
			}
			request.setAttribute("themes", themes);
			request.setAttribute("lastReply", lastReply);
			request.setAttribute("replyCount", replyCount);
			request.setAttribute("visitCount", visitCount);
			request.getRequestDispatcher("/jsp/searchTheme.jsp").forward(
					request, response);
			out.close();
			break;
		case "getAllModules":
			modules = moduleService.getAll(request, response);
			request.setAttribute("modules", modules);
			request.getRequestDispatcher("/jsp/addTheme.jsp").forward(request,
					response);
			out.close();
			break;
		case "get":
			theme = themeService.find(request, response);
			modules = moduleService.getAll(request, response);
			request.setAttribute("theme", theme);
			request.setAttribute("modules", modules);
			request.getRequestDispatcher("/jsp/modifyTheme.jsp").forward(
					request, response);
			out.close();
			break;
		case "getAll":
			themes = themeService.getAll(request, response);
			for (int i = 0; i < themes.size(); i++) {
				Response reply = responseService.findLastReply(themes.get(i)
						.getId());
				int visit_num = visitService.getVisitCount(themes.get(i)
						.getId());
				int reply_num = responseService.getReplyCount(themes.get(i)
						.getId());
				if (reply != null) {
					lastReply.put(themes.get(i), reply);
				}
				replyCount.put(themes.get(i), reply_num);
				visitCount.put(themes.get(i), visit_num);
			}
			request.setAttribute("themes", themes);
			request.setAttribute("lastReply", lastReply);
			request.setAttribute("replyCount", replyCount);
			request.setAttribute("visitCount", visitCount);
			request.getRequestDispatcher("/jsp/themes.jsp").forward(request,
					response);
			out.close();
			break;
		case "getHot":
			themes = themeService.getHot(request, response);
			for (int i = 0; i < themes.size(); i++) {
				Response reply = responseService.findLastReply(themes.get(i)
						.getId());
				int visit_num = visitService.getVisitCount(themes.get(i)
						.getId());
				int reply_num = responseService.getReplyCount(themes.get(i)
						.getId());
				if (reply != null) {
					lastReply.put(themes.get(i), reply);
				}
				replyCount.put(themes.get(i), reply_num);
				visitCount.put(themes.get(i), visit_num);
			}
			request.setAttribute("themes", themes);
			request.setAttribute("lastReply", lastReply);
			request.setAttribute("replyCount", replyCount);
			request.setAttribute("visitCount", visitCount);
			request.getRequestDispatcher("/jsp/hotThemes.jsp").forward(request,
					response);
			out.close();
			break;
		case "showAll":
			themes = themeService.getAll(request, response);
			request.setAttribute("themes", themes);
			request.getRequestDispatcher("/jsp/themeManage.jsp").forward(
					request, response);
			out.close();
			break;
		case "modify":
			result = themeService.update(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("帖子修改成功！",
						"/bbs2.0/ThemeServlet?method=showAll"));
			}
			out.close();
			break;
		case "delete":
			result = themeService.delete(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("帖子删除成功!",
						"/bbs2.0/ThemeServlet?method=showAll"));
			}
			out.close();
			break;
		case "top":
			result = themeService.top(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("帖子置顶成功!",
						"/bbs2.0/ThemeServlet?method=showAll"));
			}
			out.close();
			break;
		case "canceltop":
			result = themeService.cancelTop(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("取消置顶成功!",
						"/bbs2.0/ThemeServlet?method=showAll"));
			}
			out.close();
			break;
		case "lock":
			result = themeService.lock(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("帖子锁定成功!",
						"/bbs2.0/ThemeServlet?method=showAll"));
			}
			out.close();
			break;
		case "cancellock":
			result = themeService.cancelLock(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("解除锁定成功!",
						"/bbs2.0/ThemeServlet?method=showAll"));
			}
			out.close();
			break;
		case "hot":
			result = themeService.hot(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("热门贴设置成功!",
						"/bbs2.0/ThemeServlet?method=showAll"));
			}
			out.close();
			break;
		case "cancelhot":
			result = themeService.cancelHot(request, response);
			if (result.equals("ok")) {
				out.println(Common.AlertTo("热门贴设置成功!",
						"/bbs2.0/ThemeServlet?method=showAll"));
			}
			out.close();
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
