package br.tec.email.emailapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.tec.email.emailapp.domain.entity.Endereco;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoClient;
import br.tec.email.emailapp.integration.ViacepClient;

class EnderecoTest {

	@DisplayName("Verifica se esta pesquisando o endereco")
    @Test
	void testInclusaoClienteNaoExistente() {
		EnderecoClient enderecoClient = new ViacepClient();
		try {
			Endereco end = enderecoClient.getEnderecoCompleto("30330390");
			assertEquals("30330-390", end.getCep());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
}
