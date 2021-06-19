package br.senai.cadastroEnderecos.repository;

import org.springframework.data.repository.CrudRepository;

import br.senai.cadastroEnderecos.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String>{
		Endereco findByCodigo(long codigo);
}
