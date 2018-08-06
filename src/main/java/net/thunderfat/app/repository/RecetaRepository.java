package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Receta;
@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer> {

}
