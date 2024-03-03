package com.mysite.sbb;

import com.mysite.sbb.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test2 {

    @Autowired
    private QuestionRepository questionRepository;


}
