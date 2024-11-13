package fi.haagahelia.wiki_data_crud;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.service.DropTableService;
import fi.haagahelia.wiki_data_crud.web.DropTableController;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DropTableController.class)
public class DropTableControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DropTableService dropTableService;

    @Test
    public void testGetAllDropTables() throws Exception {
        Mockito.when(dropTableService.getAllDropTables()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/dropTables"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetDropTableById() throws Exception {
        DropTable dropTable = new DropTable();
        Mockito.when(dropTableService.getDropTableById(1L)).thenReturn(dropTable);

        mockMvc.perform(get("/dropTables/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dropTableId").value(dropTable.getDropTableId()));
    }

    @Test
    public void testCreateDropTable() throws Exception {
        DropTable dropTable = new DropTable();
        Mockito.when(dropTableService.createDropTable(Mockito.any(DropTable.class))).thenReturn(dropTable);

        mockMvc.perform(post("/dropTables")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"monsters\":[], \"items\":[]}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dropTableId").value(dropTable.getDropTableId()));
    }

    @Test
    public void testUpdateDropTable() throws Exception {
        DropTable dropTable = new DropTable();
        Mockito.when(dropTableService.updateDropTable(Mockito.anyLong(), Mockito.any(DropTable.class))).thenReturn(dropTable);

        mockMvc.perform(put("/dropTables/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"monsters\":[], \"items\":[]}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dropTableId").value(dropTable.getDropTableId()));
    }

    @Test
    public void testDeleteDropTable() throws Exception {
        Mockito.when(dropTableService.deleteDropTable(1L)).thenReturn(true);

        mockMvc.perform(delete("/dropTables/1"))
                .andExpect(status().isNoContent());
    }
}