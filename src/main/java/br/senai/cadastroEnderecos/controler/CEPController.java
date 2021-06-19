package br.senai.cadastroEnderecos.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.senai.cadastroEnderecos.model.Endereco;
import br.senai.cadastroEnderecos.repository.EnderecoRepository;

@RestController
public class CEPController {
	
	@Autowired
	private EnderecoRepository er;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public boolean cadastrarEndereco(@RequestBody Endereco cadastro){
		
		er.save(cadastro);
		
		return true;
		
	}
	
	@CrossOrigin(origins = "http://localhost:9090")
	@RequestMapping("/listar")
	public Iterable<Endereco> listarEndereco() {
		Iterable<Endereco> endereco = er.findAll();
		return endereco;
	}
	
	@RequestMapping(value = "/deletaEndereco")
	public boolean deletaEndereco(long codigo) {
		Endereco endereco = er.findByCodigo(codigo);
		er.delete(endereco);
		
		return true;
	}
	
	@RequestMapping(value = "/editaEndereco")
	public boolean editaEndereco(@RequestBody Endereco cadastro, long codigo) {
		cadastro.setId(codigo);
		
		er.save(cadastro);
		
		
		return true;
	}
	
	
}
