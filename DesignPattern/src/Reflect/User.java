package Reflect;

/**
 * @author lqw
 * @date 2022/3/23-9:20 上午
 */
public class User {


    // Field
    public int no;

    private String name;

    // Constructor
    public User(){

    }
    public User(int no){
        this.no = no;
    }

    // Method
    public void setNo(int no){
        this.no = no;
    }
    public int getNo(){
        return no;
    }



}
