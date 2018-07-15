package com.qunar.work.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.qunar.work.domain.Characters;

public interface CharacterMapper {

	@Select(" select * from characters ")
	List<Characters> findAll();
	
	@Insert("insert into characters(characters,chinese,letters,punctuation,title) values" +
			"(#{characters},#{chinese},#{letters},#{punctuation},#{title})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int addCharacters(Characters characters);
}
