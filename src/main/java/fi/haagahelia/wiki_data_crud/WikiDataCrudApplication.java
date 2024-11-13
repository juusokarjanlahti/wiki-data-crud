package fi.haagahelia.wiki_data_crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.domain.MonsterRepository;
import jakarta.transaction.Transactional;
import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.domain.DropTableRepository;
import fi.haagahelia.wiki_data_crud.domain.DropEntry;
import fi.haagahelia.wiki_data_crud.domain.DropEntryRepository;
import fi.haagahelia.wiki_data_crud.domain.Item;
import fi.haagahelia.wiki_data_crud.domain.ItemRepository;

@SpringBootApplication
public class WikiDataCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikiDataCrudApplication.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner demo(MonsterRepository monsterRepository, DropTableRepository dropTableRepository, DropEntryRepository dropEntryRepository, ItemRepository itemRepository) {
        return (args) -> {
            // Create items
            Item item1 = new Item("Gold Coin", 100, true);
            Item item2 = new Item("Dragon Scale", 1, false);
            Item item3 = new Item("Health Potion", 1, false);
            Item item4 = new Item("Silver Coin", 50, true);
            Item item5 = new Item("Magic Scroll", 1, false);
            Item item6 = new Item("Mana Potion", 1, false);
            itemRepository.save(item1);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);

            // Create first monster
            Monster monster1 = new Monster("Dragon", "A fierce dragon", 100);
            monsterRepository.save(monster1);

            // Create drop table for first monster
            DropTable dropTable1 = new DropTable("Dragon's Hoard");
            dropTable1.setMonster(monster1);
            dropTableRepository.save(dropTable1);

            // Update monster with drop table
            monster1.setDropTable(dropTable1);
            monsterRepository.save(monster1);

            // Create drop entries for first monster
            DropEntry dropEntry1_1 = new DropEntry(dropTable1, item1, 100, 0.5);
            DropEntry dropEntry1_2 = new DropEntry(dropTable1, item2, 1, 0.1);
            DropEntry dropEntry1_3 = new DropEntry(dropTable1, item3, 1, 0.2);
            dropEntryRepository.save(dropEntry1_1);
            dropEntryRepository.save(dropEntry1_2);
            dropEntryRepository.save(dropEntry1_3);


            dropTableRepository.save(dropTable1);

            // Create second monster
            Monster monster2 = new Monster("Goblin", "A sneaky goblin", 20);
            monsterRepository.save(monster2);

            // Create drop table for second monster
            DropTable dropTable2 = new DropTable("Goblin's Loot");
            dropTable2.setMonster(monster2);
            dropTableRepository.save(dropTable2);

            // Update monster with drop table
            monster2.setDropTable(dropTable2);
            monsterRepository.save(monster2);

            // Create drop entries for second monster
            DropEntry dropEntry2_1 = new DropEntry(dropTable2, item4, 50, 0.6);
            DropEntry dropEntry2_2 = new DropEntry(dropTable2, item5, 1, 0.05);
            DropEntry dropEntry2_3 = new DropEntry(dropTable2, item6, 1, 0.3);
            dropEntryRepository.save(dropEntry2_1);
            dropEntryRepository.save(dropEntry2_2);
            dropEntryRepository.save(dropEntry2_3);

            dropTableRepository.save(dropTable2);
        };
    }
}