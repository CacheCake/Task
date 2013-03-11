package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HRActionFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpSession se = ((HttpServletRequest) request).getSession();
		String uRole = String.valueOf(se.getAttribute("uRole"));
		if (uRole != null)
		{
			if (!"1".equals(uRole)) {
				((HttpServletResponse) response).sendRedirect("/Task/filter_back.jsp");
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			((HttpServletResponse) response).sendRedirect("/Task/filter_back.jsp");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
