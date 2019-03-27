package net.thunderfat.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Medicion_Especifica;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.repository.Medicion_EspecificaRepository;

@Service
public class Medicion_EspecificaServiceJPA implements IMedicion_EspecificaService {
@Autowired 
Medicion_EspecificaRepository repo;
	@Override
	public void insertar(Medicion_Especifica medicion) {
		// TODO Auto-generated method stub
		repo.save(medicion);
	}

	@Override
	public void eliminar(int id_medicion_espeficica) {
		repo.deleteById(id_medicion_espeficica);
		
	}

	@Override
	public Medicion_Especifica buscarPorId(int id_medicion_especifica) {
		Optional<Medicion_Especifica>op=repo.findById(id_medicion_especifica);
		if(op.isPresent())
			return op.get();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicion_Especifica> buscarPorPaciente(Paciente paciente) {
	List<Medicion_Especifica>lista =repo.findByPaciente(paciente);
	
		return lista;
	}

}
