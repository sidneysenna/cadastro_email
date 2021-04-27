package br.tec.email.emailapp.presentation;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.tec.email.emailapp.service.dto.ClienteInclusaoDTO;
import br.tec.email.emailapp.service.pesquisacadastro.PesquisaCadastroService;

@Path("/cliente")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class PesquisaCadastroResource {
	
	@EJB
	PesquisaCadastroService pesquisaCadastroService;
	
	@GET
	@Path("/ola")
	public Response ola() {
		return Response.status(201).build();
	}

	@GET
	@Path("{email}")
	public Response pesquisarCadastro(@PathParam("email") String email) {
		ClienteInclusaoDTO cli;
		try {
			cli = pesquisaCadastroService.pesquisarCadastro(email);
			return Response.status(200).entity(cli).build();
		} catch (Exception e) {
			return Response.status(401).build();
		}
	}

}
