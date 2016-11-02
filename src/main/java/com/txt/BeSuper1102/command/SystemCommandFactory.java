package com.txt.BeSuper1102.command;

import java.util.HashMap;
import java.util.Map;

import com.txt.BeSuper1102.command.impl.ExitCommand;
import com.txt.BeSuper1102.command.impl.HelpCommand;
import com.txt.BeSuper1102.command.impl.InvalidCommand;
import com.txt.BeSuper1102.command.impl.LoginCommand;
import com.txt.BeSuper1102.command.impl.SignupCommand;


public class SystemCommandFactory extends CommandFactory{
	
	private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();
	
	static {
		commandMap.put(CommandCode.EXIT, ExitCommand.class);
		commandMap.put(CommandCode.HELP, HelpCommand.class);
		commandMap.put(CommandCode.SIGNUP, SignupCommand.class);
		commandMap.put(CommandCode.LOGIN, LoginCommand.class);
	}
	
	public Command buildCommand(CommandCode identifier){
		Class<? extends Command> cmdClass = commandMap.get(identifier);
		if(cmdClass != null){
			try {
				return cmdClass.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return new InvalidCommand();
	}
}
