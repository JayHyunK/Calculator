package kr.or.bukedu.kjh.calcurator;

import java.util.HashMap;

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

    public String mathCalc(String str){
        String data = str+"=#";
        String result = "";

        String sum = data + result;
        return sum;
    }
}
