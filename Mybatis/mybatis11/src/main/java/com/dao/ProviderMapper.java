package com.dao;

import com.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lqw
 * @date 2021/10/10-9:26 ����
 */
public interface ProviderMapper {
    /**
     * ���ӹ�Ӧ��
     * @param provider
     * @return
     * @throws Exception
     */
    public int add(Provider provider)throws Exception;


    /**
     * ͨ����Ӧ�����ơ������ȡ��Ӧ���б�-ģ����ѯ-providerList
     * @param proName
     * @return
     * @throws Exception
     */
    public List<Provider> getProviderList(@Param("proName") String proName,
                                          @Param("proCode")String proCode)throws Exception;

    /**
     * ͨ��proIdɾ��Provider
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteProviderById( int id)throws Exception;


    /**
     * ͨ��proId��ȡProvider
     * @param id
     * @return
     * @throws Exception
     */
    public Provider getProviderById(String id)throws Exception;

    /**
     * �޸��û���Ϣ
     * @param
     * @return
     * @throws Exception
     */
    public int modify(Provider provider)throws Exception;


}