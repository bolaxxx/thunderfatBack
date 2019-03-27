package net.thunderfat.app.service;

import java.util.List;

import net.thunderfat.app.model.Medicion_Especifica;
import net.thunderfat.app.model.Paciente;

public interface IMedicion_EspecificaService {
	void insertar(Medicion_Especifica medicion );
	void eliminar(int id_medicion_espeficica);
	Medicion_Especifica buscarPorId(int id_medicion_especifica);
	List<Medicion_Especifica > buscarPorPaciente(Paciente paciente);
	
}
