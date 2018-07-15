package com.qunar.work.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qunar.work.domain.Characters;
import com.qunar.work.mapper.CharacterMapper;
import com.qunar.work.service.CharacterService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("characterService")
public class CharacterServiceImpl implements CharacterService{
	
	@Autowired
	private CharacterMapper characterMapper;

	@Transactional(readOnly=true)
	@Override
	public List<Characters> getAllCharacters() {
		return characterMapper.findAll();
	}

	@Transactional
	@Override
	public void addCharacters(Characters characters) {
		characterMapper.addCharacters(characters);
	}

}
