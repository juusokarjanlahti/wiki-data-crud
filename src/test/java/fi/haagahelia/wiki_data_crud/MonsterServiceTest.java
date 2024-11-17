package fi.haagahelia.wiki_data_crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

        // Act
        Optional<Monster> result = monsterService.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Goblin", result.get().getMonsterName());
        verify(monsterRepository, times(1)).findById(1L);
    }
}
