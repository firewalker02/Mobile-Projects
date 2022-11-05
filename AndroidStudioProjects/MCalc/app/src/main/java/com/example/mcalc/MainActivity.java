package com.example.mcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //EditText principle, amortization, interest;
    //TextView text1, text2, text3;
    Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        principle = (EditText) findViewById(R.id.button0);
//        amortization = (EditText) findViewById(R.id.button1);
//        interest = (EditText) findViewById(R.id.text2);
////        text1 = (TextView) findViewById(R.id.text0);
////        text2 = (TextView) findViewById(R.id.textView);
////        text3 = (TextView) findViewById(R.id.textView1);
        //text4 = (TextView) findViewById(R.id.textView3);
        // payment = (Button) findViewById(R.id.button);
        // Attaching OnClick listener to the submit button
//        payment.setOnClickListener(new View.OnClickListener() {
//
//
//            }
        //  });

    }
    public void pay(View v) {
        EditText  principle = (EditText) findViewById(R.id.button0);
        EditText   amortization = (EditText) findViewById(R.id.button1);
        EditText interest = (EditText) findViewById(R.id.text2);

        String l=principle.getText().toString();
        String m=amortization.getText().toString();
        String n=interest.getText().toString();
        MortgageModel model=new MortgageModel(l,m,n);
        String q=model.computePayment();
        ((TextView) findViewById(R.id.textView3)).setText(q);


    }
}
//<color name="purple_200">#FFBB86FC</color>colors.xml
//<color name="purple_500">#FF6200EE</color>
//<color name="purple_700">#FF3700B3</color>
//<color name="teal_200">#FF03DAC5</color>
//<color name="teal_700">#FF018786</color>
//<color name="black">#FF000000</color>
//<color name="white">#FFFFFFFF</color>  android:theme="@style/Theme.MCalc"