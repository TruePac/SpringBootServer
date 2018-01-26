package se.ifmo.ru.s225041.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.ifmo.ru.s225041.model.Point;
import se.ifmo.ru.s225041.dao.IPointDAO;

@Service
public class PointService implements IPointService{
	@Autowired
	private IPointDAO pointDAO;
	
	@Override
	public ArrayList<Point> getAllPoints(){
		return pointDAO.getAllPoints();
	}
}
