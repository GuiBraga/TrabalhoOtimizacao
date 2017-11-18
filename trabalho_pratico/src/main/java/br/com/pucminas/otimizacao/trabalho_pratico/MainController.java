package br.com.pucminas.otimizacao.trabalho_pratico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

//	@RequestMapping("/hello")
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
	
	@RequestMapping(value = "/calcular", method = RequestMethod.POST)
	public ModelAndView calculaProblema(@ModelAttribute("problema") Problema problema) {
		System.out.println(problema.toString());
		return null;
	}
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }
}
