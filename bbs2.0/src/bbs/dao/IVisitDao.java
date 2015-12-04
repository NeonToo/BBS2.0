package bbs.dao;

import java.util.List;

import bbs.entity.Visit;

public interface IVisitDao extends IBaseDao<Visit> {
	public int delete(int id);

	public List<Visit> getVisit(int theme_id);
}
