package net.thunderfat.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Medicion_General;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.repository.Medicion_GeneralRepository;

@Service
public class Medicion_GeneralServiceJPA implements IMedicion_GeneralService{
@Autowired
private Medicion_GeneralRepository repo;

	@Override
	public void insertar(Medicion_General medicion_general) {
		repo.save(medicion_general);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id_medicion_general) {
		repo.deleteById(id_medicion_general);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Medicion_General> listar() {
		// TODO Auto-generated method stub
		List<Medicion_General> lista=repo.findAll();
		return lista;
	}

	@Override
	public List<Medicion_General> listarPorPaciente(Paciente paciente) {
		List<Medicion_General>	lista=repo.findByPacienteOrderByFechaAsc(paciente);
		
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Medicion_General buscarPorID(int id_medicion_general) {
		Optional<Medicion_General> op=repo.findById(id_medicion_general);
		if(op.isPresent())
			return op.get();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicion_General> listarPorPacienteFechaReciente(Paciente paciente) {
		List<Medicion_General>lista =repo.findByPacienteOrderByFechaDesc(paciente);
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public double buscarUltimopeso(int id_paciente) {
		
		return repo.ultimoPeso(id_paciente);
	}

}
