package bbs.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Visit;

public interface IVisitService {
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws IOException;

	public boolean delete(HttpServletRequest request,
			HttpServletResponse response);
	
	public List<Visit> getAll(HttpServletRequest request, HttpServletResponse response);

	public int getVisitCount(int theme_id);
}
