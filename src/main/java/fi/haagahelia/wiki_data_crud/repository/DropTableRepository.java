package fi.haagahelia.wiki_data_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fi.haagahelia.wiki_data_crud.domain.DropTable;

@Repository
public interface DropTableRepository extends JpaRepository<DropTable, Long> {
    
}
