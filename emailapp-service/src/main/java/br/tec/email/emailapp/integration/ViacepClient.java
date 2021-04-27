package br.tec.email.emailapp.integration;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.tec.email.emailapp.domain.entity.Endereco;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoClient;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoNaoExistenteException;

public class ViacepClient implements EnderecoClient{

	@Override
	public Endereco getEnderecoCompleto(String cep) throws EnderecoNaoExistenteException{
		
		String target = "http://viacep.com.br/";
		String recurso = "ws/";
		Gson gson = new Gson();
		Response res = null;
		Client client = ClientBuilder.newClient();
		try {
			res = client.target(target).path(recurso+cep+"/json").request(MediaType.APPLICATION_JSON).get();
			String tempResultadoendereco = res.readEntity(String.class);
			return gson.fromJson(tempResultadoendereco, Endereco.class);
		} catch (Exception e) {
			throw new EnderecoNaoExistenteException();
		}
	}

}
