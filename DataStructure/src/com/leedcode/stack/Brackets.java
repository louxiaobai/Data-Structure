package com.leedcode.stack;

import java.util.Stack;

/**
 * @author lqw
 * @date 2021/9/19-3:47 下午
 */
public class Brackets {

    public static void main(String[] args) {

        //定义一个字符串

        String str="(()){}[]";

        if (isRight(str)){

            System.out.println("有效！");

        }else{

            System.out.println("无效！");

        }

    }


    public  static  boolean isRight(String str){


        Stack<Character> stack=new Stack<Character>();//创建一个辅助栈

        for (char c:str.toCharArray()) {

              if (c=='('||c=='{'||c=='['){


                  stack.push(c);

              }else{


                  if (stack.isEmpty()){

                      return false;
                  }

                  char topElement=stack.pop();
                  char mached='#';

                  if (c==')'){

                      mached='(';

                  }
                  if (c=='}'){

                      mached='{';
                  }

                  if (c==']'){

                      mached='[';
                  }

                  if (topElement!=mached){

                      return false;
                  }

              }

        }

        return stack.isEmpty();

    }



}