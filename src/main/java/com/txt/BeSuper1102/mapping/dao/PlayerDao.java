package com.txt.BeSuper1102.mapping.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.txt.BeSuper1102.TestMain;
import com.txt.BeSuper1102.pojo.Player;

public class PlayerDao {
	static String resource = "mybatis_conf.xml";
	static InputStream is = TestMain.class.getClassLoader().getResourceAsStream(resource);
	static SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	static SqlSession session;
	static String statement;
	public static boolean isUsernameExists(String name) {
		session = sessionFactory.openSession();
		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.getPlayerByName";
		Player player = session.selectOne(statement,name);
		session.close();
		if(player==null){
			return false;
		}else{
			return true;
		}
	}
	
	public static Player Login(String username, String password){
		session = sessionFactory.openSession();
		Player player = new Player();
		player.setUsername(username);
		player.setPassword(password);
		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.userLogin";
		player = session.selectOne(statement,player);
		session.close();
		return player;
	}
	
	public static int Sign(Player player){
		session = sessionFactory.openSession();
		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.insertPlayer";
		int count = session.insert(statement,player);
		session.commit();
		session.close();
		return count;
	}
	
//	public static int UpdateScore(Player player){
//		session = sessionFactory.openSession();
//		statement = "com.txt.BeSuper1102.mapping.PlayerMapper.updatePlayer";
//		int count = session.update(statement,player);
//		session.commit();
//		session.close();
//		return count;
//	}
}
