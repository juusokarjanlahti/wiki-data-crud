
package fi.haagahelia.wiki_data_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fi.haagahelia.wiki_data_crud.domain.DropItem;
import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.repository.DropItemRepository;
import fi.haagahelia.wiki_data_crud.repository.DropTableRepository;
import fi.haagahelia.wiki_data_crud.repository.MonsterRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private DropTableRepository dropTableRepository;

    @Autowired
    private DropItemRepository dropItemRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create a few monsters
        Monster orc = new Monster("Orc", "A large, brutish creature.", 10);
        Monster troll = new Monster("Troll", "A large, ugly creature.", 15);
        Monster dragon = new Monster("Dragon", "A large, fire-breathing creature.", 20);

        // Create a few drop tables
        DropTable orcDropTable = new DropTable(orc);
        DropTable trollDropTable = new DropTable(troll);
        DropTable dragonDropTable = new DropTable(dragon);

        // Create a few drop items
        DropItem orcSword = new DropItem("Orc Sword", 1, 0.5, orcDropTable);
        DropItem trollClub = new DropItem("Troll Club", 1, 0.2, trollDropTable);
        DropItem dragonScale = new DropItem("Dragon Scale", 1, 0.3, dragonDropTable);

        // Save the monsters and drop tables
        monsterRepository.save(orc);
        monsterRepository.save(troll);
        monsterRepository.save(dragon);

        dropTableRepository.save(orcDropTable);
        dropTableRepository.save(trollDropTable);
        dropTableRepository.save(dragonDropTable);

        // Save the drop items
        dropItemRepository.save(orcSword);
        dropItemRepository.save(trollClub);
        dropItemRepository.save(dragonScale);
    }
}