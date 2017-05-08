package com.example.nguyen.androidbasic_lesson2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private EditText etScreen;
    private Button btnNum0;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;
    private Button btnDot;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnClear;
    private Button btnReset;
    private Button btnCalculate;
    private double a,b;
    private int count = 1;
    private char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        getWidget();
    }

    public void pressBtnNum(View v){
        if(count == 0) etScreen.setText("");
        String num = ((Button)v).getText().toString();
        String screen = etScreen.getText().toString();
        if("0".equals(screen)) etScreen.setText(num + "");
        else etScreen.setText(screen + num);
    }

    public void clear(View v){
        etScreen.setText("0");
    }

    public void reset(View v){
        etScreen.setText("");
        a = 0;
        b = 0;
        count = 0;
    }

    public void changePositiveNegative(View v){
        String num = getScreenString();
        System.out.println("======= " + num + " =======");
        if ("".equals(num) || num.charAt(0) !='-' || num.charAt(0) != '0') etScreen.setText("-" + num);
        else if (num.charAt(0) == '-') etScreen.setText(num.substring(1));
    }

    public void pressBtnOperation(View v){
        if (count <= 1) {
            a = getNumber();
            etScreen.setText("0");
            operation = ((Button)v).getText().toString().charAt(0);
            count = 2;
        }
        else calculate(null);
    }

    public void calculate(View v){
        if(!"".equals(getScreenString()) && count == 2) {
            b = getNumber();
            System.out.println("=========="+count+"=========="+a+"=========="+b+"==========");
            switch (operation) {
                case '+':
                    etScreen.setText(a + b + "");
                    break;
                case '-':
                    etScreen.setText(a - b + "");
                    break;
                case 'x':
                    etScreen.setText(a * b + "");
                    break;
                case '/':
                    etScreen.setText(a / b + "");
                    break;
            }
        }
        else {
            etScreen.setText("");
            Toast.makeText(getApplicationContext(),"input incorrect !",Toast.LENGTH_LONG).show();
        }
        a = 0;
        b = 0;
        count = 0;
    }

    private String getScreenString(){
        return etScreen.getText().toString().trim();
    }

    private double getNumber(){
        return Double.parseDouble(getScreenString());
    }

    private void getWidget(){
        etScreen = (EditText) findViewById(R.id.etScreen);
        btnNum0 = (Button) findViewById(R.id.btnNum0);
        btnNum1 = (Button) findViewById(R.id.btnNum1);
        btnNum2 = (Button) findViewById(R.id.btnNum2);
        btnNum3 = (Button) findViewById(R.id.btnNum3);
        btnNum4 = (Button) findViewById(R.id.btnNum4);
        btnNum5 = (Button) findViewById(R.id.btnNum5);
        btnNum6 = (Button) findViewById(R.id.btnNum6);
        btnNum7 = (Button) findViewById(R.id.btnNum7);
        btnNum7 = (Button) findViewById(R.id.btnNum8);
        btnNum9 = (Button) findViewById(R.id.btnNum9);
        btnDiv = (Button) findViewById(R.id.btnDot);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
    }
}
