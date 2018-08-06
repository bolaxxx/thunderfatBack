package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Medicion_Segmental;
@Repository
public interface Medicion_SegmentalRepository extends JpaRepository<Medicion_Segmental, Integer> {

}
