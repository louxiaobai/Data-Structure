package com.config;

import com.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lqw
 * @date 2021/10/25-8:34 ����
 */

//���Ҳ��Spring�����й�,ע�ᵽ������,��Ϊ���������һ��@Component
//@Configuration��������һ��������,�ͺ�����֮ǰ����beans.xmlһ��
@Configuration
@Import(Config2.class)
public class Config {

    //ע��һ��bean,���൱������֮ǰд��һ��bean��ǩ
    //�������������,���൱��bean��ǩ�е�id
    //��������ķ���ֵ,���൱��bean�����е�class����
    @Bean
    public User myService() {
        return new User();
    }
}