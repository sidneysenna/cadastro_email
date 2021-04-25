package br.tec.email.emailapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroException;
import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroService;
import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroServiceBean;
import br.tec.email.emailapp.service.inclusaocadastro.dto.ClienteInclusaoDTO;

@ExtendWith(MockitoExtension.class)
class InclusaoCadastroTest {

	@DisplayName("Verifica se ocorre cadastro em caso de cliente nao existir na base de dados")
    @Test
	void testInclusaoClienteNaoExistente() {
		ClienteInclusaoDTO cliente = new ClienteInclusaoDTO("cpf","email");
		
		//when(repository.clienteJaCadastrado(cliente)).thenReturn(false);
		//when(repository.cadastrarCliente(cliente)).thenReturn(cliente);
		
		InclusaoCadastroService inclusaoCadastro = new InclusaoCadastroServiceBean();
		
		ClienteInclusaoDTO clienteCadastrado = null;
		
		try {
			clienteCadastrado = inclusaoCadastro.cadastrarCliente(cliente);
		} catch (InclusaoCadastroException e) {
			fail(e.getMessage());
		}
		
		assertEquals(cliente.getCpf(), clienteCadastrado.getCpf());
	}
}
