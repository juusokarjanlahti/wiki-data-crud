package fi.haagahelia.wiki_data_crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.domain.MonsterRepository;
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
            itemRepository.save(item1);
            itemRepository.save(item2);
            itemRepository.save(item3);

            // Create monster
            Monster dragon = new Monster("Dragon", "A fierce dragon", 100);

            // Create drop table for the monster
            DropTable dragonDropTable = new DropTable("Dragon's Hoard");

            // Link the drop table to the monster (One-to-One)
            dragon.setDropTable(dragonDropTable);
            dragonDropTable.setMonster(dragon);

            // Save both entities (cascade will handle saving dropTable)
            monsterRepository.save(dragon);

            // Create drop entries for the drop table
            DropEntry dropEntry1 = new DropEntry(dragonDropTable, item1, 100, 0.5);
            DropEntry dropEntry2 = new DropEntry(dragonDropTable, item2, 1, 0.1);
            DropEntry dropEntry3 = new DropEntry(dragonDropTable, item3, 1, 0.2);

            dropEntryRepository.save(dropEntry1);
            dropEntryRepository.save(dropEntry2);
            dropEntryRepository.save(dropEntry3);

            // Create additional items
            Item item4 = new Item("Silver Coin", 50, true);
            Item item5 = new Item("Magic Scroll", 1, false);
            Item item6 = new Item("Mana Potion", 1, false);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);

            // Create second monster
            Monster goblin = new Monster("Goblin", "A sneaky goblin", 20);

            // Create drop table for the second monster
            DropTable goblinDropTable = new DropTable("Goblin's Loot");

            // Link the drop table to the monster (One-to-One)
            goblin.setDropTable(goblinDropTable);
            goblinDropTable.setMonster(goblin);

            // Save both entities (cascade will handle saving dropTable)
            monsterRepository.save(goblin);

            // Create drop entries for the drop table
            DropEntry dropEntry4 = new DropEntry(goblinDropTable, item4, 50, 0.6);
            DropEntry dropEntry5 = new DropEntry(goblinDropTable, item5, 1, 0.05);
            DropEntry dropEntry6 = new DropEntry(goblinDropTable, item6, 1, 0.3);

            dropEntryRepository.save(dropEntry4);
            dropEntryRepository.save(dropEntry5);
            dropEntryRepository.save(dropEntry6);
        };
    }
}