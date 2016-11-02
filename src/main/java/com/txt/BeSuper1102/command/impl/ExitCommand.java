package com.txt.BeSuper1102.command.impl;

import com.txt.BeSuper1102.command.SystemCommand;
import com.txt.BeSuper1102.util.Console;

public class ExitCommand extends SystemCommand{

	@Override
	public void excute() {
		Console.println("欢迎下次使用，再见！！！");
		System.exit(0);	
	}

	

}
