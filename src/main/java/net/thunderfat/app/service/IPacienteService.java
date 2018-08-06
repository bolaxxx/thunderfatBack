package net.thunderfat.app.service;

import java.util.List;

import net.thunderfat.app.model.Paciente;



public interface IPacienteService {
	List <Paciente> ListarPaciente();
	void insertar(Paciente paciente);
	Paciente buscarPorId(int id_paciente);
	void eliminar(int id_paciente);
	
	
}
