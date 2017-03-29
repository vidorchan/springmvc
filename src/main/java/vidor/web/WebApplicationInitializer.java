package main.java.vidor.web;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

/**
 * 取代web.xml
 */
public class WebApplicationInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    //配置root上下文,如Jpa数据源等等的配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationContextConfig.class };
    }

    //配置dispatcher servlet，如果在root config指定了该转发规则就可以忽略
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletContextConfig.class };
    }

    //指定开始被servlet处理的url,配置从/开始
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    //配置servlet过滤器
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        DelegatingFilterProxy securityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");
//        return new Filter[] {characterEncodingFilter, securityFilterChain};
//    }

    public Filter[] getServletFilters() {
        return this.getFilters();
    }

    public Filter[] getFilters() {
//        return new Filter[0];
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
//        DelegatingFilterProxy securityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");
        return new Filter[] {characterEncodingFilter};
    }

    //当registerDispatcherServlet完成时自定义registration
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("defaultHtmlEscape", "true");
//        registration.setInitParameter("spring.profiles.active", "default");
    }
}
