package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lqw
 * @date 2021/10/10-9:29 ����
 */
public interface UserMapper {
    /**
     * @param
     * @param map
     * @return
     * @throws Exception
     */
    //�������ݿ��Ƿ����ӳɹ�--��ѯ�û�
    List<User> getUser(Map<String,Integer> map) throws Exception;
    /**
     * ͨ��userCode��ȡUser
     *
     * @param userCode
     * @return
     * @throws Exception
     */
    //ͨ��userCode��ȡUser
    public User getLoginUser(@Param("userCode") String userCode) throws Exception;
    /**
     * �����û���Ϣ
     * insert into
     * @param user
     * @return
     * @throws Exception
     */
    //�����û���Ϣ
    public int add(User user) throws Exception;
    /**
     * ͨ��������ѯuserList,limit��ҳ
     *
     * @param userName
     * @param userRole
     * @return
     * @throws Exception
     */
    //ͨ��������ѯuserList,limit��ҳ
    public List<User> getUserList(@Param("userName") String userName,
                                  @Param("userRole") Integer userRole,
                                  @Param("currentPageNO") Integer currentPageNO,
                                  @Param("pageSize") Integer pageSize)throws Exception;

    /**
     *ͨ��������ѯ-�û���¼��
     * @param userName
     * @param userRole
     * @return
     * @throws Exception
     */
    //ͨ��������ѯ-�û���¼��
    public int getUserCount(@Param("userName") String userName,
                            @Param("userRole") Integer userRole)throws Exception;

    /**
     * ͨ��userIdɾ��user
     * delect from
     * @param id
     * @return
     */
    //ͨ��userIdɾ��user
    public int deleteUserById(@Param("id") Integer id);
    /**
     * ͨ��useId��ȡuser
     * select from
     * @param id
     * @return
     */
    //ͨ��useId��ȡuser
    public User getUserById(@Param("id") Integer id);

    /**
     * �޸��û���Ϣ
     * update set
     * @param user
     * @return
     */
    //�޸��û���Ϣ
    public int modify(User user);

    /**
     * update set
     * @param id
     * @param userPassword
     * @return
     */
    //�޸ĵ�ǰ�û�����
    public int updatePwd(@Param("id") Integer id, @Param("userPassword") String userPassword);
}

