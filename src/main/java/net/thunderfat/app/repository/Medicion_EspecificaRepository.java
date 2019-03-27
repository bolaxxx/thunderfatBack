package net.thunderfat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Medicion_Especifica;
import net.thunderfat.app.model.Paciente;
@Repository
public interface Medicion_EspecificaRepository extends JpaRepository<Medicion_Especifica, Integer> {
	List<Medicion_Especifica>findByPaciente(Paciente paciente);
}
