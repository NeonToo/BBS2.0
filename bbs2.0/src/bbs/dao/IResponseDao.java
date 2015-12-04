package bbs.dao;

import java.util.List;

import bbs.entity.Response;
import bbs.entity.Visit;

public interface IResponseDao extends IBaseDao<Response> {
	public int delete(int id);

	public Response find(int id);

	public List<Response> getReply(int theme_id);

	public Response findLastReply(int theme_id);
}
