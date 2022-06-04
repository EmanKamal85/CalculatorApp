package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnAC , btnDel, btndiv, btnMulti, btn7, btn8, btn9, btnSub, btn4, btn5, btn6, btnPlus,
           btn1, btn2, btn3, btnEqual, btnDot, btnZero;

    TextView historyTextView, resultTextview;
    String number = null;
    double firstNumber = 0;
    double secondNumber = 0;
    String status = null;
    //boolean operator = false;
    String history = null;
    DecimalFormat formatter = new DecimalFormat("######.######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAC = findViewById(R.id.button_AC);
        btnDel = findViewById(R.id.button_del);
        btndiv = findViewById(R.id.button_div);
        btnMulti = findViewById(R.id.button_multi);
        btn7 = findViewById(R.id.button_seven);
        btn8 = findViewById(R.id.button_eight);
        btn9 = findViewById(R.id.button_nine);
        btnSub = findViewById(R.id.button_minus);
        btn4 = findViewById(R.id.button_four);
        btn5 = findViewById(R.id.button_five);
        btn6 = findViewById(R.id.button_six);
        btnPlus = findViewById(R.id.button_plus);
        btn1 = findViewById(R.id.button_one);
        btn2 = findViewById(R.id.button_two);
        btn3 = findViewById(R.id.button_three);
        btnEqual = findViewById(R.id.button_equals);
        btnDot = findViewById(R.id.button_dot);
        btnZero = findViewById(R.id.button_zero);

        historyTextView = findViewById(R.id.history_textview);
        resultTextview = findViewById(R.id.result_textview);



        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("7");
                historyDisplay("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("8");
                historyDisplay("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("9");
                historyDisplay("9");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("4");
                historyDisplay("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("5");
                historyDisplay("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("6");
                historyDisplay("6");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("1");
                historyDisplay("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("2");
                historyDisplay("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("3");
                historyDisplay("3");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton("0");
                historyDisplay("0");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton(".");
                historyDisplay(".");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyDisplay("+");
                //if (operator) {
                    if (status == "subtract") {
                        minus();
                    } else if (status == "multiply") {
                        multiply();
                    } else if (status == "divide") {
                        divide();
                    } else {
                        plus();
                    }
                //}
            status = "sum";
            number = null;
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyDisplay("-");
                //if (operator) {
                    if (status == "sum") {
                        plus();
                    } else if (status == "multiply") {
                        multiply();
                    } else if (status == "divide") {
                        divide();
                    } else {
                        minus();
                    }
                //}
                status = "subtract";
                number = null;
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyDisplay("*");
                //if(operator) {
                    if (status == "subtract") {
                        minus();
                    } else if (status == "sum") {
                        plus();
                    } else if (status == "divide") {
                        divide();
                    } else {
                        multiply();
                    }
                //}
                status = "multiply";
                number = null;
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyDisplay("/");
                //if(operator) {
                    if (status == "subtract") {
                        minus();
                    } else if (status == "multiply") {
                        multiply();
                    } else if (status == "sum") {
                        plus();
                    } else {
                        divide();
                    }
                //}
                status = "divide";
                number = null;
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyDisplay(" ");
                //if(operator) {
                //operator = true;
                if (status == "subtract") {
                    minus();
                } else if (status == "multiply") {
                    multiply();
                } else if (status == "sum") {
                    plus();
                } else if (status == "divide"){
                    divide();
                }else{
                    firstNumber = Double.parseDouble(resultTextview.getText().toString());
                }
                //}
                //status = "divide";
                //operator = false;
                number = null;
                //clickButton(""+firstNumber);

            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = null;
                status = null;
                history = null;
                clickButton("0");
                firstNumber = 0;
                secondNumber = 0;
                historyDisplay(history);

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number!= null) {
                    number = number.substring(0, number.length() - 1);
                    resultTextview.setText(number);
                    historyDisplay(history);
                }else {
                    clickButton("0");
                    historyTextView.setText(" ");
                }
            }
        });


    }


    public void clickButton(String view){
        if(number == null){
            number = view;
        }else {
            number = number + view;
        }

        resultTextview.setText(number);
        //operator = true;
    }

    public void plus(){
      secondNumber = Double.parseDouble(resultTextview.getText().toString());
      firstNumber = firstNumber + secondNumber;
      resultTextview.setText(formatter.format(firstNumber));
    }

    public void minus(){
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(resultTextview.getText().toString());
        }else {
            secondNumber = Double.parseDouble(resultTextview.getText().toString());
            firstNumber = firstNumber - secondNumber;
        }
        resultTextview.setText(formatter.format(firstNumber));
    }

    public void multiply(){
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(resultTextview.getText().toString());
        }else {
            secondNumber = Double.parseDouble(resultTextview.getText().toString());
            firstNumber = firstNumber *  secondNumber;
        }
        resultTextview.setText(formatter.format(firstNumber));
    }

    public void divide(){
        if (firstNumber==0){
            firstNumber = Double.parseDouble(resultTextview.getText().toString());
        }else {
            secondNumber = Double.parseDouble(resultTextview.getText().toString());
            firstNumber = firstNumber /  secondNumber;
        }
        resultTextview.setText(formatter.format(firstNumber));
    }

    public void historyDisplay(String historyInput){
        if (history == null) {
            history = historyInput;
        }else {
            history += historyInput;
        }
            historyTextView.setText(history);
    }
}