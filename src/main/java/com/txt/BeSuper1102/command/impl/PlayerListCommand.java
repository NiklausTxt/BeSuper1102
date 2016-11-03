package com.txt.BeSuper1102.command.impl;

import java.util.ArrayList;
import java.util.List;

import com.txt.BeSuper1102.command.PlayerCommand;
import com.txt.BeSuper1102.mapping.dao.QuestionDao;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.pojo.Question;
import com.txt.BeSuper1102.util.Console;

public class PlayerListCommand extends PlayerCommand {

	public PlayerListCommand(Player player) {
		super(player);
	}

	@Override
	public void excute() {
		List<Question> questions = new ArrayList<>();
		Console.println("请选择罗列问题的模式：ALL,MINE,OPEN,ID");
		String type = Console.askUserInput("cmd>");
		if(type.equals("all")){
			questions = QuestionDao.getAllQuestion();
		}else if(type.equals("mine")){
			questions = QuestionDao.getAllQuestionByPlayerId(player);
		}else if(type.equals("open")){
			questions = QuestionDao.getAllQuestionByIsOpen();
		}else if(type.equals("id")){
			int qID = Integer.parseInt(Console.askUserInput("请输入ID："));
			Question question = QuestionDao.getAllQuestionById(qID);
			if(question==null){
				Console.println("该问题编号不存在。");
				return ;
			}
			questions.add(question);
		}

		for (Question q : questions) {
			Console.println(q.toString());
		}
	}

}
