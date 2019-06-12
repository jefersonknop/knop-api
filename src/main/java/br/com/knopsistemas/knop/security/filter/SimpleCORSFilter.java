package br.com.knopsistemas.knop.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
//TODO: check CORS filter of Spring MVC
public class SimpleCORSFilter implements Filter {
	private final Log logger = LogFactory.getLog(this.getClass());

   /** {@inheritDoc}} */
   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
	   logger.info("knop-api  -  SimpleCORSFilter loaded");
   }

   /** {@inheritDoc}} */
   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException {
       HttpServletResponse httpResponse = (HttpServletResponse) response;
       httpResponse.setHeader("Access-Control-Allow-Origin", "*");
       httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
       httpResponse.setHeader("Access-Control-Max-Age", "3600");            
      // httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization,  Access-Control-Allow-Headers");
     
       httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
     //  httpResponse.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER,Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
     //  httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, authorization, ACCESS_TOKEN, TIME_OF_CALL");

     
       chain.doFilter(request, response);
   }

   /** {@inheritDoc}} */
   @Override
   public void destroy() {}

}