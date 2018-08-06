package net.thunderfat.app.service;

import java.util.List;

import net.thunderfat.app.model.Antecedente_Tratamiento;

public interface IAntecedente_TratamientoService {
	List<Antecedente_Tratamiento>listarAntecedentes_Tratamiento();
	Antecedente_Tratamiento buscarPorId(int id_antecedente_tratamiento);
	List<Antecedente_Tratamiento> buscarPorIdPaciente();
	void insertar(Antecedente_Tratamiento antecedente_tratamiento);
	void eliminar(int id_antecedente_tratamiento);

}
