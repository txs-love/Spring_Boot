package com.example.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.Servlet;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.sql.In;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author txssherry@gmail.com
 * @date 2023/1/26 22:50
 */
@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "class.datasource")
    public DataSource druidData() {
        return new DataSource() {
            @Override
            public Connection getConnection() {
                return null;
            }

            @Override
            public Connection getConnection(String username, String password) {
                return null;
            }

            @Override
            public PrintWriter getLogWriter() {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) {

            }

            @Override
            public void setLoginTimeout(int seconds) {

            }

            @Override
            public int getLoginTimeout() {
                return 0;
            }

            @Override
            public Logger getParentLogger() {
                return null;
            }

            @Override
            public <T> T unwrap(Class<T> iface) {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) {
                return false;
            }
        };
    }

    /**  ????????????  ????????? web.xml;  ServletRegistrationBean
      ??????spring_Boot?????????servlet??????;  ??????web.xml,???????????? ServletRegistrationBean
     */
    public ServletRegistrationBean statView(){
        ServletRegistrationBean Bean =
                new ServletRegistrationBean<>((Servlet) new StatViewServlet(), "/druid/**");
        //???????????????????????????????????????
        HashMap<String,String> hash = new HashMap<>();

        //????????????  loginUsername???loginPassword????????????
        hash.put("loginUsername","admin");
        hash.put("loginPassword","123456");

        hash.put("allow","");       //???????????????
        hash.put("kuangshen","192.168.11.123");    //???????????????

        Bean.setInitParameters(hash); //?????????????????????
        return Bean;
    }

    /**  ????????????  ????????? web.xml;  FilterRegistration
     ??????spring_Boot?????????servlet??????;  ??????web.xml,???????????? FilterRegistration
     */
    public FilterRegistration webFile(){
        FilterRegistrationBean bean = new FilterRegistrationBean<>();
        bean.setFilter((Filter) new WebStatFilter());
        //?????????????????????
        Map<String,String> InitHash = new HashMap<>();
        InitHash.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(InitHash);
        return (FilterRegistration) bean;
    }

}
