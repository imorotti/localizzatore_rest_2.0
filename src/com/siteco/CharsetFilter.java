/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteco;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 * @author Ivan
 */
public class CharsetFilter implements Filter {

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        // Respect the client-specified character encoding
        // (see HTTP specification section 3.4.1)
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }
        
        /*String url = null;
        if (request instanceof HttpServletRequest) {
            url = getCurrentUrlFromRequest((HttpServletRequest)request);
            if (url.toLowerCase().endsWith(".css") || url.toLowerCase().endsWith(".js")) {
                next.doFilter(request, response);
                return;
            }
        }*/
        // Set the default response content type and encoding
        
        //response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        next.doFilter(request, response);
    }

    public void destroy() {
    }
    
    private String getCurrentUrlFromRequest(HttpServletRequest request)
    {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null)
            return requestURL.toString();

        return requestURL.append('?').append(queryString).toString();
    }
}