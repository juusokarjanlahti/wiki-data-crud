package fi.haagahelia.wiki_data_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fi.haagahelia.wiki_data_crud.domain.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

}

