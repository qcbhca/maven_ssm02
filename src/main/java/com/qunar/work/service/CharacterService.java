package com.qunar.work.service;

import java.util.List;

import com.qunar.work.domain.Characters;

public interface CharacterService {

	List<Characters> getAllCharacters();
	void addCharacters(Characters characters);
}
