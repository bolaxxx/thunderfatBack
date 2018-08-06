 package net.thunderfat.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Antecedente_Tratamiento;
import net.thunderfat.app.repository.Antecedente_TratamientoRepository;

@Service
public class Antecedente_TratamientoServiceJPA implements IAntecedente_TratamientoService{
	@Autowired
	private Antecedente_TratamientoRepository  antecedentesrepo;

	public List<Antecedente_Tratamiento> listarAntecedentes_Tratamiento() {
		List <Antecedente_Tratamiento>lista =antecedentesrepo.findAll();
		return lista;
	}

	public Antecedente_Tratamiento buscarPorId(int id_antecedente_tratamiento) {
		antecedentesrepo.findById(id_antecedente_tratamiento);
		// TODO Auto-generated method stub
		return null;
	}

	public List<Antecedente_Tratamiento> buscarPorIdPaciente() {
		
		// TODO Auto-generated method stub
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
	
	

}
