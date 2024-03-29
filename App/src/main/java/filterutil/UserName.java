package filterutil;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/Signup")
public class UserName implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String UserName = httpServletRequest.getParameter("username"), intString = "1234567890";
		if (UserName.isEmpty()) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("singup.jsp");
			requestDispatcher.forward(request, httpServletResponse);
			return;
		}

		for (char c : UserName.toCharArray()) {
			if (intString.indexOf(String.valueOf(c)) != -1) {
				String errorMessage = "Don't use numbers in the username.";
				String encodedErrorMessage = URLEncoder.encode(errorMessage, "UTF-8");
				Cookie errorCookie = new Cookie("errorInName", encodedErrorMessage);
				httpServletResponse.addCookie(errorCookie);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.jsp");
				requestDispatcher.forward(request, httpServletResponse);
				return;
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
