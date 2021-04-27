package br.tec.email.emailapp.presentation;

import java.net.URI;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.tec.email.emailapp.domain.hu.inclusaocadastro.ClienteJaCadastradoException;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoNaoExistenteException;
import br.tec.email.emailapp.service.dto.ClienteInclusaoDTO;
import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroService;

//@Api(value = "InclusaoCadastro")
@Path("/cliente-cadastro")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class InclusaoCadastroResource {
	
	Logger LOGGER = LoggerFactory.getLogger(InclusaoCadastroResource.class);
	
	@EJB
	InclusaoCadastroService inclusaoCadastroService;

//	@ApiOperation(value = "Inclusão de cadastro")
//	@ApiResponses({ @ApiResponse(code = 201, message = "OK", response = ClienteInclusaoDTO.class), @ApiResponse(code = 400, message = "Erro nos parâmetros obrigatórios", response = String.class) })
	@POST
	public Response cadastrar( ClienteInclusaoDTO cliente) {
		
		try {
			inclusaoCadastroService.cadastrarCliente(cliente);
			return Response.created(new URI("cliente/".concat(cliente.getEmail()))).build();
		} catch (ClienteJaCadastradoException e) {
			MessageDTO msg = new MessageDTO("Email ja cadastrado");
			return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
		} catch (EnderecoNaoExistenteException e) {
			MessageDTO msg = new MessageDTO("Algo de errado com o endereco");
			return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
		} catch (Exception e) {
			MessageDTO msg = new MessageDTO("Erro ao cadastrar cliente");
			return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
		}
		
	}
	

}
