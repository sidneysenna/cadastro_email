package br.tec.email.emailapp.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.tec.email.emailapp.persistence.entity.template.TemplateEntity;


@Entity
@Table(schema = "emailapp", name = "endereco")
public class EnderecoEntity extends TemplateEntity<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5225023337709675387L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "cep", nullable = false)
	private String cep;
	
	@Column(name = "logradouro", nullable = false)
	private String logradouro;
	
	@Column(name = "complemento", nullable = true)
	private String complemento;
	
	@Column(name = "bairro", nullable = true)
	private String bairro;
	
	@Column(name = "localidade", nullable = true)
	private String localidade; 
	
	@Column(name = "uf", nullable = true)
	private String uf;
	
	@Column(name = "ibge", nullable = true)
	private String ibge;
	
	@Column(name = "gia", nullable = true)
	private String gia;
	
	@Column(name = "ddd", nullable = true)
	private String ddd;
	
	@Column(name = "siafi", nullable = true)
	private String siafi;
	
	@OneToOne(mappedBy = "endereco")
	private ClienteEntity cliente;


	
	public EnderecoEntity(Integer id, String cep, String logradouro, ClienteEntity cliente) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.cliente = cliente;
	}

	public EnderecoEntity() {
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getIbge() {
		return ibge;
	}
	public void setIbge(String ibge) {
		this.ibge = ibge;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getSiafi() {
		return siafi;
	}
	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

}
