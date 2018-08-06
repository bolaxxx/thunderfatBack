/**
 * 
 */
package net.thunderfat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.thunderfat.app.model.Chat;

/**
 * @author sergio
 *
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

}
