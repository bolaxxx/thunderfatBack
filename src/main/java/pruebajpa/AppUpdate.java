package pruebajpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.thunderfat.app.model.Alimento;
import net.thunderfat.app.repository.AlimentoRepository;

public class AppUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		AlimentoRepository repo = context.getBean("alimentoRepository",AlimentoRepository.class);
		
		Optional<Alimento>alimento=repo.findById(1); 
		if(alimento.isPresent()) {
		System.out.println(alimento.get());
		Alimento temp	=alimento.get();
		temp.setH2o(2.2);
		repo.save(temp);
		}
		context.close();
	}

}
