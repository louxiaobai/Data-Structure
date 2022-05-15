package com.leedcode.dayNine;


import java.util.HashMap;
import java.util.Map;

/**
 * @author lqw
 * @date 2022/4/7-11:29 上午
 */
public class _242_IsAnagram {

    /**
     * 使用hash表进行处理:先将s中的字符串全部存储在hash表中，然后在遍历t 如果发现不相同则直接返回false
     * 如果相同且>1则 对其进行减去1，如果为1则直接进行删除操作a
     * 最后判断是否hash是否为零 为零 则返回true 否则返回false
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     *
     * 其他做法:先对字符串按照字符进行排序，然后对其字符串进行比较即可
     *
     * 如果只是消协字母可以 这样: 用哪个c-'a'的值来当数组的值 每出现一次就加1，然后在去遍历另外一个字符串每出现一此就减去1
     *
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {


        //用hashMap 进行处理-先存储s中的全部字符串

        Map<Character,Integer> map=new HashMap<>();

        for (char c : s.toCharArray()) {

            map.put(c, map.getOrDefault(c, 0)+1);

        }

        //遍历t中的字符串
        for (char c : t.toCharArray()) {

            Integer num = map.get(c);

            if (num==null){//如果遍历到不相同的字符则直接返回false

                return false;

            }

            if (num>1){

                map.put(c, num-1);

            }else {

                map.remove(c);

            }


        }

        return map.size()==0;


    }


}