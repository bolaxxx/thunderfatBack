package net.thunderfat.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Cita;
import net.thunderfat.app.repository.CitaRepository;

@Service
public class CitaServiceJPA implements ICitaService {
	@Autowired
	private CitaRepository citarepo;

	public List<Cita> ListarCita() {
		List <Cita> citas=citarepo.findAll();
		// TODO Auto-generated method stub
		return citas;
	}

}
