package com.jee.hello.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Header extends TagSupport{
	private static final long serialVersionUID = 4318240657455371033L;

	String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void release() {
		userName = "";
	}
	
	
	@Override
	public int doStartTag() throws JspException{
		JspWriter out = pageContext.getOut();
		try {
			out.println("<div class='header__container'>");
			out.println("<div class='header'>");
			out.println("	<h1> <strong>" + userName + "</strong> </h1>");
			out.println("</div>");
			
		} catch (Exception e) {
		}
		
		return -1;
	}
	
	@Override
	public int doEndTag() throws JspException{
		JspWriter out = pageContext.getOut();
		
		try {
			out.println("</div>");
			
		} catch (Exception e) {
		}
		return -1; 
	}
	
}