package com.mysite.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository <Question, Integer> {
    Question findBySubject (String subject); //컬럼명과 동일해야 함.
    // if 'Title' findByTitle (String titile);
    Question findByContent (String content);
    Question findBySubjectAndContent (String subject, String content);
    Question findBySubjectOrContent (String subject, String content);

    List<Question> findByIdLessThan (Integer id);
    Page<Question> findAll(Pageable pageable);


}
