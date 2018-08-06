package net.thunderfat.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="chat")
public class Chat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_chat;
	@ManyToOne 
	@JoinColumn(name="id_origen")
	private User id_origen;
	@ManyToOne
	@JoinColumn (name ="id_destino")
	private User id_destino;
	
	private Date fecha;	
	private String status;
	@OneToMany(mappedBy="id_chat")	
	private List<Mensaje> mensajes;
	public Chat() {
		super();
	}
	public int getId_chat() {
		return id_chat;
	}
	public void setId_chat(int id_chat) {
		this.id_chat = id_chat;
	}
	public User getId_origen() {
		return id_origen;
	}
	public void setId_origen(User id_origen) {
		this.id_origen = id_origen;
	}
	public User getId_destino() {
		return id_destino;
	}
	public void setId_destino(User id_destino) {
		this.id_destino = id_destino;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Mensaje> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	@Override
	public String toString() {
		return "Chat [id_chat=" + id_chat + ", id_origen=" + id_origen + ", id_destino=" + id_destino + ", fecha="
				+ fecha + ", status=" + status + ", mensajes=" + mensajes + "]";
	}
	

}
