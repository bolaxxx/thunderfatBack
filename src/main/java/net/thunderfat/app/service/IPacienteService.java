package net.thunderfat.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.thunderfat.app.model.Paciente;



public interface IPacienteService {
	List <Paciente> ListarPaciente();
	void insertar(Paciente paciente);
	Paciente buscarPorId(int id_paciente);
	void eliminar(int id_paciente);
	List<Paciente> listarPacienteNutrcionista(int id_nutricionista);
	ArrayList<Map>listarPacienteNutricionistaSelect(int id_nutricionista); 
	
}
