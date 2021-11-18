package com.bolsadeideas.springboot.web.app.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")//rutabase
public class EjemploParamController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")//enviare un string
	//enviar parametros mediante url
	public String params(@RequestParam(name = "texto",required = false, defaultValue = "lagun balor......") String texto, Model model) {
		model.addAttribute("resultado", "el texto enviado es:  " + texto);
		return "params/ver";
		//nombre igual ala carpeta
	}

	
	@GetMapping("/max-params")//enviare un string
	//enviar parametros mediante url
	public String params(@RequestParam String saludo, @RequestParam Integer numero,  Model model) {
		model.addAttribute("resultado", "el saludo enviado es:  " + saludo + "'el numro es'" +numero+"");
		return "params/ver";
		//nombre igual ala carpeta
	}
	

	@GetMapping("/max-params-request")//enviare un string
	//enviar parametros mediante url
	public String params(HttpServletRequest request,  Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		
		try {
		numero = Integer.parseInt( request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "el saludo enviado es:  " + saludo + "'el numero es'" +numero+"");
		return "params/ver";
		//nombre igual ala carpeta
	}
	
}
