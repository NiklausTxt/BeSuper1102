package com.txt.BeSuper1102.command.impl;

import com.txt.BeSuper1102.command.PlayerCommand;
import com.txt.BeSuper1102.mapping.dao.AnswerDao;
import com.txt.BeSuper1102.mapping.dao.QuestionDao;
import com.txt.BeSuper1102.pojo.Answer;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.pojo.Question;
import com.txt.BeSuper1102.util.Console;

public class PlayerAnswerCommand extends PlayerCommand{

	public PlayerAnswerCommand(Player player) {
		super(player);
	}

	@Override
	public void excute() {
		int qid = Console.askUserInputint("请输入回答问题的编号：");
		
		Question question = QuestionDao.getAllQuestionById(qid);
		if(question==null){
			Console.println("该问题编号不存在...");
			return ;
		}
		if(player.getId() == question.getPlayer_id()){
			Console.println("你不能回答自己的问题");
			return ;
		}
		
		if(question.getIsOpen().equals("N")){
			Console.println("该问题已有最佳答案");
			return ;
		}
		
		String aAnswer = Console.askUserInput("请输入问题答案");
		Answer answer = new Answer();
		answer.setPlayer_id(player.getId());
		answer.setQuestion_id(qid);
		answer.setValue(aAnswer);
		AnswerDao.insertAnswer(answer);
		
		player.getAnswers().add(answer);
		question.getAnswers().add(answer);
		
		
		
	}


}
