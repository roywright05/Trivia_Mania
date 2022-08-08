package com.wrightr.trivia_mania.data;

import com.wrightr.trivia_mania.model.Question;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {

    void processFinished(ArrayList<Question> questionArrayList);
}
