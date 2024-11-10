package fi.haagahelia.wiki_data_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.haagahelia.wiki_data_crud.domain.DropItem;

public interface DropItemRepository extends JpaRepository<DropItem, Long> {
    
}