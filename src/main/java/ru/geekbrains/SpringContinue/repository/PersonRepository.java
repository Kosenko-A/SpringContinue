package ru.geekbrains.SpringContinue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringContinue.entity.Person;

@Repository

public interface PersonRepository extends JpaRepository<Person, Long> {

}
