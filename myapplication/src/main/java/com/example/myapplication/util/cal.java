package com.example.myapplication.util;
import java.util.Stack;

public class cal {

    public static Integer Cal( CharSequence st){

        String s= String.valueOf(st);

        Stack<String> nums = new Stack<String>();
        Stack<Character> symbles = new Stack<Character>();
        for (int i=0,j=0;i<s.toCharArray().length;i++){
            if (i==s.toCharArray().length-1){
                nums.push(s.substring(j,i+1));
            }
            if (isNum(s.charAt(i))){

            }
            else {
                nums.push(s.substring(j,i));
                j=i+1;
                symbles.push(s.charAt(i));
            }
        }

        return  result(new Stack[]{nums, symbles}) ;

    }

    public static boolean isNum(char c){
        return !(c=='+' || c=='*' || c=='-' || c=='÷');
    }


    public static Integer result(Stack[]stacks){
        int result;
        String[]nums=new String[stacks[0].size()];
        char[]symbles=new char[stacks[1].size()];
        for (int i=0;i<nums.length;i++){
            nums[i]=(String)(stacks[0].pop());
        }
        for (int i=0;i<symbles.length;i++){
            symbles[i]=(char)(stacks[1].pop());
        }


        stacks[0].push(nums[0]);
        for (int i=1;i<nums.length;i++){


            if (symbles[i-1]=='*'){
                int num1=Int((String) stacks[0].pop());
                int num2=Int((String) nums[i]);
                stacks[0].push(num1*num2);
            }
            if (symbles[i-1]=='÷'){
                int num1=Int(stacks[0].pop());
                int num2=Int((String) nums[i]);
                stacks[0].push(num2/num1);
            }
            else  if (symbles[i-1]=='+'||symbles[i-1]=='-'){
                stacks[0].push(nums[i]);
                stacks[1].push(symbles[i-1]);
            }



        }

        while (!(stacks[0].isEmpty())&&!(stacks[1].isEmpty())){
            char sy=(char)stacks[1].pop();
            if (sy=='+'){
                int num1=Int(stacks[0].pop());
                int num2=Int(stacks[0].pop());

                stacks[0].push(num2+num1);
            }
            if (sy=='-'){
                int num1=Int(stacks[0].pop());
                int num2=Int(stacks[0].pop());

                stacks[0].push(num2-num1);
            }


        }


        return (Integer)Int(stacks[0].pop()) ;

    }

    public static char compare(char a,char b){
        if ((a=='+'||a=='-')&&(b=='+'||b=='-')){
            return '=';
        }
        if ((a=='+'||a=='-')&&(b=='*'||b=='÷')){
            return '>';
        }
        if ((a=='÷'||a=='*')&&(b=='+'||b=='-')){
            return '<';
        }
        if (a=='#'&&b!='#'){
            return '>';
        }


        else throw new RuntimeException();

    }

    public static int Int(Object s){
        if (s.getClass().isInstance("String.class")){
            return Integer.parseInt((String) s);
        }
        else return (int) s;
    }


}
