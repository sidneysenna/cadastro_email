package br.tec.email.emailapp.domain.hu.inclusaocadastro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.tec.email.emailapp.domain.entity.Cliente;

@ExtendWith(MockitoExtension.class)
class InclusaoCadastroTest {

	@Mock
	InclusaoCadastroRepository repository;
	
	@DisplayName("Verifica se ocorre cadastro em caso de cliente nao existir na base de dados")
    @Test
	void testInclusaoClienteNaoExistente() {
		Cliente cliente = new Cliente("cpf","email");
		
		when(repository.clienteJaCadastrado(cliente)).thenReturn(false);
		when(repository.cadastrarCliente(cliente)).thenReturn(cliente);
		
		InclusaoCadastro inclusaoCadastro = new InclusaoCadastroHU(repository);
		
		Cliente clienteCadastrado = null;
		
		try {
			clienteCadastrado = inclusaoCadastro.cadastrarCliente(cliente);
		} catch (ClienteJaCadastradoException e) {
			fail(e.getMessage());
		}
		
		assertEquals(cliente.getCpf(), clienteCadastrado.getCpf());
	}
	
	
	@DisplayName("Verifica se o cadastro é bloqueado em caso de cliente existir na base de dados")
    @Test
	void testInclusaoClienteoExistente() {
		Cliente cliente = new Cliente("cpf","email");
		
		when(repository.clienteJaCadastrado(cliente)).thenReturn(true);
		
		InclusaoCadastro inclusaoCadastro = new InclusaoCadastroHU(repository);
				
		assertThrows(ClienteJaCadastradoException.class,
	            ()->{
	            	inclusaoCadastro.cadastrarCliente(cliente);
	            });
		
		
		
	}
	
	
}
