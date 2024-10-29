package fi.haagahelia.wiki_data_crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.domain.DropTableRepository;
import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.domain.MonsterRepository;

@SpringBootApplication
public class WikiDataCrudApplication {
	private static final Logger log = LoggerFactory.getLogger(WikiDataCrudApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(WikiDataCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MonsterRepository monsterRepository, DropTableRepository dropTableRepository) {
		return (args) -> {
			log.info("save a couple of monsters");
			Monster chicken = new Monster("Chicken", "Bwak", 3);
			Monster cow = new Monster("Cow", "Moo", 10);
			monsterRepository.save(chicken);
			monsterRepository.save(cow);

			log.info("save a couple of drop tables");
			DropTable chickenDropTable = new DropTable("Feather", 1, 0.5);
			DropTable cowDropTable = new DropTable("Cowhide", 1, 0.5);
			dropTableRepository.save(chickenDropTable);
			dropTableRepository.save(cowDropTable);

			log.info("fetch all monsters");
			for (Monster monster : monsterRepository.findAll()) {
				log.info(monster.toString());
			}
		};
	}
}
