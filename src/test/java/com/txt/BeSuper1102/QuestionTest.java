package com.txt.BeSuper1102;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.txt.BeSuper1102.mapping.dao.QuestionDao;
import com.txt.BeSuper1102.pojo.Question;

public class QuestionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllQuestion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllQuestionByPlayerId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllQuestionByIsOpen() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllQuestionById() {
		int id = 2;
		Question q = QuestionDao.getAllQuestionById(id);
		Assert.assertNotNull(q);
	}

	@Test
	public void testInsertQuestion() {
		Question q = new Question();
		q.setValue("dfef");
		q.setCredit(10);
		q.setPlayer_id(3);
		int count = QuestionDao.insertQuestion(q);
		Assert.assertEquals(1, count);
	}

	@Test
	public void testUpdateQuestion() {
		fail("Not yet implemented");
	}

}
