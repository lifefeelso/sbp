package com.mysite.sbb.question;

import com.mysite.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor //매개변수가 있는 생성자 추가
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion (Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
            if (question.isPresent()) {
                // View count 추가
                Question question1 =question.get();
                question1.setView(question1.getView()+1);
                this.questionRepository.save(question1);
                // View count 추가

                //return question.get();
                return question1;

            } else {
                throw new DataNotFoundException ("question not found");
            }

    }
    public void create (String subject, String content, SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }


    public Page<Question> getList (int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    public void modify(Question question, QuestionForm questionForm) {
        question.setSubject(questionForm.getSubject());
        question.setContent(questionForm.getContent());
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
    public void delete (Question question) {
        this.questionRepository.delete(question);
    }

    public void vote (Question question, SiteUser siteUser) {
        question.getVoter().add(siteUser);
        this.questionRepository.save(question);
    }

}
