package com.practical.leedcode;

import java.awt.im.InputMethodHighlight;
import java.util.*;

/**实现 积分排行榜--HashMap实现
 * @author lqw
 * @date 2022/2/28-4:55 下午
 */
public class _1224_LeaderBoard1 {
    private Map<Integer,Player> map;

    private Set<Player> players;
    public _1224_LeaderBoard1(){

        this.map=new HashMap<>();

        //对TreeSet的排序方式进行重写
        this.players=new TreeSet<>((o1, o2) -> o1.getId()==o2.getId()?o1.getScore()-o2.getScore():o2.getScore()-o1.getScore());

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

        if (map.containsKey(id)){//如果之前存在-则进行重置分数

            Player player = map.get(id);

            int temp=player.getScore();

            players.remove(player);
            players.add(new Player(score+temp, id));

        }else{

            Player player = new Player(score, id);

            map.put(id, player);

            players.add(player);

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

        Iterator<Player> it = players.iterator();

        int index=0;
        int sum=0;
        while (it.hasNext()&&index<k){
            sum+=it.next().getScore();
            index++;

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

        if (map.containsKey(id)){

            Player player = map.get(id);
            map.remove(id);
            players.remove(player);

        }

    }





}