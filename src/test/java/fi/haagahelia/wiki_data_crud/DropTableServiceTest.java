package fi.haagahelia.wiki_data_crud;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.repository.DropTableRepository;
import fi.haagahelia.wiki_data_crud.service.DropTableService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DropTableServiceTest {

    @Autowired
    private DropTableService dropTableService;

    @MockBean
    private DropTableRepository dropTableRepository;

    @Test
    public void testGetAllDropTables() {
        Mockito.when(dropTableRepository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(dropTableService.getAllDropTables().isEmpty());
    }

    @Test
    public void testGetDropTableById() {
        DropTable dropTable = new DropTable();
        Mockito.when(dropTableRepository.findById(1L)).thenReturn(Optional.of(dropTable));

        assertNotNull(dropTableService.getDropTableById(1L));
    }

    // Add more tests for other methods
}