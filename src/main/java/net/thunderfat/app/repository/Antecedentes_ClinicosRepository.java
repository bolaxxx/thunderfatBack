package net.thunderfat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Antecedentes_Clinicos;
import net.thunderfat.app.model.Paciente;
@Repository
public interface Antecedentes_ClinicosRepository extends JpaRepository<Antecedentes_Clinicos, Integer> {
List<Antecedentes_Clinicos> findByPaciente(Paciente paciente);
}
