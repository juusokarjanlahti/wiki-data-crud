package fi.haagahelia.wiki_data_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.haagahelia.wiki_data_crud.domain.Monster;

public interface MonsterRepository extends JpaRepository<Monster, Long> {

}