package br.tec.email.emailapp.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.tec.email.emailapp.service.inclusaocadastro.InclusaoCadastroService;
import br.tec.email.emailapp.service.inclusaocadastro.dto.ClienteInclusaoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "InclusaoCadastro")
@Path("/recebimento-aluguel")
public class InclusaoCadastroResource {
	
	@Inject
	private InclusaoCadastroService inclusaoCadastroService;

	public InclusaoCadastroResource(InclusaoCadastroService inclusaoCadastroService) {
		this.inclusaoCadastroService = inclusaoCadastroService;
	}
	
	@ApiOperation(value = "Cadastrar cliente com endereço")
	@ApiResponses({ @ApiResponse(code = 201, message = "Registro cadastrado", response = ClienteInclusaoDTO.class), @ApiResponse(code = 412, message = "Erro", response = String.class) })
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarCliente(ClienteInclusaoDTO cliente) {
		try {
			inclusaoCadastroService.cadastrarCliente(cliente);
		} catch (Exception e) {
			return Response.status(403).build();
		}
		
		return Response.status(201).build();
	}

}
