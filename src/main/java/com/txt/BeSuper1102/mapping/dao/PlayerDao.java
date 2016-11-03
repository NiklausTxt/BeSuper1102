package com.txt.BeSuper1102.mapping.dao;

import org.apache.ibatis.session.SqlSession;

import com.txt.BeSuper1102.pojo.Player;

public class PlayerDao {
//	static String resource = "mybatis_conf.xml";
//	static InputStream is = TestMain.class.getClassLoader().getResourceAsStream(resource);
//	static SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	static SqlSession session;
	static String statement;
	public static boolean isUsernameExists(String name) {
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.getPlayerByName";
		Player player = session.selectOne(statement,name);
		session.close();
		if(player==null){
			return false;
		}else{
			return true;
		}
	}
	
	public static Player getPlayerById(int id){
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.getPlayerById";
		Player player = session.selectOne(statement,id);
		session.close();
		return player;
	}
	
	public static Player Login(Player player){
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.userLogin";
		player = session.selectOne(statement,player);
		session.close();
		return player;
	}
	
	public static int Sign(Player player){
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.insertPlayer";
		int count = 0;
		try {
			count = session.insert(statement,player);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return count;
	}
	
	public static int UpdateScore(Player player){
		session = SessionFactory.getInstance().openSession();
		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.updatePlayer";
		int count = 0;
		try {
			count = session.update(statement,player);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return count;
	}
}
