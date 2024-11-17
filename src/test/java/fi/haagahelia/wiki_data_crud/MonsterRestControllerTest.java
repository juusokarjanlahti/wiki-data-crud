package fi.haagahelia.wiki_data_crud;

import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fi.haagahelia.wiki_data_crud.dto.MonsterRestDTO;
import fi.haagahelia.wiki_data_crud.service.MonsterRestService;
import fi.haagahelia.wiki_data_crud.web.MonsterRestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class MonsterRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonsterRestService monsterRestService;

    @MockBean
    MonsterRestController monsterRestController;

    @BeforeEach
    public void setup() {
        // Set the mock MonsterRestService object to the field
        this.monsterRestService = Mockito.mock(MonsterRestService.class);
    }

    @Test
    void testGetAllMonsters_ReturnsListOfMonsters() throws Exception {
        MonsterRestDTO monster = new MonsterRestDTO();
        monster.setMonsterName("Goblin");
        monster.setCombatLevel(5);

        when(monsterRestService.getAllMonsters()).thenReturn(Collections.singletonList(monster));

        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].monsterName").value("Goblin"))
                .andExpect(jsonPath("$[0].combatLevel").value(5));
    }
}