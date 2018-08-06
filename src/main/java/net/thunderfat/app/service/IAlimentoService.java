package net.thunderfat.app.service;

import java.util.List;

import net.thunderfat.app.model.Alimento;

public interface IAlimentoService {
	List <Alimento> ListarAlimentos();
	void insertar(Alimento alimento);
	Alimento buscarPorId(int id_alimento);
	void eliminar(int id_alimento);

}
