package net.thunderfat.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Receta;
import net.thunderfat.app.repository.RecetaRepository;
@Service
public class RecetaServiceJPA implements IRecetaService {
	@Autowired
	private RecetaRepository recetarepo;
	
	public List<Receta> ListarRecetas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertar(Receta receta) {
		recetarepo.save(receta);
		// TODO Auto-generated method stub
		
	}

	public Receta buscarPorId(int id_receta) {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminar(int id_receta) {
		// TODO Auto-generated method stub
		
	}

}
