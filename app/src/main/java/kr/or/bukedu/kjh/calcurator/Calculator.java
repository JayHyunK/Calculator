package kr.or.bukedu.kjh.calcurator;

import android.util.Log;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class Calculator {
    // 연산자 우선 순위 설정
    HashMap<String, Integer> operator = new HashMap<String, Integer>(){{
        put("+", 10);
        put("-", 10);
        put("×", 50);
        put("÷", 50);
        put("%", 50);
        put("√", 50);
        put("e", 50);
        put("!", 50);
        put("^", 50);
        put("π", 50);
        put("log", 50); // 로그
        put("ln", 50); // ln
        put("(", 50);
        put(")", 50);
       // put("exp", 50);
    }};


    public String mathCalc(String str){
        ArrayList<String> opText = postfix(str);
        String test = "";

        for(int i = 0; i< opText.size(); i++){
            test+=opText.get(i);
            test+= "|";
        }
        System.out.println("==========================================");
        System.out.println(test);

        String data = str+"=#";
        String result = "0";

        String sum = data + result;
        return sum;
    }

    // 괄호 처리를 중위 계산식으로 처리하면 너무 어렵기 때문에 후위로 바꿔서 해보자.
    public ArrayList<String> postfix(String str) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> arr = new ArrayList<>();
        String num = "";

        for(int i = 0; i < str.length(); i++) {
            Iterator<String> keys = operator.keySet().iterator();
            boolean flag = true;
            while (keys.hasNext()) {
                String key = keys.next();

                if (key.equals(String.valueOf(str.charAt(i)))) {
                    num = num.replace(key, "");
                    arr.add(num);
                    num = "";
                    stack.push(key);
                    flag = false;
                } else if (flag == true) {
                    // 연산
                    if (String.valueOf(str.charAt(i)).equals("L")) {
                        arr.add(num);
                        flag = false;
                        num = "";
                        // Tree
                        if (str.charAt(i + 1) == 'o') {
                            stack.push("Log");
                            i += 2;
                        } else if (str.charAt(i + 1) == 'n') {
                            stack.push("ln");
                            i += 1;
                        }
                    } else {
                        num += str.charAt(i);
                        num = num.replace(key, "");
                        flag = false;
                    }
                }
                if (stack.isEmpty() != true) {
                    if (stack.peek().equals(")")) {
                        stack.pop();
                        for (int j = 0; j < stack.size(); j++) {
                            if (stack.peek().equals("(")) {
                                if (stack.isEmpty()) {
                                    continue;
                                }
                                stack.pop();
                                j = stack.size();
                            } else {
                                if(stack.peek().equals("")!=true){
                                    arr.add(stack.peek());
                                    stack.pop();
                                }
                                if (stack.isEmpty()) {
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(num.equals("")!=true){
            arr.add(num);
        }
        int size = stack.size();
        for(int i = 0; i<size; i++) {
            arr.add(stack.peek());
            if(stack.isEmpty()){
                continue;
            }
            stack.pop();
        }
        System.out.println(arr.size());
        return arr;
    }
}
