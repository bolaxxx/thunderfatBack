package net.thunderfat.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Antecedentes_Clinicos;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.repository.Antecedentes_ClinicosRepository;
import net.thunderfat.app.repository.PacienteRepository;

@Service
public class Antecedente_ClinicosServiceJPA implements IAntecedente_ClinicoService{
@Autowired
private Antecedentes_ClinicosRepository repo;

	@Override
	public List<Antecedentes_Clinicos> listarAntecedentes() {
		List<Antecedentes_Clinicos>lista =repo.findAll();
		return lista;
	}

	@Override
	public void insertar(Antecedentes_Clinicos antecedente) {
		repo.save(antecedente);
		
	}

	@Override
	public List<Antecedentes_Clinicos> listarAntecedenteporPaciente(Paciente paciente) {
		
			List <Antecedentes_Clinicos>lista=repo.findByPaciente(paciente);
			return lista;
		
	}

	@Override 
	public void eliminar(int id_antecedente) {
		repo.deleteById(id_antecedente);
		
	}

	@Override
	public Antecedentes_Clinicos buscarPorID(int id_antecedente) {
		Optional <Antecedentes_Clinicos>option =repo.findById(id_antecedente);
		if(option.isPresent())
			return option.get();
		else
		// TODO Auto-generated method stub
		return null;
	}

}
