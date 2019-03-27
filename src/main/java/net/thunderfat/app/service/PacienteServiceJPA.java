package net.thunderfat.app.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.repository.NutricionistaRepository;
import net.thunderfat.app.repository.PacienteRepository;

@Service
public class PacienteServiceJPA implements IPacienteService{
	@Autowired
	private PacienteRepository repo;
	@Autowired
	private NutricionistaRepository nutrirepo;

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

	public List<Paciente> listarporNutricionista(int id_nutricionista) {
	Optional<Nutricionista> nutricionista=	 nutrirepo.findById(id_nutricionista);
		 List<Paciente> pacientes= repo.buscarporNutricionista(nutricionista.get());
		 return pacientes;
	}

	@Override
	public List<Paciente> listarPacienteNutrcionista(int id_nutricionista) {
		Optional <Nutricionista>op=nutrirepo.findById(id_nutricionista);
			if(op.isPresent()) {
				Nutricionista nutri =op.get();
				//System.out.println(nutri);
				List <Paciente> pacientes= repo.findByNutricionista(nutri);
				//System.out.println(pacientes);
				return pacientes;
				}
		return null;
	}

	@Override
	public ArrayList<Map> listarPacienteNutricionistaSelect(int id_nutricionista) {
		// TODO Auto-generated method stub
		List<Paciente>lista=repo.buscarporNutricionista(nutrirepo.findById(id_nutricionista).get());
		ArrayList<Map> result = new ArrayList();
		for (int i = 0; i < lista.size(); i++) {
			/*
			 * "id": 293, "title": "Event 1", "url": "http://example.com", "class":
			 * "event-important", "start": 12039485678000, // Milliseconds "end":
			 * 1234576967000 // Milliseconds
			 */
			Map<String, Object> temp = new LinkedHashMap<String, Object>();
			temp.put("id", lista.get(i).getId_usuario());
			//temp.put("title", citas.get(i).getPaciente().getNombre() + ' ' + citas.get(i).getPaciente().getApellidos());
			//temp.put("url", "/thunderfat/alimento/index");
			// temp.put("class", "event-important");
			//temp.put("start", citas.get(i).getFecha_ini().format(DateTimeFormatter.ISO_DATE_TIME));
			temp.put("text",lista.get(i).getNombre()+" "+lista.get(i).getApellidos()+" "+lista.get(i).getDni());
			result.add(temp);
		}
		// respuesta.put("success", 1);
		// respuesta.put("result",result);
		System.out.println(result);
		return result;
		
	}

	







	
 

}
