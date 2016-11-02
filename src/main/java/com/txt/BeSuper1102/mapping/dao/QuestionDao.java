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
	static String resource = "mybatis_conf.xml";
	static InputStream is = TestMain.class.getClassLoader().getResourceAsStream(resource);
	static SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	static SqlSession session;
	static String statement;

	public static List<Question> getAllQuestion() {
		session = sessionFactory.openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.getAllQuestion";
		List<Question> questions = session.selectList(statement);
		
		session.close();
		return questions;
	}
	
	public static List<Question> getAllQuestionByPlayerId(Player player) {
		session = sessionFactory.openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.getQuestionByPlayerId";
		List<Question> questions = session.selectList(statement,player);
		session.close();
		return questions;
	}
	
	public static List<Question> getAllQuestionByIsOpen() {
		session = sessionFactory.openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.getQuestionByIsOpen";
		List<Question> questions = session.selectList(statement);
		session.close();
		return questions;
	}
	
	public static Question getAllQuestionById(int id) {
		session = sessionFactory.openSession();
		statement = "com.txt.BeSuper1102.mapping.QuestionMapper.getQuestionById";
		Question question = session.selectOne(statement,id);
		session.close();
		return question;
	}
}
