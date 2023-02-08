package com.example.p4calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button one, two, three, four, five, six, seven, eight,nine,zero;
    Button plus, minus, multiply,divide, point, clear, equal;
    EditText result;
    String operatorPressed = " ";

    private double evaluateExpression(String res, String operatorPressed)
    {
        String[] tokens = res.split("\\+|-|\\*|\\/"); 
        double firstOperand = Double.parseDouble(tokens[0]); 
        double secondOperand = Double.parseDouble(tokens[1]);
        switch(operatorPressed) 
        {
            case "+": return firstOperand + secondOperand;
            case "-": return firstOperand - secondOperand;
            case "*": return firstOperand * secondOperand;
            case "/": return firstOperand / secondOperand;
            default: return 0;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // keeps track of the operator pressed
        result = findViewById(R.id.result); //EditText
        one = findViewById(R.id.one) ;
        two = findViewById(R.id.two) ;
        three = findViewById(R.id.three) ;
        four = findViewById(R.id.four) ;
        five = findViewById(R.id.five) ;
        six = findViewById(R.id.six) ;
        seven = findViewById(R.id.seven) ;
        eight = findViewById(R.id.eight) ;
        nine = findViewById(R.id.nine) ;
        zero = findViewById(R.id.zero) ;
        plus = findViewById(R.id.plus) ;
        minus = findViewById(R.id.minus) ;
        multiply = findViewById(R.id.multiply) ;
        divide = findViewById(R.id.divide) ;
        equal = findViewById(R.id.equal) ;
        point = findViewById(R.id.point) ;
        clear= findViewById(R.id.clear) ;
        
        // Buttons
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
// operators
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {


        double finalResult = 0.0;
        switch(view.getId())
        {
            case R.id.one: result.append("1");
                break;
            case R.id.two: result.append("2");
                break;
            case R.id.three: result.append("3");
                break;
            case R.id.four: result.append("4");
                break;
            case R.id.five: result.append("5");
                break;
            case R.id.six: result.append("6");
                break;
            case R.id.seven: result.append("7");
                break;
            case R.id.eight: result.append("8");
                break;
            case R.id.nine: result.append("9");
                break;

// case for rest of the button 3-9 here
            case R.id.plus: result.append("+");
                operatorPressed="+";
                break;
            case R.id.minus: result.append("-");
                operatorPressed="-";
                break;
            case R.id.multiply: result.append("*");
                operatorPressed="*";
                break;
            case R.id.divide: result.append("/");
                operatorPressed="/"; 
                break;
            case R.id.equal: finalResult=
                    evaluateExpression(result.getText().toString(),operatorPressed);
                result.setText(String.valueOf(finalResult));
                break;
            case R.id.clear: result.setText("");
            default:return;
        }


    }

}
