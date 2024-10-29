package fi.haagahelia.wiki_data_crud.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DropTableRepository extends JpaRepository<DropTable, Long> {
    
}
