package com.algorithm.stack;

import java.util.Stack;

/**
 * @Author: feipeixuan
 * @Version: 判断入栈和出栈顺序
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class CheckStack {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        //一些必要的合法性检查
        if (pushA == null || popA == null)
            return false;
        else if (pushA.length != popA.length)
            return false;
        else {
            //模拟栈操作
            Stack<Integer> stack = new Stack();
            int index1 = 0, index2 = 0, length = pushA.length;

            while (index1 < length && index2 < length) {
                //如果栈是空的或者 栈顶元素不等于出栈数组
                if (stack.isEmpty() || stack.peek() != popA[index2]) {
                    //入栈，直到相等，说明这是一个出栈点
                    while (index1 < length && pushA[index1] != popA[index2]) {
                        stack.push(pushA[index1++]);//入栈，一会儿再出
                    }
                    if (index1 < length)
                        stack.push(pushA[index1++]);
                } else {

                    //如果栈顶元素等于出栈数组，说明要一直出栈，直到不等为止
                    while (popA[index2] == stack.peek()) {
                        index2++;
                        stack.pop();
                    }
                }
            }

            if (length - index2 != stack.size())
                return false;
            else {
                //出栈
                while (index2 < length && popA[index2] == stack.peek()) {
                    index2++;
                    stack.pop();
                }
                //判断是否都出来了么
                if (stack.size() == 0)
                    return true;
                else
                    return false;
            }

        }
    }
}
