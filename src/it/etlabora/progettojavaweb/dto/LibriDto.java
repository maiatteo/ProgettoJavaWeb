package it.etlabora.progettojavaweb.dto;

public class LibriDto {
	private Integer id;
	private String titolo;
	private String casaeditrice;
	private String autori;
	private String categoria;
	private String isbn;
	private String note;
	private String stato;
	private Integer idutente;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getCasaeditrice() {
		return casaeditrice;
	}
	public void setCasaeditrice(String casaeditrice) {
		this.casaeditrice = casaeditrice;
	}
	public String getAutori() {
		return autori;
	}
	public void setAutori(String autori) {
		this.autori = autori;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Integer getIdutente() {
		return idutente;
	}
	public void setIdutente(Integer idutente) {
		this.idutente = idutente;
	}
}
