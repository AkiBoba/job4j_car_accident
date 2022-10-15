package ru.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;

@Service
public interface UserRepository extends CrudRepository<User, Integer> {
}