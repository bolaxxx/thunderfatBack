package net.thunderfat.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Alimento;
import net.thunderfat.app.repository.AlimentoRepository;

@Service
public class AlimentoServiceJPA implements IAlimentoService {
	@Autowired
	private AlimentoRepository alimentorepo;
	
	public List<Alimento> ListarAlimentos() {
		// TODO Auto-generated method stub
		List<Alimento>alimentos=alimentorepo.findAll();
		return alimentos;
	}

	public void insertar(Alimento alimento) {
		// TODO Auto-generated method stub
		alimentorepo.save(alimento);
		
	}

	public Alimento buscarPorId(int id_alimento) {

		Optional<Alimento> optional = alimentorepo.findById(id_alimento);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public void eliminar(int id_alimento) {
		alimentorepo.deleteById(id_alimento);
		// TODO Auto-generated method stub
		
	}

}
