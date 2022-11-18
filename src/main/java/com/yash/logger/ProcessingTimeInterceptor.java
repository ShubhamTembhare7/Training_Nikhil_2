package com.yash.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

public class ProcessingTimeInterceptor implements HandlerInterceptor {
	
	private static final Logger LOGGER=Logger.getLogger(ProcessingTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
	long startTime= System.currentTimeMillis();
	request.setAttribute("StartTime", startTime);
		
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		long endTime=System.currentTimeMillis();
		long startTime=(long) request.getAttribute("StartTime");
		String url=request.getRequestURI()+"?"+request.getQueryString();
		LOGGER.info(String.format("It took %s millisec the request %s", (endTime-startTime),url));
		
	}

	
	
}
