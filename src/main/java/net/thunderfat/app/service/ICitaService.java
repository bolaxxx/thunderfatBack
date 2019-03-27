package net.thunderfat.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.thunderfat.app.model.Cita;
import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.model.Paciente;

public interface ICitaService {
	List <Cita> ListarCita();
	List<Cita>	ListarPorPaciente(Paciente paciente);
	List<Cita>  ListarPorNutricionista(Nutricionista nutricionista);
	void insertar(Cita cita);
	void eliminar(int id_cita);
	Cita buscarPorID(int id_cita);
	ArrayList<Map> ListarPorPacienteEntreFechas(Nutricionista nutricionista,LocalDate start,LocalDate end);
}
