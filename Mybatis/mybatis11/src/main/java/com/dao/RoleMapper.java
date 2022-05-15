package com.dao;

import com.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lqw
 * @date 2021/10/10-9:28 ����
 */
public interface RoleMapper {

    //��ȡ��ɫ�б�
    public List<Role> getRoleList()throws Exception;

    //���ӽ�ɫ��Ϣ
    public int add(Role role)throws Exception;

    //ͨ��Idɾ��Role
    public int deleteRoleById(@Param("id") String Id)throws Exception;

    //�޸Ľ�ɫ��Ϣ
    public int modify(Role role)throws Exception;

    //ͨ��Id��ȡrole
    public Role getRoleById(@Param("id") Integer id)throws Exception;

    //����roleCode�����н�ɫ�����Ψһ����֤(ͳ��count)
    public int roleCodeIsExist(@Param("roleCode") String roleCode)throws Exception;


}
