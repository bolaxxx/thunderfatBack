package net.thunderfat.app.service;

import java.util.List;

import net.thunderfat.app.model.Receta;

public interface IRecetaService {

	List <Receta> ListarRecetas();
	void insertar(Receta receta);
	Receta buscarPorId(int id_receta);
	void eliminar(int id_receta);
	
}
