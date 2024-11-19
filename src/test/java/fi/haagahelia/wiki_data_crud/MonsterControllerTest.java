package fi.haagahelia.wiki_data_crud;

import fi.haagahelia.wiki_data_crud.web.MonsterController;
import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.service.MonsterService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MonsterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonsterService monsterService;

    @MockBean
    private MonsterController monsterController;

    @Test
    public void testListAllMonsters() throws Exception {
        // Arrange
        Mockito.when(monsterService.findAll()).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/monsters"))
                .andExpect(status().isOk())
                .andExpect(view().name("monsters"))
                .andExpect(model().attributeExists("monsters"));
    }

    @Test
    public void testGetMonster() throws Exception {
        // Arrange
        Monster monster = new Monster();
        monster.setMonsterId(1L);
        monster.setMonsterName("Dragon");
        monster.setMonsterExamine("A fierce dragon");
        monster.setCombatLevel(100);

        // Act & Assert
        mockMvc.perform(get("/monster").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("monster"))
                .andExpect(model().attributeExists("monster"))
                .andExpect(model().attribute("monster", monster));
    }
}
