package net.thunderfat.app.service;

import java.util.List;

import net.thunderfat.app.model.Antecedentes_Clinicos;
import net.thunderfat.app.model.Paciente;

public interface IAntecedente_ClinicoService {
	
	
	List<Antecedentes_Clinicos>listarAntecedentes();
	void insertar(Antecedentes_Clinicos antecedente);

	void eliminar(int id_antecedente);
	Antecedentes_Clinicos buscarPorID(int id_antecedente);
	List<Antecedentes_Clinicos> listarAntecedenteporPaciente(Paciente paciente);

}
