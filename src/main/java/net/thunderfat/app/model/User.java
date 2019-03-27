package net.thunderfat.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name="usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_usuario;
	private String email;
	private String psw;
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime createtime	;
	
	public User() {
		super();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public LocalDateTime getCreatetime() {
		return createtime;
	}

	public void setCreatetime(LocalDateTime createtime) {
		this.createtime = createtime;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", psw=" + psw + ", createtime=" + createtime + ", id_usuario=" + id_usuario
				+ "]";
	}

}