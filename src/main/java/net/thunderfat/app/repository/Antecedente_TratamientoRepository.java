package net.thunderfat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Antecedente_Tratamiento;
import net.thunderfat.app.model.Paciente;
@Repository
public interface Antecedente_TratamientoRepository extends JpaRepository<Antecedente_Tratamiento, Integer> {
	List <Antecedente_Tratamiento> findByPaciente(Paciente paciente);
}
