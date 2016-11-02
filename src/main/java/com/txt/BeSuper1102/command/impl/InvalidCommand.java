package com.txt.BeSuper1102.command.impl;

import com.txt.BeSuper1102.command.Command;
import com.txt.BeSuper1102.util.Console;

public class InvalidCommand implements Command {

	@Override
	public void excute() {
		Console.println("输入不合法...");
	}

}
