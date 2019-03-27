package net.thunderfat.app.service;

import java.util.List;

import net.thunderfat.app.model.Medicion_Segmental;
import net.thunderfat.app.model.Paciente;

public interface IMedicion_SegmentalService {
void eliminar(int id_medicion_segmental);
void insertar(Medicion_Segmental medicion);
Medicion_Segmental buscarPorId(int id_medicion_segmental);
List<Medicion_Segmental> buscarPorPaciente(Paciente paciente);
}
