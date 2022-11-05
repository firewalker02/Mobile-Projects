package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;
    TextView Q;
    //    TextView S;
    EditText Answer;
    TextView Score;
    TextView QNum;
    TextView Log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
        //question="What is the capital of Canada";
        //answer="Ottawa";
        score = 0;
        qNum = 1;
        ask();


    }

//        private void ask(){
//        String reference = game.qa();
//        this.question = reference.substring(0,reference.indexOf("\n"));
//        this.answer = reference.substring(reference.indexOf("\n") + 1);
//        setText((TextView)findViewById(R.id.question),this.question);
//    }
//
//    public void onDone(View v){
//        if (qNum == 10) finish();
//
//        String answer = getEditString(findViewById(R.id.answer));//this is a stub assign the value you retrieve from the layout file
//        if (answer.equalsIgnoreCase(this.answer)){
//            this.score ++;
//        }
//
//        if(qNum != 10) {
//            String log = getTextString((TextView) findViewById(R.id.log));
//            //compose the log entry and add it here:
//           log += String.format("Q#%d %s\nYour answer: %s\nCorrect answer: %s\n\n", this.qNum, this.question, answer, this.answer);
//            setText((TextView)findViewById(R.id.log),log);
//            //
//            setText((TextView) findViewById(R.id.score), String.format("Score = %d",this.score));
//            setText((TextView) findViewById(R.id.qNum), String.format("Q#%d", ++this.qNum));
//        }
//
//
//        if (qNum == 10){
//            setText((TextView)findViewById(R.id.qNum),"Game over!");
//        }else {
//            ask();
//            setText(findViewById(R.id.answer), "");
//        }
//
//    }


    private String getEditString(EditText E) {
        return E.getText().toString();
    }

    private String getTextString(TextView T) {
        return T.getText().toString();
    }

    private void setText(TextView T, String V) {
        T.setText(V);
    }

    private void setText1(EditText T, String V) {
        T.setText(V);
    }




///*

    private void ask() {
        String activityGame = game.qa();
     this.question = activityGame.substring(0,activityGame.indexOf("\n"));
       this.answer = activityGame.substring(activityGame.indexOf("\n") + 1);
        Q = (TextView) findViewById(R.id.question);
        setText(Q, this.question);


    }



    public void onDone(View V) {



        Answer=(EditText) findViewById(R.id.answer);
        String userAnswer=getEditString(Answer);
        QNum = (TextView) findViewById(R.id.qNum);
        String Over = "Game over!";

        if (this.answer.equalsIgnoreCase(userAnswer)) {
            this.score++;
        }
      if (qNum != 10) {




          String h = String.format("Q#%s: ", this.qNum);
          Log = (TextView) findViewById(R.id.log);
          String log = getTextString(Log);
          StringBuilder p = new StringBuilder();

          p.append(log).append(h).append(this.question).append("\n");


          p.append(String.format("Your answer: %s ", userAnswer)).append("\n");

          p.append(String.format("Correct answer: %s", this.answer)).append("\n\n");


          setText(Log, p.toString());

      }






        if (this.qNum == 10) {
            setText(QNum, Over);
finish();
        }


        String q= String.format("Q#%s", ++this.qNum);
            String r = String.format("SCORE = %s", this.score);

            Score = (TextView) findViewById(R.id.score);
            setText(Score, r);

            setText(QNum, q);

            setText1(Answer, "");
            ask();


  }

//
}


