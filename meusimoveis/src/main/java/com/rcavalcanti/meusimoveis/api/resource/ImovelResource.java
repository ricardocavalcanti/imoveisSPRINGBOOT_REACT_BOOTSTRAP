package com.rcavalcanti.meusimoveis.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcavalcanti.meusimoveis.service.ImovelService;

//Meu Controller
@RestController
@RequestMapping("/api/imoveis")
public class ImovelResource {
	
	private ImovelService service;
	
	public ImovelResource(ImovelService service) {
		this.service = service;		
	}
	
	//@PostMapping
//	public ResponseEntity salvar(@RequestBody ImovelDTo dto) {
//		
//	}
}
