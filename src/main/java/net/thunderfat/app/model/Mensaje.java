package net.thunderfat.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name="mensaje")
public class Mensaje {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private int 	id_mensaje;
	@ManyToOne
	@JoinColumn(name="id_chat")
	private Chat id_chat;
	
	private String contenido;
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime timestamp;
	@ManyToOne
	@JoinColumn(name="id_emisor")
	private User id_emisor	;
	
	public Mensaje() {
		super();
	}
	public int getId_mensaje() {
		return id_mensaje;
	}
	public void setId_mensaje(int id_mensaje) {
		this.id_mensaje = id_mensaje;
	}
	public Chat getId_chat() {
		return id_chat;
	}
	public void setId_chat(Chat id_chat) {
		this.id_chat = id_chat;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public User getId_emisor() {
		return id_emisor;
	}
	public void setId_emisor(User id_emisor) {
		this.id_emisor = id_emisor;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Mensaje [id_mensaje=" + id_mensaje + ", id_chat=" + id_chat + ", contenido=" + contenido
				+ ", timestamp=" + timestamp + ", id_emisor=" + id_emisor + "]";
	}
	
	
	


}
