package bbs.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Response;
import bbs.entity.Theme;
import bbs.service.IModuleService;
import bbs.service.IResponseService;
import bbs.service.IThemeService;
import bbs.service.IVisitService;
import bbs.service.impl.ModuleServiceImpl;
import bbs.service.impl.ResponseServiceImpl;
import bbs.service.impl.ThemeServiceImpl;
import bbs.service.impl.VisitServiceImpl;

/**
 * Servlet implementation class InitServlet
 */
//@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected IThemeService themeService = new ThemeServiceImpl();
	protected IResponseService responseService = new ResponseServiceImpl();
	protected IVisitService visitService = new VisitServiceImpl();
	private Map<Theme, Response> lastReply = new HashMap<Theme, Response>();
	private Map<Theme, Integer> replyCount = new HashMap<Theme, Integer>();
	private Map<Theme, Integer> visitCount = new HashMap<Theme, Integer>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	List<Theme> themes = null;
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
		request.getRequestDispatcher("/jsp/home.jsp").forward(request,
				response);
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
