package net.thunderfat.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.repository.PacienteRepository;

@Service
public class PacienteServiceJPA implements IPacienteService{
	@Autowired
	private PacienteRepository repo;

	public List<Paciente> ListarPaciente() {
		List <Paciente>pacientes=repo.findAll();
		// TODO Auto-generated method stub
		return pacientes;
	}

	public void insertar(Paciente paciente) {
		repo.save(paciente);// TODO Auto-generated method stub
		
	}

	public Paciente buscarPorId(int id_paciente) {
		Optional<Paciente> optional = repo.findById(id_paciente);
		if (optional.isPresent())
			return optional.get();
		return null;
	
	}

	public void eliminar(int id_paciente) {
		repo.deleteById(id_paciente);
		
	}

	







	
 

}
