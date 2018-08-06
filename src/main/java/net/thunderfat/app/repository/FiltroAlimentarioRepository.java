package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.FiltroAlimentario;
@Repository
public interface FiltroAlimentarioRepository extends JpaRepository<FiltroAlimentario, Integer> {

}
