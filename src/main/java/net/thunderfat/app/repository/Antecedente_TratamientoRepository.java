package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Antecedente_Tratamiento;
@Repository
public interface Antecedente_TratamientoRepository extends JpaRepository<Antecedente_Tratamiento, Integer> {

}
