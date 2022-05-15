package com.dao;

import com.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lqw
 * @date 2021/10/10-9:24 ����
 */
public interface BillMapper {
    /**
     * ���ݹ�Ӧ��Id��ѯ��������
     * @param providerId
     * @return
     */
    //���ݹ�Ӧ��Id��ѯ��������
    public int getBillCountByProviderId(@Param("providerId") Integer providerId);
    /**
     * //���Ӷ���
     * @param bill
     * @return
     */
    public int add(Bill bill);
    /**
     * ͨ����ѯ������ȡ��Ӧ���б�-getBillList
     * @param productName
     * @param providerId
     * @param isPayment
     * @param startindex
     * @param pageSize
     * @return
     * @throws Exception
     */
    //ͨ����ѯ������ȡ��Ӧ���б�-getBillList
    public List<Bill> getBillList(@Param("productName") String productName,
                                  @Param("providerId") String providerId,
                                  @Param("isPayment") String isPayment,
                                  @Param("startindex") Integer startindex,
                                  @Param("pageSize") Integer pageSize)throws Exception;
    //ͨ��������ѯ����ѯ����������,ģ����ѯ
    public int getBillCount(@Param("productName") String productName,
                            @Param("providerId") String providerId,
                            @Param("isPayment") String isPayment)throws Exception;
    //ͨ��delIdɾ��Bill
    public int deleteBillById(@Param("id") Integer id)throws Exception;
    //ͨ��billId��ȡBill
    public Bill getBillById(@Param("id") Integer id)throws Exception;
    //�޸Ķ�����Ϣ
    public int modify(Bill bill)throws Exception;
    //���ݹ�Ӧ��Idɾ��������Ϣ
    public int deleteBillByProviderId(@Param("providerId") Integer providerId)throws Exception;
}
