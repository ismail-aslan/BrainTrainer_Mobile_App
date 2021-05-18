package com.example.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    Button resetButton;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView timerTextView;
    TextView questionTextView;
    TextView resultsTextView;
    TextView wcTextView;
    Boolean timeIsUp = false;
    CountDownTimer countDownTimer;
    Random r= new Random();
    int sum;
    int counter = 0,achievements = 0;


    public void setGoButton(View view){
        wcTextView.setText("GO!!!");
        counter = 0;
        achievements = 0;
        resetScreen();

        countDownTimer = new CountDownTimer(25100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(Integer.toString((int)millisUntilFinished/1000) +"s");
            }

            @Override
            public void onFinish() {
                wcTextView.setText("Done!");
                timeIsUp = true;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.horn2);
                mediaPlayer.start();
            }
        }.start();
    }



    public void setResetButton(View view){
        countDownTimer.cancel();
        counter = 0;
        achievements = 0;
        mainGame();
        setGame();
    }




    public void setButton1(View view){
        if(timeIsUp == false & button1.getText() == Integer.toString(sum)){

            counter++;
            achievements++;
            mainGame();
            wcTextView.setText("Correct :)");

        }else if (timeIsUp){
            countDownTimer.cancel();
            counter++;
            wcTextView.setText("Done!");

        }else if (button1.getText() != Integer.toString(sum)){
            counter++;
            mainGame();
            wcTextView.setText("Wrong :(");
            resultsTextView.setText(achievements + " / " + counter);
        }
    }
    public void setButton2(View view){
        if(timeIsUp == false & button2.getText() == Integer.toString(sum)){

            counter++;
            achievements++;
            mainGame();
        wcTextView.setText("Correct :)");

        }else if (timeIsUp){
            countDownTimer.cancel();
            counter++;
            wcTextView.setText("Done!");

        }else if (button2.getText() != Integer.toString(sum)){
            counter++;
            mainGame();
            wcTextView.setText("Wrong :(");
            resultsTextView.setText(achievements + " / " + counter);
        }
    }

    public void setButton3(View view){
        if(timeIsUp == false & button3.getText() == Integer.toString(sum)){

            counter++;
            achievements++;
            mainGame();
            wcTextView.setText("Correct :)");

        }else if (timeIsUp){
            countDownTimer.cancel();
            counter++;
            wcTextView.setText("Done!");

        }else if (button3.getText() != Integer.toString(sum)){
            counter++;
            mainGame();
            wcTextView.setText("Wrong :(");
            resultsTextView.setText(achievements + " / " + counter);
        }

    }
    public void setButton4(View view){
        if(timeIsUp == false & button4.getText() == Integer.toString(sum)){

            counter++;
            achievements++;
            mainGame();
            wcTextView.setText("Correct :)");

        }else if (timeIsUp){
            countDownTimer.cancel();
            counter++;
            wcTextView.setText("Done!");

        }else if (button4.getText() != Integer.toString(sum)){
            counter++;
            mainGame();
            wcTextView.setText("Wrong :(");
            resultsTextView.setText(achievements + " / " + counter);
        }

    }
    public void setGame(){

        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        questionTextView.setVisibility(View.INVISIBLE);
        resultsTextView.setVisibility(View.INVISIBLE);
        wcTextView.setVisibility(View.INVISIBLE);
        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);
        resetButton.setClickable(false);

        goButton.setClickable(true);
        goButton.setVisibility(View.VISIBLE);

    }
    public void resetScreen(){

        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        questionTextView.setVisibility(View.VISIBLE);
        resultsTextView.setVisibility(View.VISIBLE);
        wcTextView.setVisibility(View.VISIBLE);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        resetButton.setClickable(true);
        goButton.setClickable(false);
        goButton.setVisibility(View.GONE);
        timeIsUp = false;


    }

    public void mainGame(){

        int num1 = r.nextInt(50) + 1;
        int num2 = r.nextInt(50) + 1;
        sum = num1 + num2;
        int wrong1 = r.nextInt(100) + 1;
        int wrong2 = r.nextInt(100) + 1;
        int wrong3 = r.nextInt(100) + 1;

        questionTextView.setText(Integer.toString(num1)+ " + " +Integer.toString(num2));
        resultsTextView.setText(achievements + " / " + counter);

        List<Integer> list = new ArrayList<>();
        list.add(sum);
        list.add(wrong1);
        list.add(wrong2);
        list.add(wrong3);

        int a = list.get((int) (Math.random() * list.size()));
        list.remove(list.indexOf(a));
        button1.setText(Integer.toString(a));
        int b = list.get((int) (Math.random() * list.size()));
        list.remove(list.indexOf(b));
        button2.setText(Integer.toString(b));
        int c = list.get((int) (Math.random() * list.size()));
        list.remove(list.indexOf(c));
        button3.setText(Integer.toString(c));
        int d = list.get((int) (Math.random() * list.size()));
        list.remove(list.indexOf(d));
        button4.setText(Integer.toString(d));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.goButton);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        resetButton =findViewById(R.id.resetButton);
        timerTextView = findViewById(R.id.timerTextView);
        questionTextView = findViewById(R.id.questionTextView);
        resultsTextView = findViewById(R.id.resultsTextView);
        wcTextView = findViewById(R.id.wcTextView);

        mainGame();
        setGame();

    }
}