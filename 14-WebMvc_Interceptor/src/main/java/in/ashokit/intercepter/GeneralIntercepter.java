package in.ashokit.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GeneralIntercepter implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(GeneralIntercepter.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle invoked.....{}:{}" + request.getRequestURI(), request.getMethod());

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		logger.info("postHandle invoked.....{}:{}" + request.getRequestURI(), request.getMethod());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		
		if(ex!=null) {
			logger.error("error inside afterCompletion()"+ex.getMessage());
		}
		
		logger.info("afterCompletion invoked.....{}:{}" + request.getRequestURI(), request.getMethod());
		

	}

}
