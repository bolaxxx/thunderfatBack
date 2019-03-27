package net.thunderfat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Medicion_Especifica;
import net.thunderfat.app.model.Medicion_Segmental;
import net.thunderfat.app.model.Paciente;
@Repository
public interface Medicion_SegmentalRepository extends JpaRepository<Medicion_Segmental, Integer> {
	List<Medicion_Segmental>findByPaciente(Paciente paciente);
}
