package fi.haagahelia.wiki_data_crud;

import fi.haagahelia.wiki_data_crud.domain.DropItem;
import fi.haagahelia.wiki_data_crud.service.DropItemService;
import fi.haagahelia.wiki_data_crud.web.DropItemController;

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

@WebMvcTest(DropItemController.class)
public class DropItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DropItemService dropItemService;

    @Test
    public void testGetAllDropItems() throws Exception {
        Mockito.when(dropItemService.getAllDropItems()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/dropItems"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetDropItemById() throws Exception {
        DropItem dropItem = new DropItem();
        Mockito.when(dropItemService.getDropItemById(1L)).thenReturn(dropItem);

        mockMvc.perform(get("/dropItems/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dropItemId").value(dropItem.getDropItemId()));
    }

    @Test
    public void testCreateDropItem() throws Exception {
        DropItem dropItem = new DropItem();
        Mockito.when(dropItemService.createDropItem(Mockito.any(DropItem.class))).thenReturn(dropItem);

        mockMvc.perform(post("/dropItems")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"itemName\":\"item\", \"quantity\":1, \"dropRate\":0.5}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dropItemId").value(dropItem.getDropItemId()));
    }

    @Test
    public void testUpdateDropItem() throws Exception {
        DropItem dropItem = new DropItem();
        Mockito.when(dropItemService.updateDropItem(Mockito.anyLong(), Mockito.any(DropItem.class))).thenReturn(dropItem);

        mockMvc.perform(put("/dropItems/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"itemName\":\"item\", \"quantity\":1, \"dropRate\":0.5}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dropItemId").value(dropItem.getDropItemId()));
    }

    @Test
    public void testDeleteDropItem() throws Exception {
        Mockito.when(dropItemService.deleteDropItem(1L)).thenReturn(true);

        mockMvc.perform(delete("/dropItems/1"))
                .andExpect(status().isNoContent());
    }
}