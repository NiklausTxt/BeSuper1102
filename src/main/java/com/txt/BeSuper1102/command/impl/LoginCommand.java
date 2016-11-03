package com.txt.BeSuper1102.command.impl;

import com.txt.BeSuper1102.TestMain;
import com.txt.BeSuper1102.command.SystemCommand;
import com.txt.BeSuper1102.mapping.dao.PlayerDao;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.util.Console;

public class LoginCommand extends SystemCommand{
	@Override
	public void excute() {
		Console.println("=====================欢迎来到用户登录界面=====================");
		
		String username = Console.askUserInput("请输入用户名：");
		while(!PlayerDao.isUsernameExists(username)){
			Console.println("用户名不存在");
			username = Console.askUserInput("请输入用户名：");
		}
		String password = Console.askUserInput("请输入密码：");
		Player player = new Player();
		player.setUsername(username);
		player.setPassword(password);
		player = PlayerDao.Login(player);
		if(player==null){
			Console.println("登录失败，密码错误");
			return ;
		}
		Console.println("欢迎"+player.getName()+",登录成功！");
		TestMain.getInstance().setPlayer(player);
	}

	
}
