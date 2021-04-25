package br.tec.email.emailapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.tec.email.emailapp.domain.entity.Cliente;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.InclusaoCadastroRepository;
import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroException;
import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroService;
import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroServiceBean;
import br.tec.email.emailapp.service.inclusaocadastro.dto.ClienteInclusaoDTO;

@ExtendWith(MockitoExtension.class)
class InclusaoCadastroTest {
	
	@Mock
	InclusaoCadastroRepository repository;
	
	
	@DisplayName("Verifica se ocorre cadastro em caso de cliente nao existir na base de dados")
    @Test
	void testInclusaoClienteNaoExistente() {
		ClienteInclusaoDTO clienteDTO = new ClienteInclusaoDTO("cpf","email");
		Cliente cliente = new Cliente("cpf","email");
		
		lenient().when(repository.clienteJaCadastrado(cliente)).thenReturn(false);
		lenient().when(repository.cadastrarCliente(Mockito.any())).thenReturn(cliente);
		
		InclusaoCadastroService inclusaoCadastro = new InclusaoCadastroServiceBean(repository);
		
		ClienteInclusaoDTO clienteCadastrado = null;
		
		try {
			clienteCadastrado = inclusaoCadastro.cadastrarCliente(clienteDTO);
		} catch (InclusaoCadastroException e) {
			fail(e.getMessage());
		}
		
		assertEquals(cliente.getCpf(), clienteCadastrado.getCpf());
	}
}
