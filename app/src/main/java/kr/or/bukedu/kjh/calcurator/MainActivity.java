package kr.or.bukedu.kjh.calcurator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    String str = "";
    Calculator calc = new Calculator();
    //TreeMap<Integer, String> myTree = new TreeMap<>();
    TreeSet<String> myTree = new TreeSet<>();
    ListView calcList = findViewById(R.id.calcList);
    // 식별할 수 있는 키를 괄호 생성시 넣어야함
    // 분수 값 또한 식별 키를 넣어서 계산하는게 데이터 정의에 편함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nSquare = findViewById(R.id.nSquare);
        Button pi = findViewById(R.id.pi);
        Button e = findViewById(R.id.e);
        Button clear = findViewById(R.id.clear);
        Button backSpace = findViewById(R.id.backSpace);
        Button square = findViewById(R.id.square);
        Button raNumber = findViewById(R.id.rationalNumber);
        Button abValue = findViewById(R.id.absoluteValue);
        Button exponent = findViewById(R.id.exponent);
        Button mod = findViewById(R.id.modular);
        Button roots = findViewById(R.id.roots);
        Button rblock = findViewById(R.id.rightBlock);
        Button lblock = findViewById(R.id.leftBlock);
        Button factorial = findViewById(R.id.factorial);
        Button division = findViewById(R.id.division);
        Button multiply = findViewById(R.id.multiply);
        Button minus = findViewById(R.id.minus);
        Button plus = findViewById(R.id.plus);
        Button equal = findViewById(R.id.equal);
        Button point = findViewById(R.id.point);
        Button signb = findViewById(R.id.signb);
        Button xSquareY = findViewById(R.id.xSquareY);
        Button tenX = findViewById(R.id.tenX);
        Button log = findViewById(R.id.log);
        Button in = findViewById(R.id.in);
        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);

        TextView calcArea = findViewById(R.id.calcArea);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "1";
                }
                else {
                    str += "1";
                }
                calcArea.setText(str);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "2";
                }
                else {
                    str += "2";
                }
                calcArea.setText(str);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "3";
                }
                else {
                    str += "3";
                }
                calcArea.setText(str);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "4";
                }
                else {
                    str += "4";
                }
                calcArea.setText(str);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "5";
                }
                else {
                    str += "5";
                }
                calcArea.setText(str);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "6";
                }
                else {
                    str += "6";
                }
                calcArea.setText(str);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "7";
                }
                else {
                    str += "7";
                }
                calcArea.setText(str);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "8";
                }
                else {
                    str += "8";
                }
                calcArea.setText(str);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==1&&str.equals("0")){
                    str = "9";
                }
                else {
                    str += "9";
                }
                calcArea.setText(str);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()==0||str.equals("0")){
                    str = "0";
                }
                else{
                    str += "0";
                }
                calcArea.setText(str);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str += "+";
                calcArea.setText(str);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str += "-";
                calcArea.setText(str);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str += "×";
                calcArea.setText(str);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str += "÷";
                calcArea.setText(str);
            }
        });
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str += "!";
                calcArea.setText(str);
            }
        });
        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()>1){
                    str = str.substring(0, str.length()-1);
                }
                else {
                    str = "0";
                }
                calcArea.setText(str);
            }
        });

        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcArea.setText(calc.calc(calcArea.getText().toString()));
            }
        });

        lblock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="(";
                calcArea.setText(str);
            }
        });
        rblock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+=")";
                calcArea.setText(str);
            }
        });
    }
}