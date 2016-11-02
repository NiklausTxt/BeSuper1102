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
		questions = QuestionDao.getAllQuestion();

		for (Question q : questions) {
			Console.println(q.toString());
		}
	}

}
