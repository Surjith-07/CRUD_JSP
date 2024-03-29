package filterutil;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/CreateStudent")
public class UserDetail implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String userName = httpServletRequest.getParameter("name");
		String userDepartment = httpServletRequest.getParameter("department");
		String userBranch = httpServletRequest.getParameter("branch");
		String userAddress = httpServletRequest.getParameter("address");
		if (userName.isEmpty() || userDepartment.isEmpty() || userBranch.isEmpty() || userAddress.isEmpty()) {
			RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("add.jsp");
			requestDispatcher.forward(httpServletRequest, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
