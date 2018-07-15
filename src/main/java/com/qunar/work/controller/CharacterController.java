package com.qunar.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.qunar.work.domain.Characters;
import com.qunar.work.service.CharacterService;
import com.qunar.work.utils.GetCharacters;

@Controller
public class CharacterController {

	@Autowired
	@Qualifier("characterService")
	private CharacterService characterService;
	
	@RequestMapping(value="/showCharacters")
	public String showCharacters(Model model) {
		List<Characters> charactersList = characterService.getAllCharacters();
		model.addAttribute("characters_list", charactersList);
		return "showCharacters";
	}
	
	@RequestMapping(value="/saveCharacters")
	public ModelAndView saveCharacters(String url,ModelAndView mv) {
		Characters characters = new GetCharacters(url).getCharacters();
		characterService.addCharacters(characters);
		mv.setView(new RedirectView("/maven_ssm02/showCharacters"));
		return mv;
	}
}
