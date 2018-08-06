package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Cita;
@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

}
