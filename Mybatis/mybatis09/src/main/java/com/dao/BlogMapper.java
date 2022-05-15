package com.dao;

import com.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author lqw
 * @date 2021/10/9-8:48 ����
 */
public interface BlogMapper {
        //��������
        int addBlog(Blog blog);
        //��ѯ����
        List<Blog> queryBlogIF(Map map);
        //��ѯ����
        List<Blog> queryBlogChoose(Map map);
        //���²���
        int updateBlog(Map map);

        //��ѯ��1-2-3�ż�¼�Ĳ���

        List<Blog> queryBlogForeach(Map map);


}
