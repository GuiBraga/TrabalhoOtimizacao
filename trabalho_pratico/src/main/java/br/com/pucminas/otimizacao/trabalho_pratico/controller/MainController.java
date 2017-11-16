package br.com.pucminas.otimizacao.trabalho_pratico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

//	@RequestMapping("/hello")
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }
}
