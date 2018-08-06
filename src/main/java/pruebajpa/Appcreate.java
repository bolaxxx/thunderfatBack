package pruebajpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.thunderfat.app.model.Alimento;
import net.thunderfat.app.repository.AlimentoRepository;

public class Appcreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alimento alimento  = new Alimento ();
		alimento.setNombre("queso de bola");
		alimento.setEstado("curado");
		alimento.setCal(150);
		alimento.setProteinas(0.52);
		alimento.setH2o(132132);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		AlimentoRepository repo = context.getBean("alimentoRepository",AlimentoRepository.class);
		repo.save(alimento);
		context.close();

	}

}
