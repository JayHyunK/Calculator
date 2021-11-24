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
        // 10 == + , -
        // 50 == x , / , % , ^
        // 100 == 단항
        put("+", 10);
        put("-", 10);
        put("×", 50);
        put("÷", 50);
        put("%", 50);
        put("√", 100);
        put("e", 100);
        put("!", 100);
        put("^", 50);
        put("π", 100);
        put("log", 100); // 로그
        put("ln", 100); // ln
        put("(", 50);
        put(")", 50);
       // put("exp", 50);
    }};


    public String mathCalc(String str){
        ArrayList<Object> arr = makeArray(str);
        ArrayList<Object> postfix = makePostfix(arr, operator);
        String test1 = "0";
        for(int i = 0 ; i<arr.size(); i++){
            test1 += arr.get(i);
        }
        System.out.println(test1);

        String test2 = "0";
        for(int i = 0 ; i<postfix.size(); i++){
            test2 += postfix.get(i);
        }
        System.out.println(test2);

       // String result = calculate(postfix);
        String result = "0";
        String data = str+"=#";

        String sum = data + result;
        return sum;
    }

    // 괄호 처리를 중위 계산식으로 처리하면 너무 어렵기 때문에 후위로 바꿔서 해보자.
    public ArrayList<Object> makeArray(String str) {
        ArrayList<Object> arr = new ArrayList<>();
        String num = "";

        for(int i = 0; i < str.length(); i++) {
            Iterator<String> keys = operator.keySet().iterator();
            boolean flag = true;
            while (keys.hasNext()) {
                String key = keys.next();
                if (key.equals(String.valueOf(str.charAt(i)))&&!key.equals(".")) {
                    num = num.replace(key, "");
                    if(!num.equals("")){
                        arr.add(Double.parseDouble(num));
                        num = "";
                    }
                    arr.add(key);
                    flag = false;
                }
                else if (String.valueOf(str.charAt(i)).equals("L")){
                    String s1 = String.valueOf(str.charAt(i+1));
                    if(s1.equals("o")){
                        arr.add("Log");
                        i=i+2;
                    }
                    else if(s1.equals("n")){
                        arr.add("Ln");
                        i=i+1;
                    }
                    flag = false;
                }
            }

            if(flag==true){
                num += str.charAt(i);
            }
        }
        if(num.equals("")!=true){
            arr.add(Double.parseDouble(num));
        }
        return arr;
    }
    public ArrayList<Object> makePostfix(ArrayList<Object> arr, HashMap<String, Integer> op){
        ArrayList<Object> postfix = new ArrayList<>();
        Stack<Object> operator = new Stack<>();

        for(int i = 0; i<arr.size(); i++){
            if(arr.get(i) instanceof Double){
                postfix.add(arr.get(i));
            }
            else if(arr.get(i).equals(")")){
                int size = operator.size();
                String temp = "";
                for(int j = 0; j <size; j++) {
                    if (operator.peek().equals("(") != true) {
                        if (operator.isEmpty()!=true) {
                            if (op.get(operator.peek()) == 10) {
                                temp = operator.peek().toString();
                                operator.pop();
                                if (!operator.isEmpty()) {
                                    if (op.get(operator.peek()) > 10) {
                                        postfix.add(operator.peek());
                                        operator.pop();
                                    } else if (!temp.equals("")) {
                                        postfix.add(temp);
                                        temp = "";
                                    }
                                }
                                else{
                                    operator.push(temp);
                                    temp = "";
                                }
                            } else {
                                postfix.add(operator.peek());
                                operator.pop();
                            }
                        } else {
                            j = size;
                        }
                    }
                }
            }
            else if(arr.get(i).equals("(")){

            }
            else {
//                if(operator.isEmpty()!=true){
//                    if (op.get(arr.get(i)) <= 10) {
//                        if (!operator.peek().equals("+") && !operator.peek().equals("-")) {
//                            postfix.add(operator.peek());
//                            operator.pop();
//                        }
//                    }
//                }
                operator.push(arr.get(i));
            }
        }
        int size = operator.size();
        for(int i = 0; i<size; i++){
            postfix.add(operator.peek());
            operator.pop();
        }
        return postfix;
    }

    public String calculate(ArrayList<Object> postfix){
        double result=0;
        boolean flag = true;

        while(flag==true) {
            flag = false;
            for (int i = 0; i < postfix.size(); i++) {
                if (postfix.get(i) instanceof String) {
                    if (postfix.get(i).equals("+") || postfix.get(i).equals("-") || postfix.get(i).equals("×") || postfix.get(i).equals("÷") || postfix.get(i).equals("^")) {

                        if (i == 0 || i == 1) {

                        } else {
                            double pre = (double) postfix.get(i - 2);
                            double post = (double) postfix.get(i - 1);
                            postfix.set(i, calculateNumber(post, pre, postfix.get(i).toString()));
                            postfix.remove(i - 1);
                            postfix.remove(i - 2);
                        }
                    } else if (postfix.get(i).equals("π") || postfix.get(i).equals("√") || postfix.get(i).equals("e") || postfix.get(i).equals("!") || postfix.get(i).equals("Log") || postfix.get(i).equals("Ln")) {
                        if (i == 0) {

                        } else {
                            if(postfix.size()==1&&postfix.get(i).equals("π")){
                                postfix.set(i, Math.PI);
                            }
                            else if(postfix.size()==1&&postfix.get(i).equals("e")){
                                postfix.set(i, Math.E);
                            }
                            else{
                                double post = (double) postfix.get(i - 1);
                                postfix.set(i, calculateNumber(post, postfix.get(i).toString()));
                                postfix.remove(i - 1);
                            }
                        }
                    }
                }
            }
            if (postfix.size() > 1) {
                flag = true;
                boolean check = true;
                for (int i = 0; i < postfix.size(); i++) {
                    if (postfix.get(i) instanceof String) {
                        check = false;
                        i = postfix.size();
                    }
                }
                if (postfix.get(0) instanceof Double && postfix.get(1) instanceof Double && check == true) {
                    postfix.add("×");
                }
            }
        }
        result = (double) postfix.get(0);
        return String.valueOf(result);
    }
    public Double calculateNumber(double pre, double post, String op){
        double result = 0;
        if(op.equals("+")){
            result = post+pre;
        }else if(op.equals("-")){
            result = post-pre;
        }else if(op.equals("×")){
            result = post*pre;
        }else if(op.equals("÷")){
            result = post/pre;
        }else if(op.equals("%")){
            result = post%pre;
        }else if(op.equals("^")){
            result = Math.pow(post, pre);
        }
        return result;
    }
    public Double calculateNumber(double num, String op){
        double result = 0;
        if(op.equals("√")){
            result = Math.sqrt(num);
        }else if(op.equals("e")){
            result = Math.E*num;
        }else if(op.equals("!")){
            double tp = (num - 0.5) * Math.log(num + 4.5) - (num + 4.5);
            double sr = 1.0
                        + 76.18009173    / (num + 0)   - 86.50532033    / (num + 1)
                        + 24.01409822    / (num + 2)   -  1.231739516   / (num + 3)
                        +  0.00120858003 / (num + 4)   -  0.00000536382 / (num + 5);
            result = Math.exp(tp + Math.log(sr * Math.sqrt(2 * Math.PI)));
        }else if(op.equals("π")){
            result = Math.PI*num;
        }else if(op.equals("Log")){
            result = Math.log(num);
        }else if(op.equals("Ln")){
            result = Math.log10(num)/Math.log10(Math.E);
        }
        return result;
    }
}
