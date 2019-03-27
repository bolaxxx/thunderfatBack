package net.thunderfat.app.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Cita;
import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.repository.CitaRepository;

@Service
public class CitaServiceJPA implements ICitaService {
	@Autowired
	private CitaRepository citarepo;

	public List<Cita> ListarCita() {
		List <Cita> citas=citarepo.findAll();
		// TODO Auto-generated method stub
		return citas;
	}

	@Override
	public List<Cita> ListarPorPaciente(Paciente paciente) {
		citarepo.findByPaciente(paciente);
		// TODO Auto-generated method stub
		return citarepo.findByPaciente(paciente);
	}

	@Override
	public List<Cita> ListarPorNutricionista(Nutricionista nutricionista) {
		
		return citarepo.findByNutricionista(nutricionista);
	}

	@Override
	public void insertar(Cita cita) {
		citarepo.save(cita);
		
	}

	

	@Override
	public Cita buscarPorID(int id_cita) {
		Optional<Cita>op=citarepo.findById(id_cita);
		if(op.isPresent())
			return op.get();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id_cita) {
		// TODO Auto-generated method stub
		citarepo.deleteById(id_cita);
	}

	@Override
	public ArrayList<Map> ListarPorPacienteEntreFechas(Nutricionista nutricionista, LocalDate start, LocalDate end) {
		// TODO Auto-generated method stub
		List<Cita>citas=citarepo.encontrarCitasNutricionistaFechas(nutricionista.getId_usuario(), start, end);
		ArrayList<Map> result = new ArrayList();
		for (int i = 0; i < citas.size(); i++) {
			/*
			 * "id": 293, "title": "Event 1", "url": "http://example.com", "class":
			 * "event-important", "start": 12039485678000, // Milliseconds "end":
			 * 1234576967000 // Milliseconds
			 */
			Map<String, Object> temp = new LinkedHashMap<String, Object>();
			temp.put("id", citas.get(i).getId_cita());
			temp.put("title", citas.get(i).getPaciente().getNombre() + ' ' + citas.get(i).getPaciente().getApellidos());
			//temp.put("url", "/thunderfat/alimento/index");
			// temp.put("class", "event-important");
			temp.put("start", citas.get(i).getFecha_ini().format(DateTimeFormatter.ISO_DATE_TIME));
			temp.put("end", citas.get(i).getFecha_fin().format(DateTimeFormatter.ISO_DATE_TIME));
			result.add(temp);
		}
		// respuesta.put("success", 1);
		// respuesta.put("result",result);
		System.out.println(result);
		return result;
		//return lista;
	}

}
