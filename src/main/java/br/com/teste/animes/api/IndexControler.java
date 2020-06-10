//package br.com.teste.animes.api;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
////todos os webs services do Spring Boot tem que esta anotados com @RestController
//// É isso que transforma essa classe em um web service Rest
//@RestController
//@RequestMapping("/")
//public class IndexControler {
//	
//	@GetMapping()
//	public String get() {
//		return "GET Spring Boot";
//	}
//	@PostMapping()
//	public String post() {
//		return  "POST Spring boot";
//	}
//	@PutMapping()
//	public String put() {
//		return  "PUT Spring boot";
//	}
//	@DeleteMapping()
//	public String delete() {
//		return  "DELETE Spring boot";
//	}
//	
//	@GetMapping("/login")
//	//@RequestParam usado para utilizar parametros de um método
//	public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
//		return "login: "+ login+" senha: "+senha;
//	}
//	@GetMapping("/login2/{login}/senha/{senha}")
//	//@PathVariable usado para utilizar parametros de um método atraveis da URL
//	public String loginPath(@PathVariable("login") String login,@PathVariable("senha") String senha) {
//		return "login: "+ login+" senha: "+senha;
//	}
//	@PostMapping("/login")
//	public String loginPost(@RequestParam("login") String login, @RequestParam("senha") String senha) {
//		return "login: "+ login+" senha: "+senha;
//	}
//
//	
//
//
//}
