package se.ifmo.ru.s225041.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RestController;

import se.ifmo.ru.s225041.model.Point;
import se.ifmo.ru.s225041.model.User;
import se.ifmo.ru.s225041.repo.UserRepository;
import se.ifmo.ru.s225041.repo.PointRepository;
import se.ifmo.ru.s225041.service.IPointService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class WebController {
	@Autowired
	PointRepository prepository;
	@Autowired
	UserRepository urepository;

	@Autowired
	private IPointService pointService;

	@GetMapping("save")
	public String process() {
		// save a single Customer
		urepository.save(new User(225041l, "qwerty"));
		return "Done";
	}

	@PostMapping("signup")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		String result;
		if (urepository.exists(user.getId())) {
			result = "User with this id already exists";
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
		urepository.save(user);
		result = "New user was created";
		return new ResponseEntity<String>(result, HttpStatus.OK);
		}
	}

	@PostMapping("login")
	public ResponseEntity<String> logIn(@RequestBody User user) {
		String result;
		if (urepository.exists(user.getId())) {
			User fromDb = urepository.findOne(user.getId());
			if (fromDb.getPassword().equals(user.getPassword())) {
				result = "Ok";
				return new ResponseEntity<String>(result, HttpStatus.OK);
			} else {
				result = "Wrong password";
				return new ResponseEntity<String>(result, HttpStatus.OK);
			}
		} else {
			result = "User not found";
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
	}

	@PostMapping("add")
	public ResponseEntity<Void> createArticle(@RequestBody Point point) {
		point.setHit();
		prepository.save(point);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("findall")
	public ResponseEntity<ArrayList<Point>> findAll() {
		ArrayList<Point> result = new ArrayList<Point>();

		for (Point cust : prepository.findAll()) {
			result.add(cust);
		}

		/* ArrayList<Point> result = pointService.getAllPoints(); */

		return new ResponseEntity<ArrayList<Point>>(result, HttpStatus.OK);
	}

	@GetMapping("deleteAll")
	public ResponseEntity<Void> deleteAll() {
		prepository.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/*
	 * @RequestMapping("/api/findbyid") public String
	 * findById(@RequestParam("id") long id){ String result = ""; result =
	 * repository.findOne(id).toString(); return result; }
	 */

}
