package com.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @author lqw
 * @date 2021/11/9-12:00 下午
 */
public class jsonUtils {
    
    public static  String getJson(Object object)  {

         return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 指定日期类型
     * @param object
     * @param dateFormat
     * @return
     */
    public static  String getJson(Object object,String dateFormat)  {

        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);

        //自定义时间日期的格式

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        mapper.setDateFormat(sdf);


        try {
            return mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){

            e.printStackTrace();
        }

        return null;

    }



}