package it.etlabora.progettojavaweb.model;

public class Utenti {
	
	private Integer id;
	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String password;
	private Boolean amministratore;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAmministratore() {
		return amministratore;
	}
	public void setAmministratore(Boolean amministratore) {
		this.amministratore = amministratore;
	}
	

}


