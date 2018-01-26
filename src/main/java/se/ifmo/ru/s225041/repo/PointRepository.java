package se.ifmo.ru.s225041.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.ifmo.ru.s225041.model.Point;

public interface PointRepository extends CrudRepository<Point, Long> {

}
