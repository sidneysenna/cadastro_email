package br.tec.email.emailapp.domain.hu.inclusaocadastro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.tec.email.emailapp.domain.entity.Cliente;
import br.tec.email.emailapp.domain.entity.Endereco;

@ExtendWith(MockitoExtension.class)
class InclusaoCadastroTest {

	@Mock
	InclusaoCadastroRepository repository;
	
	@Mock
	EnderecoClient enderecoClient;
	
	@DisplayName("Verifica se ocorre cadastro em caso de cliente nao existir na base de dados")
    @Test
	void testInclusaoClienteNaoExistente() {
		
		Endereco endereco = new Endereco();
		endereco.setCep("cep");
		Cliente cliente = new Cliente("cpf","email");
		cliente.setEndereco(endereco);
		
		when(repository.clienteJaCadastrado(cliente)).thenReturn(false);
		when(repository.cadastrarCliente(cliente)).thenReturn(cliente);
		
		try {
			lenient().when(enderecoClient.getEnderecoCompleto("cep")).thenReturn(endereco);
		} catch (EnderecoNaoExistenteException e1) {
			
		}
		
		InclusaoCadastro inclusaoCadastro = new InclusaoCadastroHU(repository, enderecoClient);
		
		Cliente clienteCadastrado = null;
		
		try {
			clienteCadastrado = inclusaoCadastro.cadastrarCliente(cliente);
		} catch (ClienteJaCadastradoException e) {
			fail(e.getMessage());
		} catch (EnderecoNaoExistenteException e) {
			fail(e.getMessage());
		}
		
		assertEquals(cliente.getCpf(), clienteCadastrado.getCpf());
	}
	
	
	@DisplayName("Verifica se o cadastro é bloqueado em caso de cliente existir na base de dados")
    @Test
	void testInclusaoClienteoExistente() {
		Cliente cliente = new Cliente("cpf","email");
		
		when(repository.clienteJaCadastrado(cliente)).thenReturn(true);
		
		InclusaoCadastro inclusaoCadastro = new InclusaoCadastroHU(repository, enderecoClient);
				
		assertThrows(ClienteJaCadastradoException.class,
	            ()->{
	            	inclusaoCadastro.cadastrarCliente(cliente);
	            });
		
		
		
	}
	
	
}
