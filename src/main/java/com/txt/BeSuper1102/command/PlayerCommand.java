package com.txt.BeSuper1102.command;

import com.txt.BeSuper1102.pojo.Player;

public abstract class PlayerCommand implements Command{
	
	protected Player player;
	
	public PlayerCommand(Player player){
		this.player=player;
	}
}
