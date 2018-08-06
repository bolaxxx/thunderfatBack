package pruebajpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.thunderfat.app.model.Alimento;
import net.thunderfat.app.repository.AlimentoRepository;

public class AppRead {
	// TODO Auto-generated method stub
	public static void main(String[] args) {
	//Alimento alimento  = new Alimento ();

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
	AlimentoRepository repo = context.getBean("alimentoRepository",AlimentoRepository.class);
	
	Optional<Alimento>alimento=repo.findById(1); 
	System.out.println(alimento.get());
	context.close();

}
}
