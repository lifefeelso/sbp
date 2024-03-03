package com.mysite.sbb.question;

// version 3.0 이상
import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter // @Entity 사용할떄는 @Setter 를 사용하지 않는다
@Entity
public class Question {
    @Id // PK 생성하는 어노테이션, 기본으로 필요함. 없으면 에러발생
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (length = 200)
    private String subject;

    @Column (columnDefinition = "text")
    private String content;

    private LocalDateTime createDate; // 작성날짜

   @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // mappedby 불필요한 테이블 생성 방지
    // casecadetype.remove 질문 삭제시 연관 답변삭제 방지
    private List<Answer> answerList; //list 나 set 객체로 생성

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set <SiteUser> voter;

    @Column (columnDefinition = "integer default 0", nullable = false)
    private int view;
}
