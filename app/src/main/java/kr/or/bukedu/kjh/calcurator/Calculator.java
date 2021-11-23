package kr.or.bukedu.kjh.calcurator;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
        put("log", 50);
        put("ln", 50);
        put("exp", 50);
    }};
    // 괄호 처리를 중위 계산식으로 처리하면 너무 어렵기 때문에 후위로 바꿔서 해보자.

    public String mathCalc(String str){
        ArrayList<String> opText = new ArrayList<>();
        Stack<String> opStack = new Stack<>();
        String test = "";

        String tempNumber="";
        for(int i = 0; i<str.length(); i++){
            Iterator<String> opList = operator.keySet().iterator();
            boolean flag = true;
            while(opList.hasNext()){
                String op = opList.next();
                if(op.equals(String.valueOf(str.charAt(i)))){
                    if(op.equals(")")){
                        // 괄호 닫히면 지금까지 나온 연산자 Text에 추가함
                        for(int j = 0; j<opStack.size(); j++){
                            if (j != 0) {
                                if (opStack.peek().equals("(")) {
                                    j = opStack.size();
                                }
                                else {
                                    opText.add(opStack.peek());
                                }
                            }
                            opStack.pop();
                        }
                    }
                    else{
                        opStack.push(String.valueOf(str.charAt(i)));
                        tempNumber = tempNumber.replace(op, "");
                        opText.add(tempNumber);
                        tempNumber="";
                        flag =false;
                    }
                }
                else if(flag==true){
                    tempNumber+=String.valueOf(str.charAt(i));
                    flag =false;
                }
            }
            flag = true;

            if(i==str.length()-1){
                if(tempNumber.equals("")!=true){
                    opText.add(tempNumber);
                }
                for(int j = 0; j<opStack.size(); j++){
                    opText.add(opStack.peek());
                }
            }
        }
        for(int i =0; i<opText.size(); i++){
            test += opText.get(i);
            test += "@";
            System.out.println(opText.get(i));
        }
        System.out.println(test);
        System.out.println(opText.size());

        String data = str+"=#";
        String result = "0";

        String sum = data + result;
        return sum;
    }
}
