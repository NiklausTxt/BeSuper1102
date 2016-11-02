package com.txt.BeSuper1102;

import com.txt.BeSuper1102.command.Command;
import com.txt.BeSuper1102.command.CommandFactory;
import com.txt.BeSuper1102.command.CommandFactory.CommandCode;
import com.txt.BeSuper1102.command.impl.HelpCommand;
import com.txt.BeSuper1102.pojo.Player;
import com.txt.BeSuper1102.util.Console;

public class TestMain {
	private static TestMain instance = null;

	private TestMain() {
	}

	public synchronized static TestMain getInstance() {
		if (instance == null) {
			instance = new TestMain();
		}
		return instance;
	}

	private Player player;

	public static void main(String[] args) {
		Command start = new HelpCommand();
		while (true) {
			String cmd = Console.askUserInput("cmd> ");
			CommandCode cmdCode = null;
			try {
				cmdCode = CommandCode.valueOf(cmd.toUpperCase());
			} catch (Exception e) {
				Console.println("不合法输入...");
				continue;
			}
			
			CommandFactory fac = CommandFactory.getFactory(TestMain.getInstance().getPlayer());
			Command command = fac.buildCommand(cmdCode);
			command.excute();

		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
