package cn.edu.xd.myy.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 *
 * 利用栈来解决这个问题
 * 以“/”分割路径字符串，将非空的字符添加进栈中
 *
 * 当遇见 . continue
 * 当遇见 .. 就弹栈*/

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] str = path.split("/");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("") || str[i].equals(".")) {
                continue;
            } else if (str[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/" + s);

        }
        return sb.toString();

    }

    public static void main(String[] args){
        String path = "/a/./b/../../c/";
        SimplifyPath sp =  new SimplifyPath();
        System.out.println(sp.simplifyPath(path));
    }

}

//    public static  void main(String[] args){
//        String s= "/home//foo";
//        String[] ss = s.split("/");
//        System.out.println(ss.length);
//        for(int i=0;i<ss.length;i++){
//            System.out.println(i+ss[i]);
//        }


