package net.thunderfat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.FiltroAlimentario;
import net.thunderfat.app.model.Nutricionista;
@Repository
public interface FiltroAlimentarioRepository extends JpaRepository<FiltroAlimentario, Integer> {
		List<FiltroAlimentario> findByNutricionista(Nutricionista nutricionista);
}
