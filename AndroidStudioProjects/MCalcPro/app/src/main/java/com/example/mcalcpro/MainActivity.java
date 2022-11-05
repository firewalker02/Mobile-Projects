package com.example.mcalcpro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import ca.roumani.i2c.MPro;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, SensorEventListener {
    private TextToSpeech tts;

    private StringBuilder viewBox;
    private boolean didShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.tts = new TextToSpeech(this, this);
        this.didShake = false;
        this.viewBox = new StringBuilder();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    public void onSensorChanged(SensorEvent event) {
        double ax = event.values[0];
        double ay = event.values[1];
        double az = event.values[2];
        double a = Math.sqrt(ax * ax + ay * ay + az * az);

        if (a > 20) {
            ((EditText) findViewById(R.id.pBox)).setText("");
            ((EditText) findViewById(R.id.aBox)).setText("");
            ((EditText) findViewById(R.id.iBox)).setText("");
            ((TextView) findViewById(R.id.output)).setText("");
            didShake = true;
            tts.stop();
        }
    }

    public void pay(View v) {
        viewBox = new StringBuilder();
        MPro mp = new MPro();
        int[] yearBankList = {0, 1, 2, 3, 4, 5, 10, 15, 20};

        String principle = getString(findViewById(R.id.pBox));
        String amortization = getString(findViewById(R.id.aBox));
        String interest = getString(findViewById(R.id.iBox));

        try {
            mp.setPrinciple(principle);
            mp.setAmortization(amortization);
            mp.setInterest(interest);

            int amortizationInteger = Integer.parseInt(amortization);
            viewBox.append(String.format("Monthly payment: %s", mp.computePayment("$%,.2f"))).append("\n\n\n");
         String s="Balance";
         String q="n";

            viewBox.append(String.format("By making these payments monthly for %d years, the mortgage will be paid in full. But if you terminate the mortgage on its nth anniversary, the balance still owing depends on n as shown below: \n\n", amortizationInteger));
            viewBox.append(String.format("%6s %10s",q,s)).append("\n\n\n");

            int j=0;
            for ( j=0;j<yearBankList.length-3; j++ ) {
                viewBox.append(String.format("%4s %d: %10s"," ", yearBankList[j], mp.outstandingAfter(yearBankList[j], "$%,.0f"))).append("\n\n\n");
            }
            int i=j;
            for(i=j;i<yearBankList.length-1;i++){
                viewBox.append(String.format("%3s %d: %10s"," ", yearBankList[i], mp.outstandingAfter(yearBankList[i], "$%,.0f"))).append("\n\n\n");
            }
            viewBox.append(String.format("%3s %d: %6s"," ", yearBankList[i], mp.outstandingAfter(yearBankList[i], "$%,.0f"))).append("\n\n\n");


            setText(findViewById(R.id.output), viewBox.toString());
            tts.speak(viewBox.toString(), TextToSpeech.QUEUE_FLUSH, null);
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private String getString(EditText id) {
        return id.getText().toString();
    }

    private void setText(TextView id, String str) {
        id.setText(str);
    }

    public void onInit(int initStatus) {
        this.tts.setLanguage(Locale.US);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("output" +"", viewBox.toString());
        outState.putBoolean("state", didShake);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (!Boolean.parseBoolean(savedInstanceState.get("state").toString())) {
            viewBox.append(savedInstanceState.get("output"));
        } else {
            viewBox.append("");
        }
        setText(findViewById(R.id.output), viewBox.toString());
    }
}
//public class MainActivity extends AppCompatActivity {
//EditText principle,amortization,interest;
//TextView output;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//    public void pay(View v){
//principle=(EditText) findViewById(R.id.pBox);
//amortization=(EditText) findViewById(R.id.aBox);
//interest=(EditText) findViewById(R.id.iBox);
//String p=principle.getText().toString();
//String a=amortization.getText().toString();
//String i=interest.getText().toString();
//MPro mp=new MPro();
//mp.setPrinciple(p);
//mp.setAmortization(a);
//mp.setInterest(i);
//String s = "Monthly Payment = " + mp.computePayment("%,.2f");
//s += "\n\n";
//s += "By making this payments monthly for 20 years, the mortgage will be paid in full.But if you terminate the mortgage on its nth anniversary,the balance still owing depends on n as shown below";
//
//
//
//    }
//}












// Perfect activity xml
/*<EditText
        android:id="@+id/pBox"
                android:layout_width="0dp"
                android:layout_height="50sp"
                android:hint="Cash Price"

                android:inputType="numberDecimal"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintHorizontal_bias="0.0"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintVertical_bias="0.023" />

<EditText
        android:id="@+id/aBox"
                android:layout_width="0dp"
                android:layout_height="50sp"
                android:hint="Amortization"
                android:inputType="numberDecimal"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintHorizontal_bias="0.0"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintVertical_bias="0.115" />

<EditText
        android:id="@+id/iBox"
                android:layout_width="0dp"
                android:layout_height="50sp"
                android:hint="@string/interest"
                android:inputType="numberDecimal"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintHorizontal_bias="0.0"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintVertical_bias="0.205" />

<Button
        android:id="@+id/ANALYZE"
                android:layout_width="0sp"
                android:layout_height="50sp"
                android:text="@string/analyze"
                android:gravity="center"
                android:onClick="pay"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintHorizontal_bias="0.0"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintVertical_bias="0.279">

</Button>


<ScrollView


        android:id="@+id/output1"
                android:layout_width="404dp"
                android:layout_height="464dp"
                android:layout_marginBottom="16dp"
                android:gravity="center"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintHorizontal_bias="1.0"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintVertical_bias="1.0">

<TextView
            android:id="@+id/output"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/interest"
                    app:layout_constraintBottom_toBottomOf="parent"
                    app:layout_constraintHorizontal_bias="0.0"
                    app:layout_constraintLeft_toLeftOf="parent"
                    app:layout_constraintRight_toRightOf="parent"
                    app:layout_constraintTop_toTopOf="parent"
                    app:layout_constraintVertical_bias="0.205"

                    />

</ScrollView>

 */
