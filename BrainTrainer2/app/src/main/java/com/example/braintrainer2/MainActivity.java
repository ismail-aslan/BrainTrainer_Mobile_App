package com.example.braintrainer2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button playButton;
    ConstraintLayout gameScreen;
    LinearLayout range;
    Button playAgainButton;
    Random random = new Random();
    TextView questionTextView;
    TextView timerTextView;
    TextView resultTextView;
    Boolean isActive;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView scoreTextView;
    int score = 0;
    int counter = 0;
    int locationOfCorrectAnswer;
    EditText timerEditText,num1,num2;
    int time;
    RadioGroup process;
    int selectedProcessId;
    RadioButton addition,extraction,multiplication;
    int res;

    public void play(View view){
        if (timerEditText.getText().toString().isEmpty()){
            time = 30;
        }else{
            time = Integer.valueOf(timerEditText.getText().toString());
        }

        timerEditText.setVisibility(View.INVISIBLE);
        range.setVisibility(View.INVISIBLE);
        playButton.setVisibility(View.INVISIBLE);
        gameScreen.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        process.setVisibility(View.INVISIBLE);
        resultTextView.setText("");
        scoreTextView.setText("0/0");
        timerTextView.setText("30s");
        score = 0;
        counter = 0;
        isActive = true;
        button0.setClickable(true);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);

        newQuestion();

        new CountDownTimer((time * 1000 + 100), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(Integer.toString((int) (millisUntilFinished / 1000)) +"s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
                playAgainButton.setVisibility(View.VISIBLE);
                isActive = false;
                button0.setClickable(false);
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
            }
        }.start();

    }
    public void setPlayAgainButton(View view){
        timerEditText.setVisibility(View.VISIBLE);
        playButton.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        gameScreen.setVisibility(View.INVISIBLE);
        range.setVisibility(View.VISIBLE);
        process.setVisibility(View.VISIBLE);
    }
    public void game(View view){
        int tag =  Integer.valueOf((String) view.getTag());

        if(tag == locationOfCorrectAnswer){
            resultTextView.setText("Correct!");
            score++;
        }else{
            resultTextView.setText("Wrong :(");
        }
        counter++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(counter));
        if (isActive){

            newQuestion();
        }


    }
    public void newQuestion(){
        int a,b;
        selectedProcessId = process.getCheckedRadioButtonId();
        a = random.nextInt(Integer.valueOf(num1.getText().toString())+1);
        b = random.nextInt(Integer.valueOf(num2.getText().toString())+1);




        switch (selectedProcessId){

            case R.id.addition:
                res = a + b;
                questionTextView.setText(Integer.toString(a) + " + " +Integer.toString(b));
                break;

            case R.id.extraction:
                res = a - b;
                questionTextView.setText(Integer.toString(a) + " - " +Integer.toString(b));
                break;

            case R.id.multiplication:
                res = a * b;
                questionTextView.setText(Integer.toString(a) + " x " +Integer.toString(b));
                break;
        }



        locationOfCorrectAnswer = random.nextInt(4);
        answers.clear();
        for (int i = 0;i < 4; i++){
            if (i == locationOfCorrectAnswer){
                answers.add(res);
            }else {
                int wrongAnswer = random.nextInt(40);
                while (answers.contains(wrongAnswer) || wrongAnswer == res){
                    wrongAnswer = random.nextInt(40);
                }
                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        gameScreen =findViewById(R.id.gameScreen);
        playAgainButton = findViewById(R.id.playAgainButton);
        questionTextView = findViewById(R.id.questionTextView);
        timerTextView = findViewById(R.id.timerTextView);
        resultTextView = findViewById(R.id.resultTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerEditText = findViewById(R.id.timerEditText);
        process = findViewById(R.id.process);
        addition = findViewById(R.id.addition);
        extraction = findViewById(R.id.extraction);
        multiplication = findViewById(R.id.multiplication);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        range = findViewById(R.id.range);




        playButton.setVisibility(View.VISIBLE);
        gameScreen.setVisibility(View.INVISIBLE);
        timerEditText.setVisibility(View.VISIBLE);
        process.setVisibility(View.VISIBLE);
        range.setVisibility(View.VISIBLE);



    }
}