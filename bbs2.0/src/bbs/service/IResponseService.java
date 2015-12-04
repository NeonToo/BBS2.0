package bbs.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Response;

public interface IResponseService {
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws IOException;

	public boolean delete(HttpServletRequest request,
			HttpServletResponse response);
	
	public List<Response> getAll(HttpServletRequest request, HttpServletResponse response);

	public Response findLastReply(int theme_id);

	public int getReplyCount(int theme_id);
}
