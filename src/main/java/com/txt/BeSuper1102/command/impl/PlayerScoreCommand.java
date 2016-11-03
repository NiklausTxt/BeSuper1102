package com.txt.BeSuper1102.command.impl;

import java.util.List;

import com.txt.BeSuper1102.command.PlayerCommand;
import com.txt.BeSuper1102.mapping.dao.AnswerDao;
import com.txt.BeSuper1102.mapping.dao.QuestionDao;
import com.txt.BeSuper1102.pojo.Answer;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.pojo.Question;
import com.txt.BeSuper1102.util.Console;

public class PlayerScoreCommand extends PlayerCommand {

	public PlayerScoreCommand(Player player) {
		super(player);
	}

	@Override
	public void excute() {
		List<Question> questions = QuestionDao.getAllQuestionByPlayerId(player);
		List<Answer> answers = AnswerDao.getAnswerByPlayerId(player);
		int score = player.getScore();
		int qNum = questions.size();
		int aNum = answers.size();
		String level = "";
		if (score > 100) {
			level = "学霸";
		} else if (score > 60) {
			level = "学生";
		} else if (score > 30) {
			level = "学渣";
		} else {
			level = "弱鸡";
		}
		Console.println("==============" + player.getName() + "玩家的成绩====================");
		Console.println("提出问题的个数：" + qNum);
		Console.println("回答问题的个数：" + aNum);
		Console.println("你的最终得分是：" + score);
		Console.println("你的最终等级是：" + level);
	}

}
