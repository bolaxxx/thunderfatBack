package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Antecedentes_Clinicos;
@Repository
public interface Antecedentes_ClinicosRepository extends JpaRepository<Antecedentes_Clinicos, Integer> {

}
