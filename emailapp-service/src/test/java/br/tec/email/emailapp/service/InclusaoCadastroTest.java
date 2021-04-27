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
import br.tec.email.emailapp.domain.entity.Endereco;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.ClienteJaCadastradoException;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoClient;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoNaoExistenteException;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.InclusaoCadastroRepository;
import br.tec.email.emailapp.service.dto.ClienteInclusaoDTO;
import br.tec.email.emailapp.service.dto.EnderecoInclusaoDTO;
import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroServiceBean;

@ExtendWith(MockitoExtension.class)
class InclusaoCadastroTest {
	
	@Mock
	EnderecoClient enderecoClient;
	
	@Mock
	InclusaoCadastroRepository repository;
	
	
	@DisplayName("Verifica se ocorre cadastro em caso de cliente nao existir na base de dados")
    @Test
	void testInclusaoClienteNaoExistente() {
		
		Endereco endereco = new Endereco();
		endereco.setCep("cep");
		Cliente cliente = new Cliente("cpf","email");
		cliente.setEndereco(endereco);
		
		lenient().when(repository.clienteJaCadastrado(cliente)).thenReturn(false);
		lenient().when(repository.cadastrarCliente(Mockito.any())).thenReturn(cliente);
		
		try {
			lenient().when(enderecoClient.getEnderecoCompleto("cep")).thenReturn(endereco);
		} catch (EnderecoNaoExistenteException e1) {
		}
		
		InclusaoCadastroServiceBean inclusaoCadastro = new InclusaoCadastroServiceBean();
		inclusaoCadastro.setEnderecoClient(enderecoClient);
		inclusaoCadastro.setRepositoryDAO(repository);
		
		ClienteInclusaoDTO clienteCadastrado = new ClienteInclusaoDTO();
		clienteCadastrado.setCpf("cpf");
		clienteCadastrado.setEmail("email");
		EnderecoInclusaoDTO endCadastrado = new EnderecoInclusaoDTO();
		endCadastrado.setCep("cep");
		clienteCadastrado.setEndereco(endCadastrado);
		
		try {
			clienteCadastrado = inclusaoCadastro.cadastrarCliente(clienteCadastrado);
		} catch (ClienteJaCadastradoException e) {
			fail(e.getMessage());
		} catch (EnderecoNaoExistenteException e) {
			fail(e.getMessage());
		}
		
		assertEquals(cliente.getCpf(), clienteCadastrado.getCpf());
	}
}
