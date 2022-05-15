package com.config;



import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/1/3-3:15 下午
 */
public class MyLocalResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        //获取请求中的语言参数

        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            //国家，地区
            locale= new Locale(split[0],split[1]);
        }


        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}