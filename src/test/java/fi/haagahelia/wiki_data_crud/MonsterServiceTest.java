package fi.haagahelia.wiki_data_crud;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.repository.MonsterRepository;
import fi.haagahelia.wiki_data_crud.service.MonsterService;

public class MonsterServiceTest {
    @ExtendWith(MockitoExtension.class)
    @Mock
    private MonsterRepository monsterRepository;

    @InjectMocks
    private MonsterService monsterService;

    @Test
    void testFindMonsterById_ReturnsMonster() {
        // Arrange
        Monster monster = new Monster();
        monster.setMonsterId(1L);
        monster.setMonsterName("Goblin");
        when(monsterRepository.findById(1L)).thenReturn(Optional.of(monster));
    }
}
