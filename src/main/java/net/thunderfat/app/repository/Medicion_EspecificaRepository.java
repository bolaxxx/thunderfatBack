package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Medicion_Especifica;
@Repository
public interface Medicion_EspecificaRepository extends JpaRepository<Medicion_Especifica, Integer> {

}
