package com.qunar.work.domain;

public class Characters {
	
	private Integer characters;
	private Integer chinese;
	private Integer letters;
	private Integer punctuation;
	private String title;
	
	public Characters() {}

	public Characters(Integer characters, Integer chinese, Integer letters,
			Integer punctuation, String title) {
		this.characters = characters;
		this.chinese = chinese;
		this.letters = letters;
		this.punctuation = punctuation;
		this.title = title;
	}

	public Integer getCharacters() {
		return characters;
	}

	public void setCharacters(Integer characters) {
		this.characters = characters;
	}

	public Integer getChinese() {
		return chinese;
	}

	public void setChinese(Integer chinese) {
		this.chinese = chinese;
	}

	public Integer getLetters() {
		return letters;
	}

	public void setLetters(Integer letters) {
		this.letters = letters;
	}

	public Integer getPunctuation() {
		return punctuation;
	}

	public void setPunctuation(Integer punctuation) {
		this.punctuation = punctuation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
