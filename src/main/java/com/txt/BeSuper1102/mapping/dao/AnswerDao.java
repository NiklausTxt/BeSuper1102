package com.txt.BeSuper1102.mapping.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.txt.BeSuper1102.pojo.Answer;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.pojo.Question;

public class AnswerDao {
//	static String resource = "mybatis_conf.xml";
//	static InputStream is = TestMain.class.getClassLoader().getResourceAsStream(resource);
//	static SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	static SqlSession session;
	static String statement;

	
	
	
	public static int insertAnswer(Answer answer) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.AnswerMapper.insertAnswer";
		int count = 0;
		try {
			count = session.insert(statement, answer);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return count;			
	}
	
	public static List<Answer> getAnswerByPlayerId(Player player) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.AnswerMapper.selectAnswerByPlayerId";
		List<Answer> answers = session.selectList(statement, player);
		session.close();
		return answers;
	}
	
	public static List<Answer> getAnswerByQuestionId(Question question) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.AnswerMapper.selectAnswerByQuestionId";
		List<Answer> answers = session.selectList(statement, question);
		session.close();
		return answers;
	}
	
	public static Answer getAnswerById(int id) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.AnswerMapper.selectAnswerById";
		Answer answer = session.selectOne(statement, id);
		session.close();
		return answer;
	}
	
	public static int updateAnswer(Answer answer) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.AnswerMapper.updateAnswer";
		int count = 0;
		try {
			count = session.update(statement,answer);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return count;
	}
}
