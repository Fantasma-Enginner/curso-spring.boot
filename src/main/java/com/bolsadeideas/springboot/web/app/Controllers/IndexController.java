package com.bolsadeideas.springboot.web.app.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.Models.Usuario;



@Controller
@RequestMapping("/app")//mapiamos
public class IndexController {
	
	@Value("${texto.IndexController.texto.titulo}")
	private String textoIndex;
	@Value("${texto.IndexController.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.IndexController.listar.titulo}")
	private String textoListar;
	
	
	
	@GetMapping({"/index","/","","home"})
	public String index(Model model) {
		//pasa atribitos con model a index.html
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	//objetos
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();// esta es una instancia import Usario de models
		
		usuario.setNombre("romario");
		usuario.setApellido("gonzalez");
		usuario.setEmail("ingenieroromario@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}

	
	@RequestMapping("/listar")
	public String model(Model model) {
	
		model.addAttribute("titulo",  textoListar);
		
		return "listar";
	}
	
	//pasar ala vista lista usuarios
	@ModelAttribute("usuarios")
	public List<Usuario> PoblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("romario","gonzalez","ingenieroromario@gmail.com"),
				new Usuario("ronaldo","vega","ronaldo@gmail.com"),
			    new Usuario("julian","martin","julian@gmail.com"),
			    new Usuario("maira","lia","maira@gmail.com"));
		return usuarios;
	}
}
