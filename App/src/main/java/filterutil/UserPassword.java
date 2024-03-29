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
public class UserPassword implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String alphaString = "qwertyuioplkjhgfdsazxcvbnm";
		String UserPassword = httpServletRequest.getParameter("password");

		if (UserPassword.isEmpty()) {
			httpServletResponse.sendRedirect("signup.jsp");
			return;
		}

		for (char c : UserPassword.toCharArray()) {
			if (alphaString.indexOf(String.valueOf(c)) != -1) {
				String errorMessage = "Don't use small Alphabets in the password.";
				String encodedErrorMessage = URLEncoder.encode(errorMessage, "UTF-8");
				Cookie errorCookie = new Cookie("errorInPassword", encodedErrorMessage);
				httpServletResponse.addCookie(errorCookie);
				httpServletResponse.sendRedirect("signup.jsp");
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
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
}
