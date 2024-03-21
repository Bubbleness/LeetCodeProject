package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

/**
 * @author shuiyu
 * @date 2024/03/20
 * @description 输入一个n表示中括号的对数，输出所有满足条件的中括号的组合结果
 */
public class BracketListMain {

    int n;

    List<String> result = new ArrayList<>();

    public void getBracketList(int num) {
        this.n = num;
        dfs("", 0, 0, n);
        System.out.println(JSON.toJSONString(result));
    }

    public void dfs(String bracket, int leftCount, int rightCount, int n) {

        if (bracket.length() == 2*n) {
            result.add(bracket);
            return;
        }

        // "[" 只能放n个
        if (leftCount < n) {
            dfs(bracket+"[", leftCount+1, rightCount, n);
        }

        if (rightCount < leftCount) {
            dfs(bracket+"]", leftCount, rightCount+1, n);
        }
    }

    public static void main(String[] args) {
        //String str = "[[]][]";
        //System.out.println(JSON.toJSONString(validate(str)));

        BracketListMain bracketListMain = new BracketListMain();
        bracketListMain.getBracketList(4);
    }

}
