package net.thunderfat.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.repository.NutricionistaRepository;

@Service
public class NutricionistaServiceJPA implements INutricionistaService {
	@Autowired
	private NutricionistaRepository repoNutricionista;

	public List<Nutricionista> listarNutricionista() {
		// TODO Auto-generated method stub
		return null;
	}

	public Nutricionista buscarPorId(int id_nutricionista) {
		Optional<Nutricionista>op=repoNutricionista.findById(id_nutricionista);
		// TODO Auto-generated method stub
		if(op.isPresent())
			return op.get();
		return null;
	}

	public void eliminar(Nutricionista nutricionista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> buscarProvincias() {
		List <String>provincias= repoNutricionista.findDistinctProvincia();
		return provincias;
	}

	@Override
	public List<String> buscarLocalidadesporProvincia(String provincia) {
		List<String>localidades=repoNutricionista.findDistinctLocalidadByProvincia(provincia);
		return localidades;
	}

	@Override
	public List<Nutricionista> listarNutricionistaporlocalidad(String localidad) {
		List<Nutricionista>nutricionistas=repoNutricionista.findByLocalidad(localidad);
		return nutricionistas;
	}
	

}
