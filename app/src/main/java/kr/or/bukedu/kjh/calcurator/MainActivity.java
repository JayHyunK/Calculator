package kr.or.bukedu.kjh.calcurator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    // 쉐어드 프리페어런스 , 인텐트

    String str = "";
    Calculator calc = new Calculator();
    // 식별할 수 있는 키를 괄호 생성시 넣어야함
    // 분수 값 또한 식별 키를 넣어서 계산하는게 데이터 정의에 편함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test 데이터
        ArrayList<String> list = new ArrayList<>();

        RVCalcListAdapter adapter = new RVCalcListAdapter(list);
        RecyclerView calcList = findViewById(R.id.calcList);

        calcList.setLayoutManager(new LinearLayoutManager(this));
        calcList.setAdapter(adapter);

        EditText calcEdit = findViewById(R.id.caclEdit);
        calcEdit.setTextIsSelectable(true);
        calcEdit.setShowSoftInputOnFocus(false);

        Button nSquare = findViewById(R.id.nSquare);
        Button pi = findViewById(R.id.pi);
        Button e = findViewById(R.id.e);
        Button clear = findViewById(R.id.clear);
        Button backSpace = findViewById(R.id.backSpace);
        Button square = findViewById(R.id.square);
        Button mod = findViewById(R.id.modular);
        Button roots = findViewById(R.id.roots);
        Button rightBlock= findViewById(R.id.rightBlock);
        Button leftBlock = findViewById(R.id.leftBlock);
        Button factorial = findViewById(R.id.factorial);
        Button division = findViewById(R.id.division);
        Button multiply = findViewById(R.id.multiply);
        Button minus = findViewById(R.id.minus);
        Button plus = findViewById(R.id.plus);
        Button equal = findViewById(R.id.equal);
        Button point = findViewById(R.id.point);
        Button ans = findViewById(R.id.ans);
        Button log = findViewById(R.id.log);
        Button ln = findViewById(R.id.ln);
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

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("1");
                }
                else{
                    str+="1";
                    editTextReplace(calcEdit, "1");
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("2");
                }
                else{
                    str+="2";
                    editTextReplace(calcEdit, "2");
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("3");
                }
                else{
                    str+="3";
                    editTextReplace(calcEdit, "3");
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("4");
                }
                else{
                    str+="4";
                    editTextReplace(calcEdit, "4");
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("5");
                }
                else{
                    str+="5";
                    editTextReplace(calcEdit, "5");
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("6");
                }
                else{
                    str+="6";
                    editTextReplace(calcEdit, "6");
                }
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("7");
                }
                else{
                    str+="7";
                    editTextReplace(calcEdit, "7");
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("8");
                }
                else{
                    str+="8";
                    editTextReplace(calcEdit, "8");
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("9");
                }
                else{
                    str+="9";
                    editTextReplace(calcEdit, "9");
                }
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("0");
                }
                else{
                    str+="0";
                    editTextReplace(calcEdit, "0");
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("+");
                }
                else{
                    str+="+";
                    editTextReplace(calcEdit, "+");
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("-");
                }
                else{
                    str+="-";
                    editTextReplace(calcEdit, "-");
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("×");
                }
                else{
                    str+="×";
                    editTextReplace(calcEdit, "×");
                }
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("÷");
                }
                else{
                    str+="÷";
                    editTextReplace(calcEdit, "÷");
                }
            }
        });
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("!");
                }
                else{
                    str+="!";
                    editTextReplace(calcEdit, "!");
                }
            }
        });
        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextBack(calcEdit);
            }
        });
        leftBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("(");
                }
                else{
                    str+="(";
                    editTextReplace(calcEdit, "(");
                }
            }
        });
        rightBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText(")");
                }
                else{
                    str+=")";
                    editTextReplace(calcEdit, ")");
                }
            }
        });
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = list.get(list.size()-1);
                String[] value = str1.split("#");
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText(value[1]);
                }else {
                    editTextReplace(calcEdit, value[1]);
                }
            }
        });
        roots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("√");
                }
                else{
                    str="√";
                    editTextReplace(calcEdit, "√");
                }
            }
        });
        nSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("^2");
                }
                else{
                    str="^2";
                    editTextReplace(calcEdit, "^2");
                }
            }
        });
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("π");
                }
                else{
                    str="π";
                    editTextReplace(calcEdit, "π");
                }
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("e");
                }
                else{
                    str="e";
                    editTextReplace(calcEdit, "e");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = "";
                calcEdit.setText("");
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("^");
                }
                else{
                    str="^";
                    editTextReplace(calcEdit, "^");
                }
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("%");
                }
                else{
                    str="%";
                    editTextReplace(calcEdit, "%");
                }
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText(".");
                }
                else{
                    str=".";
                    editTextReplace(calcEdit, ".");
                }
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("Log(");
                }
                else{
                    str="Log(";
                    editTextReplace(calcEdit, "Log(");
                }
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcEdit.getText().toString().length()==1&&calcEdit.getText().toString().equals("0")){
                    calcEdit.setText("Ln(");
                }
                else{
                    str="Ln(";
                    editTextReplace(calcEdit, "Ln(");
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String calcdata = calcEdit.getText().toString();
                list.add(calc.mathCalc(calcdata));
                str = "0";
                calcEdit.setText(str);

                RVCalcListAdapter adapter = new RVCalcListAdapter(list);
                RecyclerView calcList = findViewById(R.id.calcList);

                calcList.setAdapter(adapter);
            }
        });
    }
    public void editTextReplace(EditText view, String word){
        // Math.max 는 에초에 커서가 잡혀있지않을때를 대비해서 넣음.
        int s = Math.max(view.getSelectionStart(), 0);
        int e = Math.max(view.getSelectionEnd(), 0);
        if(view.getText().equals("0")!=true&&view.getText().length()==1){
            s = 1;
            e = 1;
        }
        // 역으로 선택된 경우 s가 e보다 클 수 있다 때문에 이렇게 Math.min Math.max를 쓴다.
        view.getText().replace(Math.min(s, e), Math.max(s, e), word, 0, word.length());
        view.setSelection(view.getText().length());
    }
    public void editTextBack(EditText view){
        int s = Math.max(view.getSelectionStart(), 0);
        int e = Math.max(view.getSelectionEnd(), 0);
        int st = s - 1;
        int ed = e - 0;

        try{
            if(view.getText().toString().length()==1){
                view.setText("0");
            }
            else{
                view.getText().delete(Math.min(st, ed), Math.max(st, ed));
            }
        }
        catch(Exception ee){
            s = Math.max(view.getSelectionStart(), view.getText().length());
            e = Math.max(view.getSelectionEnd(), view.getText().length());
            st = s - 1;
            ed = e - 0;
            if(view.getText().toString().length()==1){
                view.setText("0");
            }
            else{
                view.getText().delete(Math.min(st, ed), Math.max(st, ed));
            }
        }
    }
}