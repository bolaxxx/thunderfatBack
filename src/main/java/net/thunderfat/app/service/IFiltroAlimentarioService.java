package net.thunderfat.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.thunderfat.app.model.FiltroAlimentario;
import net.thunderfat.app.model.Nutricionista;

public interface IFiltroAlimentarioService {
	
	List<FiltroAlimentario> listarporNutricionista(Nutricionista nutricionista);
	FiltroAlimentario buscarPorId(int id_filtroalimentario);
	void insertar(FiltroAlimentario filtroalimentario);
	void eliminar(int id_filtroalimentario);
	List<FiltroAlimentario> listarTodos();
	ArrayList<Map> alimentosEnFiltro(int id_filtro);
	int InsetarAjax(Map filtrojson);

}
