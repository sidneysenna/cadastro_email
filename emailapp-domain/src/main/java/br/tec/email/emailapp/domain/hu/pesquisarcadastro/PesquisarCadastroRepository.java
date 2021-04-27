package br.tec.email.emailapp.domain.hu.pesquisarcadastro;

import br.tec.email.emailapp.domain.entity.Cliente;

public interface PesquisarCadastroRepository {
	
	Cliente buscarCadastroPorEmail(String email);

}
