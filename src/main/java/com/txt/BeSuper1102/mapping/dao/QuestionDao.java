package com.txt.BeSuper1102.mapping.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.txt.BeSuper1102.TestMain;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.pojo.Question;

public class QuestionDao {
//	static String resource = "mybatis_conf.xml";
//	static InputStream is = TestMain.class.getClassLoader().getResourceAsStream(resource);
//	static SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	static SqlSession session;
	static String statement;

	public static List<Question> getAllQuestion() {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.getAllQuestion";
		List<Question> questions = session.selectList(statement);
		session.close();
		return questions;
	}
	
	public static List<Question> getAllQuestionByPlayerId(Player player) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.getQuestionByPlayerId";
		List<Question> questions = session.selectList(statement,player);
		session.close();
		return questions;
	}
	
	public static List<Question> getAllQuestionByIsOpen() {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.getQuestionByIsOpen";
		List<Question> questions = session.selectList(statement);
		session.close();
		return questions;
	}
	
	public static Question getAllQuestionById(int id) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.getQuestionById";
		Question question = session.selectOne(statement,id);
		session.close();
		return question;
	}
	
	public static int insertQuestion(Question question) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.insertQuestion";
		int count=0;
		try {
			count = session.insert(statement,question);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return count;
	}
	
	public static int updateQuestion(Question question) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.updateQuestion";
		int count = 0;
		try {
			count = session.update(statement,question);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return count;
	}
	
	
}
