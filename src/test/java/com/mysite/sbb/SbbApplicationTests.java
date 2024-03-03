package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		//System.out.println ("contextLoads 실행");
	}

	@Test
	void testBCryptoTest() {
		this.userService.create ("test1", "test1@test.com", "1234");
	}

	@Test
	void testInsertJpa() {
		for (int i = 1; i <= 20; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
		}
	}
}

/*
	@Test
	void testJpa() {
		System.out.println ("testjpa 실행");
		Question q1 = new Question();
		q1.setSubject ("sbb가 뭔가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save (q1);

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);

	}

	@Test
	void testJpaFindAll() {

		// select * from question;
		List<Question> all = this.questionRepository.findAll();

		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 뭔가요?", q.getSubject());

		Question q2 = all.get(1);
		assertEquals("스프링부트 모델 질문입니다.", q2.getSubject());
	}

	@Test
	void testJpaFindId() {

		// select * from question where id = 1
		Optional<Question> oq = this.questionRepository.findById(1);
		if (oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 뭔가요?", q.getSubject());
		}

	}

	@Test
	void testJpaFindBySubject() {
		// select * from question where subject ='sbb가 뭔가요?'
		Question q = this.questionRepository.findBySubject("sbb가 뭔가요?");

		assertEquals(1, q.getId());

		//Question q2 = this.questionRepository.findByContent ("sbb에 대해서 알고 싶습니다");
		//assertEquals(1, q2.getId());
	}

	@Test
	void testJpaFindBySubjectAndContent() {

		Question q = this.questionRepository.findBySubjectAndContent("sbb가 뭔가요?","sbb에 대해서 알고 싶습니다");
		assertEquals(1, q.getId());
	}

	@Test
	void testJpaFindBySubjectOrContent() {
		Question q = this.questionRepository.findBySubjectOrContent(
				"sbb가 뭔가요?", "sbb에 대해서 알고 싶습니다");
		assertEquals(1, q.getId());
	}

	@Test
	void testJpaFindByIdLessThan() {
		// query method 공식문서 -> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
		// < LessThan
		List<Question> qList = this.questionRepository.findByIdLessThan(3);
		// <= LessThanEqual
		//List<Question> qList = this.questionRepository.findByIdLessThanEqual(2);
		// >= GreaterThanEqual
		assertEquals(2, qList.size());
	}

	@Test
	void testJpaQuestionUpdatae() {
		//1. update 할 row data 가져옴 (업데이트 전에 row 존재하는지 확인 필요)
		Optional<Question> oq = this.questionRepository.findById(2);
		//2. data 존재여부 확인
		assertTrue (oq.isPresent());
		//3. 수정할 객체 가져와 값을 수정
		Question q = oq.get();
		q.setSubject("Id 2 제목 수정되었음");
		q.setContent("내용도 수정되었음");
		// 4.수정값 적용
		this.questionRepository.save(q);
	}

	@Test
	void testJpaQuestionDel() {
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);

		assertTrue(oq.isPresent());
		Question q = oq.get();

		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}

	// 답변저장하기. 답변 데이터는 질문 데이터에 종속적
	// Thus, 질문 데이터 (질문 ID) 가져오고나서 답변데이터 저장
	@Test
	void testJpaAnswerInsert() {
		//1. 질문데이터 가져오기

		Optional<Question> oq = this.questionRepository.findById(4);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);

		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}


	@Test
	@Transactional (readOnly = true)// DB 세션을 유지, readonly=true 는 성능 향상에 기여
	void testJpaAnswerSelect2() {
		Optional<Question> oq = this.questionRepository.findById(4);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
}


*/

