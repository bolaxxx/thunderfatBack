/**
 * 
 */
package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Mensaje;

/**
 * @author sergio
 *
 */

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {

}
