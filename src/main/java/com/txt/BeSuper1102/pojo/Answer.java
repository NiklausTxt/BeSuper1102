package com.txt.BeSuper1102.pojo;

public class Answer {
	private int id;
	private String value;
	private int question_id;
	private int player_id;
	private String best;
	private Question question;
	
	
	public Answer() {
		super();
	}
	public Answer(int id, String value, int question_id, int player_id) {
		super();
		this.id = id;
		this.value = value;
		this.question_id = question_id;
		this.player_id = player_id;
		this.best="N";
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}


	public String isBest() {
		return best;
	}
	public void setBest(String best) {
		this.best = best;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", question_id=" + question_id + ", player_id=" + player_id
				+ ", best=" + best+ ", value=" + value  + "]";
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
}
