package net.thunderfat.app.service;

import java.util.List;

import net.thunderfat.app.model.Medicion_General;
import net.thunderfat.app.model.Paciente;

public interface IMedicion_GeneralService {
	
	void insertar(Medicion_General medicion_general);
	void eliminar(int  id_medicion_general);
	List<Medicion_General>listar();
	List<Medicion_General>listarPorPaciente(Paciente paciente);
	List<Medicion_General>listarPorPacienteFechaReciente(Paciente paciente);
	Medicion_General buscarPorID(int id_medicion_general);
	double buscarUltimopeso(int id_paciente);

}
