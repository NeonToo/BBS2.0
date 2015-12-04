package bbs.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.IVisitDao;
import bbs.dao.impl.VisitDaoImpl;
import bbs.entity.Visit;
import bbs.service.IVisitService;

public class VisitServiceImpl implements IVisitService {
	IVisitDao visitDao = new VisitDaoImpl();
	
	@Override
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Visit> getAll(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVisitCount(int theme_id) {
		// TODO Auto-generated method stub
		return visitDao.getVisit(theme_id).size();
	}

}
