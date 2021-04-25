package br.tec.email.emailapp.persistence.entity.mapper;

import br.tec.email.emailapp.domain.entity.Cliente;
import br.tec.email.emailapp.domain.entity.Endereco;
import br.tec.email.emailapp.persistence.entity.ClienteEntity;
import br.tec.email.emailapp.persistence.entity.EnderecoEntity;

public class ClienteMapper {
	
	private ClienteMapper() {
		
	}

	public static Cliente fromEntity(ClienteEntity entity) {

		if(entity==null) return null;

		Cliente cli = new Cliente();
		cli.setCpf(entity.getCpf());
		cli.setEmail(entity.getEmail());
		
		if(entity.getEndereco()!=null) {
			Endereco end = new Endereco();
			end.setBairro(entity.getEndereco().getBairro());
			end.setCep(entity.getEndereco().getCep());
			end.setComplemento(entity.getEndereco().getComplemento());
			end.setDdd(entity.getEndereco().getDdd());
			end.setGia(entity.getEndereco().getGia());
			end.setIbge(entity.getEndereco().getIbge());
			end.setLocalidade(entity.getEndereco().getLocalidade());
			end.setLogradouro(entity.getEndereco().getLogradouro());
			end.setSiafi(entity.getEndereco().getSiafi());
			end.setUf(entity.getEndereco().getUf());
			cli.setEndereco(end);
		}
		return cli;		
	}

	public static ClienteEntity toEntity(Cliente cliente) {

		if(cliente==null) return null;

		ClienteEntity cli = new ClienteEntity();
		cli.setCpf(cliente.getCpf());
		cli.setEmail(cliente.getEmail());
		
		if(cliente.getEndereco()!=null) {
			EnderecoEntity end = new EnderecoEntity();
			end.setBairro(cliente.getEndereco().getBairro());
			end.setCep(cliente.getEndereco().getCep());
			end.setComplemento(cliente.getEndereco().getComplemento());
			end.setDdd(cliente.getEndereco().getDdd());
			end.setGia(cliente.getEndereco().getGia());
			end.setIbge(cliente.getEndereco().getIbge());
			end.setLocalidade(cliente.getEndereco().getLocalidade());
			end.setLogradouro(cliente.getEndereco().getLogradouro());
			end.setSiafi(cliente.getEndereco().getSiafi());
			end.setUf(cliente.getEndereco().getUf());
			cli.setEndereco(end);
		}
		
		
		return cli;		
	}

}
