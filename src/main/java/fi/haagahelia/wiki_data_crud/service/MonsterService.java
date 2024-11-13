package fi.haagahelia.wiki_data_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.domain.MonsterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    // findAll
    public List<Monster> findAll() {
        return monsterRepository.findAll();
    }

    // findById
    public Optional<Monster> findById(Long id) {
        return monsterRepository.findById(id);
    }

    // save
    public Monster save(Monster monster) {
        return monsterRepository.save(monster);
    }

    // deleteById
    public void deleteById(Long id) {
        monsterRepository.deleteById(id);
    }
}