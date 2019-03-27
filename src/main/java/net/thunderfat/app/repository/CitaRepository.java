package net.thunderfat.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Cita;
import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.model.Paciente;
@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
	List<Cita> findByPaciente(Paciente paciente);
	List<Cita> findByNutricionista(Nutricionista nutricionista);
	@Query(value="select * from cita WHERE id_nutricionista=?1 AND fecha_ini BETWEEN ?2 AND ?3",nativeQuery=true)
	List<Cita> encontrarCitasNutricionistaFechas(int id_nutricionista,LocalDate start,LocalDate end);

}
