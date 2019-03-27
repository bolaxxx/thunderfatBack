package net.thunderfat.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Medicion_Segmental;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.repository.Medicion_SegmentalRepository;

@Service
public class Medicion_SegmentalServiceJPA implements IMedicion_SegmentalService{
@Autowired
private Medicion_SegmentalRepository repo;
	@Override
	public void eliminar(int id_medicion_segmental) {
		repo.deleteById(id_medicion_segmental);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertar(Medicion_Segmental medicion) {
		// TODO Auto-generated method stub
		repo.save(medicion);
		
	}

	@Override
	public Medicion_Segmental buscarPorId(int id_medicion_segmental) {
		Optional<Medicion_Segmental>op=repo.findById(id_medicion_segmental);
		// TODO Auto-generated method stub
		if(op.isPresent())
			return op.get();
		return null;
	}

	@Override
	public List<Medicion_Segmental> buscarPorPaciente(Paciente paciente) {
		//repo.findByPaciente(paciente);
		// TODO Auto-generated method stub
		return repo.findByPaciente(paciente);
	}

}
