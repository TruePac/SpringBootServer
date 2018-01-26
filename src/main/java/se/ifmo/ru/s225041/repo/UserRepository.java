package se.ifmo.ru.s225041.repo;

import org.springframework.data.repository.CrudRepository;

import se.ifmo.ru.s225041.model.User;

public interface UserRepository  extends CrudRepository<User, Long>{

}
