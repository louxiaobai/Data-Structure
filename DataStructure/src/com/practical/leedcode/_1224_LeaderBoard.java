package com.practical.leedcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**实现 积分排行榜--HashMap实现---无序的数据结构
 * @author lqw
 * @date 2022/2/28-4:55 下午
 */
public class _1224_LeaderBoard {
    private Map<Integer,Integer> map;
    public _1224_LeaderBoard(){

        this.map=new HashMap<>();

    }
    /**
     * 记录每个参赛者的分数
     * 假如参赛者已经在排行榜上，就给他的当前得分增加 score 点分值并更新排行。
     * 假如该参赛者不在排行榜上，就把他添加到榜单上，并且将分数设置为 score。
     * 时间复杂度O(1)
     * @param id
     * @param score
     */
    public void addScore(int id,int score){



        if (map.containsKey(id)){
            map.put(id, map.get(id)+score);

        }else{

            map.put(id, score);

        }

    }

    /**
     * 返回前k名的分数
     *
     * 时间复杂度O(nlogn)+O(k)
     * 每次都需要对进行排序 有性能瓶颈
     * @param k
     * @return
     */
    public int topK(int k){

        //得到一个分数数组
        Integer[] scores = map.values().toArray(new Integer[map.values().size()]);

        //降序排列,默认为升序排序-改为降序排列
        Arrays.sort(scores, (o1, o2) -> o2-o1);

        int sum=0;
        for (int i = 0; i < k; i++) {

            sum+=scores[i];

        }
        return sum;

    }

    /**
     * 将指定参赛者的成绩清零。题目保证在调用此函数前，该参赛者已有成绩，并且在榜单上。
     * 请注意，在初始状态下，排行榜是空的。
     * 时间复杂度O(1)
     * @param id
     */
    public void reset(int id){
        map.put(id, 0);
    }





}