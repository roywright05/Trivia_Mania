package com.wrightr.trivia_mania;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.wrightr.trivia_mania.controller.AppController;
import com.wrightr.trivia_mania.data.AnswerListAsyncResponse;
import com.wrightr.trivia_mania.data.Repository;
import com.wrightr.trivia_mania.databinding.ActivityMainBinding;
import com.wrightr.trivia_mania.model.Question;
import com.wrightr.trivia_mania.model.Score;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    private ActivityMainBinding binding;
    private int currentQuestionIndex = 0;
    List <Question> questionList;

   //int number = new Random().nextInt(913);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        questionList = new Repository().getQuestions(questionArrayList -> {

            binding.questionTv.setText(questionArrayList.get(currentQuestionIndex)
                            .getAnswer());
                    updateQuestion();

                }


        );



        binding.buttonNext.setOnClickListener(view ->{
            currentQuestionIndex = (currentQuestionIndex + 1) % questionList.size();
            updateQuestion();
        });

        binding.buttonTrue.setOnClickListener(view ->{});

        binding.buttonFalse.setOnClickListener(view ->{});

    }

    private void updateCounter(ArrayList<Question> questionArrayList) {
        binding.tvOutOf.setText(
                String.format(getString(R.string.text_formatted), currentQuestionIndex, questionArrayList.size()));
    }

    private void updateQuestion() {

        String question = questionList.get(currentQuestionIndex).getAnswer();
        binding.questionTv.setText(question);
        updateCounter((ArrayList<Question>) questionList);

    }


}


//https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json