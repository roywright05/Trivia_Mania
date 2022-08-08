package com.wrightr.trivia_mania.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.wrightr.trivia_mania.controller.AppController;
import com.wrightr.trivia_mania.model.Question;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    ArrayList<Question> questionArrayList = new ArrayList<>();

    String url =
            "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<Question> getQuestions( final AnswerListAsyncResponse callback){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {

                    for (int i = 0; i < response.length(); i++) {

                        try{

                            Question question = new Question(response.getJSONArray(i).getString(0),
                                    response.getJSONArray(i).getBoolean(1));
                            questionArrayList.add(question);
//                            Log.d("Repo", "onCreate: " + response.getJSONArray(i).get(0));
//                            Log.d("Repo", "onCreate: " + response.getJSONArray(i).getBoolean(1));
                        }catch (Exception e){

                            e.printStackTrace();
                        }

                    }

                    if (null != callback) callback.processFinished(questionArrayList);


                }, error -> {
            Log.d("Error", "onCreate: You done f-ed up homie.");
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }
}
