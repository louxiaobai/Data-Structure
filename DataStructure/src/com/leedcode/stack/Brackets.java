package com.leedcode.stack;

import java.util.Stack;

/**
 * @author lqw
 * @date 2021/9/19-3:47 ����
 */
public class Brackets {

    public static void main(String[] args) {

        //����һ���ַ���

        String str="(()){}[]";

        if (isRight(str)){

            System.out.println("��Ч��");

        }else{

            System.out.println("��Ч��");

        }

    }


    public  static  boolean isRight(String str){


        Stack<Character> stack=new Stack<Character>();//����һ������ջ

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