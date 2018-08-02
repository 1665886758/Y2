package com.fj.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {},loadOnStartup = 2)
public class InitWebContextServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        // 记录上下文，${ctx} 绝对路径
        config.getServletContext().setAttribute("ctx",config.getServletContext().getContextPath());
    }
}
