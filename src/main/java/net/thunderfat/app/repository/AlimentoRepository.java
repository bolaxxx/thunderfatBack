package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Alimento;
@Repository 
public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {
			
}
