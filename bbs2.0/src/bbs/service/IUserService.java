package bbs.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.User;

public interface IUserService {
	public boolean add(HttpServletRequest request, HttpServletResponse response) throws IOException;

	public String update(HttpServletRequest request,
			HttpServletResponse response);

	public String delete(HttpServletRequest request,
			HttpServletResponse response);

	public User find(HttpServletRequest request, HttpServletResponse response);
	
	public boolean login(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
