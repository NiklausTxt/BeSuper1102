package com.txt.BeSuper1102.command.impl;

import java.util.List;

import com.txt.BeSuper1102.command.PlayerCommand;
import com.txt.BeSuper1102.mapping.dao.AnswerDao;
import com.txt.BeSuper1102.mapping.dao.PlayerDao;
import com.txt.BeSuper1102.mapping.dao.QuestionDao;
import com.txt.BeSuper1102.pojo.Answer;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.pojo.Question;
import com.txt.BeSuper1102.util.Console;

public class PlayerAcceptCommand extends PlayerCommand {

	public PlayerAcceptCommand(Player player) {
		super(player);
	}

	@Override
	public void excute() {
		int quesID = Console.askUserInputint("请输入问题的编号：");
		Question question = QuestionDao.getAllQuestionById(quesID);
		List<Question> questions = QuestionDao.getAllQuestionByPlayerId(player);
		if(question==null){
			Console.println("该问题不存在");
			return ;
		}
		
		if(question.getIsOpen().equals("N")){
			Console.println("该问题已设置最佳答案");
			return ;
		}
		
		boolean flag=false;
		for(Question q:questions){
			if(q.getId()==quesID){
				flag=true;
			}
		}
		if(!flag){
			Console.println("该问题不是由你创建，你没有权限设置最佳答案");
			return ;
		}
		
		List<Answer> answers = AnswerDao.getAnswerByQuestionId(question);
		for(Answer a:answers){
			Console.println(a.toString());
		}
		
		int bestAnswer = Console.askUserInputint("请输入最佳答案的答案编号：");
		
		Answer answer = AnswerDao.getAnswerById(bestAnswer);
		if(answer==null){
			Console.println("输入的答案ID不存在");
			return ;
		}
		flag=false;
		for(Answer a:answers){
			if(a.getId()==answer.getId()){
				flag=true;
			}
		}
		if(!flag){
			Console.println("输入的答案ID不在可选列表中");
			return ;
		}
		
		answer.setBest("Y");
		question.setIsOpen("N");
		int answerFrom = answer.getPlayer_id();
		Player aFrom = PlayerDao.getPlayerById(answerFrom);
		int score=question.getCredit()+aFrom.getScore();
		aFrom.setScore(score);
		
		PlayerDao.UpdateScore(aFrom);
		QuestionDao.updateQuestion(question);
		AnswerDao.updateAnswer(answer);
		
	}

}
