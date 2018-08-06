package net.thunderfat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.model.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
