package ru.jmentor.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.jmentor.filter.AuthTokenFilter;

import javax.servlet.*;
import java.util.EnumSet;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("CP1251");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }

    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR);

        FilterRegistration.Dynamic monitoringFilter = servletContext.addFilter("authTokenFilter", AuthTokenFilter.class);
        monitoringFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/admin/*");
    }
}