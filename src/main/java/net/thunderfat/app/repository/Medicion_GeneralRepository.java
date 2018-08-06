package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Medicion_General;
@Repository
public interface Medicion_GeneralRepository extends JpaRepository<Medicion_General, Integer> {

}
