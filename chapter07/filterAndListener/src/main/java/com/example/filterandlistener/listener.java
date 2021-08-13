package com.example.filterandlistener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener contextInitialized");
        System.out.println(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("filter contextDestroyed");
    }
}
