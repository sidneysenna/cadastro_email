package br.tec.email.emailapp.service.mapper;

import br.tec.email.emailapp.domain.entity.Cliente;
import br.tec.email.emailapp.domain.entity.Endereco;
import br.tec.email.emailapp.service.dto.ClienteInclusaoDTO;
import br.tec.email.emailapp.service.dto.EnderecoInclusaoDTO;

public class ClienteMapper {
	
	private ClienteMapper() {
		
	}

	public static Cliente fromDTO(ClienteInclusaoDTO dto) {

		if(dto==null) return null;

		Cliente cli = new Cliente();
		cli.setCpf(dto.getCpf());
		cli.setEmail(dto.getEmail());
		
		if(dto.getEndereco()!=null) {
			Endereco end = new Endereco();
			end.setBairro(dto.getEndereco().getBairro());
			end.setCep(dto.getEndereco().getCep());
			end.setComplemento(dto.getEndereco().getComplemento());
			end.setDdd(dto.getEndereco().getDdd());
			end.setGia(dto.getEndereco().getGia());
			end.setIbge(dto.getEndereco().getIbge());
			end.setLocalidade(dto.getEndereco().getLocalidade());
			end.setLogradouro(dto.getEndereco().getLogradouro());
			end.setSiafi(dto.getEndereco().getSiafi());
			end.setUf(dto.getEndereco().getUf());
			cli.setEndereco(end);
		}
		return cli;		
	}

	public static ClienteInclusaoDTO toDTO(Cliente cliente) {

		if(cliente==null) return null;

		ClienteInclusaoDTO cli = new ClienteInclusaoDTO(cliente.getCpf(), cliente.getEmail());
		
		if(cliente.getEndereco()!=null) {
			EnderecoInclusaoDTO end = new EnderecoInclusaoDTO(cliente.getEndereco().getCep(), cliente.getEndereco().getLogradouro());
			end.setBairro(cliente.getEndereco().getBairro());
			end.setComplemento(cliente.getEndereco().getComplemento());
			end.setDdd(cliente.getEndereco().getDdd());
			end.setGia(cliente.getEndereco().getGia());
			end.setIbge(cliente.getEndereco().getIbge());
			end.setLocalidade(cliente.getEndereco().getLocalidade());
			end.setSiafi(cliente.getEndereco().getSiafi());
			end.setUf(cliente.getEndereco().getUf());
			cli.setEndereco(end);
		}
		
		
		return cli;		
	}

}
