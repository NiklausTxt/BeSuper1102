package com.txt.BeSuper1102;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.txt.BeSuper1102.pojo.Player;

public class App {
	public static void main(String[] args) {
		String resource = "mybatis_conf.xml";
		InputStream is = App.class.getClassLoader().getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

		SqlSession session=null;
		
		String statement=null;
		
		try {
			session = sessionFactory.openSession();

			statement = "com.txt.BeSuper1102.mapping.PlayerMapper.getPlayerById";
			
//			List<Player> players = session.selectList(statement);
			Player p = session.selectOne(statement,13);
			System.out.println(p);
//			for(Player p:players){
//				System.out.println(p);
//			}
			
			statement = "com.txt.BeSuper1102.mapping.PlayerMapper.getPlayerById";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
		}

	}
}
