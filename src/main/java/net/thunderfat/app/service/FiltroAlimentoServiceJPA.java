package net.thunderfat.app.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.thunderfat.app.model.Alimento;
import net.thunderfat.app.model.FiltroAlimentario;
import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.repository.FiltroAlimentarioRepository;

@Service
public class FiltroAlimentoServiceJPA implements IFiltroAlimentarioService{
	@Autowired 
	private FiltroAlimentarioRepository filtrorepo;
	@Autowired
	private AlimentoServiceJPA alimentoService;
	private NutricionistaServiceJPA serviceNutricionista;

	@Override
	public List<FiltroAlimentario> listarporNutricionista(Nutricionista nutricionista) {
		
		// TODO Auto-generated method stub
		return filtrorepo.findByNutricionista(nutricionista);
	}

	@Override
	public FiltroAlimentario buscarPorId(int id_filtroalimentario) {
		Optional<FiltroAlimentario>op= filtrorepo.findById(id_filtroalimentario);
		if(op.isPresent())
			return op.get();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(FiltroAlimentario filtroalimentario) {
		// TODO Auto-generated method stub
		filtrorepo.save(filtroalimentario);
	}

	@Override
	public void eliminar(int id_filtroalimentario) {
		// TODO Auto-generated method stub
		filtrorepo.deleteById(id_filtroalimentario);
		
	}

	@Override
	public List<FiltroAlimentario> listarTodos() {
		// TODO Auto-generated method stub
		return filtrorepo.findAll();
	}

	@Override
	public ArrayList<Map> alimentosEnFiltro(int id_filtro) {
		FiltroAlimentario filtro =buscarPorId(id_filtro);
		ArrayList<Map> result = new ArrayList(); 
		for(int i =0;i<filtro.getAlimentos().size();i++) {
			Map<String, Object> temp = new LinkedHashMap<String, Object>();
			temp.put("id", filtro.getAlimentos().get(i).getId_alimento());
			temp.put("text", filtro.getAlimentos().get(i).getNombre());
			result.add(temp);
		 }
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int InsetarAjax(Map filtrojson) {

		System.out.println(filtrojson);
		String nombre = (String) filtrojson.get("nombre");
		System.out.println(filtrojson.get("alimentos"));
		String alimentoString=filtrojson.get("alimentos").toString();
		System.out.println(alimentoString);
		String[] items = alimentoString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").replaceAll(" ", "").split(",");

		int[] results = new int[items.length];

		for (int i = 0; i < items.length; i++) {
		    try {
		        results[i] = Integer.parseInt(items[i]);
		    } catch (NumberFormatException nfe) {
		        //NOTE: write something here if you need to recover from formatting errors
		    };
		}
		ArrayList<Alimento> listasAlimentos = new ArrayList <Alimento>();
		for (int j=0;j<results.length;j++) {
			System.out.println(results[j]+"resultado en int ");
			listasAlimentos.add(alimentoService.buscarPorId(results[j]));
		}
		FiltroAlimentario filtroAlimentario = new FiltroAlimentario();
		filtroAlimentario.setAlimentos(listasAlimentos);
		filtroAlimentario.setNombre(nombre);
		filtroAlimentario.setNutricionista(serviceNutricionista.buscarPorId((int)filtrojson.get("id_nutricionista")));
		if(filtrojson.containsKey("id_filtro")==true) {
			filtroAlimentario.setId_filtroalimentario((int)filtrojson.get("id_filtro"));
		}
		filtrorepo.save(filtroAlimentario);
		return filtroAlimentario.getId_filtroalimentario();
		
	}

}
