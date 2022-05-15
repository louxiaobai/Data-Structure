package com.practical.leedcode;

/**
 * @author lqw
 * @date 2022/3/1-9:32 上午
 */
public class Player {

    private Integer score;
    private Integer id;


    public Player(Integer score, Integer id) {
        this.score = score;
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", id=" + id +
                '}';
    }
}