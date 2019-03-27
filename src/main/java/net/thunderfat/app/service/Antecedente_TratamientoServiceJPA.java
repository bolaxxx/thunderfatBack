 package net.thunderfat.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Antecedente_Tratamiento;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.repository.Antecedente_TratamientoRepository;
import net.thunderfat.app.repository.PacienteRepository;

@Service
public class Antecedente_TratamientoServiceJPA implements IAntecedente_TratamientoService{
	@Autowired
	private Antecedente_TratamientoRepository  antecedentesrepo;
	@Autowired
	private PacienteRepository pacienterepo;

	public List<Antecedente_Tratamiento> listarAntecedentes_Tratamiento() {
		List <Antecedente_Tratamiento>lista =antecedentesrepo.findAll();
		return lista;
	}

	public Antecedente_Tratamiento buscarPorId(int id_antecedente_tratamiento) {
		Optional<Antecedente_Tratamiento> op=antecedentesrepo.findById(id_antecedente_tratamiento);
		if(op.isPresent())
			return op.get();
		else
		return null;
	}

	
	public void insertar(Antecedente_Tratamiento antecedente_tratamiento) {
		antecedentesrepo.save(antecedente_tratamiento);
		// TODO Auto-generated method stub
		
	}

	public void eliminar(int id_antecedente_tratamiento) {
		// TODO Auto-generated method stub
		antecedentesrepo.deleteById(id_antecedente_tratamiento);
	}

	@Override
	public List<Antecedente_Tratamiento> buscarPorPaciente(int id_paciente) {
		Optional <Paciente> op= pacienterepo.findById(id_paciente);
		if(op.isPresent()) {
		
			List<Antecedente_Tratamiento> lista =antecedentesrepo.findByPaciente(op.get());
			return lista;
		}else// TODO Auto-generated method stub
		return null;
	}
	
	

}
