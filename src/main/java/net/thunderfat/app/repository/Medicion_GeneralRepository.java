package net.thunderfat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Medicion_General;
import net.thunderfat.app.model.Paciente;
@Repository
public interface Medicion_GeneralRepository extends JpaRepository<Medicion_General, Integer> {
	 List<Medicion_General> findByPacienteOrderByFechaAsc(Paciente paciente);
	 List<Medicion_General>findByPacienteOrderByFechaDesc(Paciente paciente);
	 @Query(value="SELECT peso_actual FROM medicion_general WHERE fecha IN ( SELECT MAX( fecha ) FROM medicion_general WHERE id_paciente =?1 GROUP BY id_medicion_general ) ORDER BY fecha DESC LIMIT 1",nativeQuery=true)
	 double ultimoPeso(int id_paciente);
}
