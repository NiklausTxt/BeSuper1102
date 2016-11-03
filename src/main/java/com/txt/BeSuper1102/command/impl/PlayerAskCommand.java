package com.txt.BeSuper1102.command.impl;

import com.txt.BeSuper1102.command.PlayerCommand;
import com.txt.BeSuper1102.mapping.dao.PlayerDao;
import com.txt.BeSuper1102.mapping.dao.QuestionDao;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.pojo.Question;
import com.txt.BeSuper1102.util.Console;

public class PlayerAskCommand extends PlayerCommand{

	public PlayerAskCommand(Player player) {
		super(player);		
	}

	@Override
	public void excute() {
		String content = Console.askUserInput("请输入提问的问题：");
		int credit =Console.askUserInputint("请输入问题的分值：");
		if(player.getScore()<credit){
			Console.println("你的当前分值不足"+credit+",默认设置问题的分值为"+player.getScore());
			credit=player.getScore();
		}
		Question question = new Question();
		question.setValue(content);
		question.setCredit(credit);
		question.setPlayer_id(player.getId());
		QuestionDao.insertQuestion(question);
		
		player.getQuestions().add(question);
		player.setScore(player.getScore()-credit);
		
		PlayerDao.UpdateScore(player);
		
	}
}
