package se.ifmo.ru.s225041.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "POINTS")
public class Point implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "X")
	private Double x;

	@Column(name = "Y")
	private Double y;

	@Column(name = "R")
	private Double r;

	@Column(name = "HIT")
	private Boolean hit;

	protected Point() {
	}

	public Point(Double x, Double y, Double r, Boolean hit) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.hit = hit;
	}
	
	public void setX (Double x) {
		this.x = x;
	}
	
	public Double getX() {
		return x;
	}
	
	public void setY (Double y) {
		this.y = y;
	}
	
	public Double getY() {
		return y;
	}
	
	public void setR (Double r) {
		this.r = r;
	}
	
	public Double getR() {
		return r;
	}
	
	public void setHit (Boolean hit) {
		this.hit = hit;
	}
	
	public Boolean getHit() {
		return hit;
	}

	@Override
	public String toString() {
		return String.format("Points[id=%d, x='%f', y='%f',  r='%f',  hit='%b']", id, x, y, r, hit);
	}
	
	public void setHit() {
			if (checkRound() || checkTriangle() || checkRectangle()) {
				this.setHit(true);
			} else this.setHit(false);	
	}
	
	public boolean checkRound(){
		 if ((x*x + y*y <= (r/2)*(r/2)) && (x <= 0) && (y <= 0))
		        return true;
		    else
		    	return false;
	}
	
	public boolean checkRectangle(){
		if ((Math.abs(x)<= r/2) && (Math.abs(y) <= r) && (x >= 0) && (y <= 0) )
	        return true;
	    else
	        return false;
	}
	
	public boolean checkTriangle(){
		if (x <= 0 && y >= 0) {
	        double r1 = (-r/2 - x) * (r - 0) - (0 - (-r/2)) * (0 - y);
	        double r2 = (0 - x) * (0 - r) - (0 - 0) * (r - y);
	        double r3 = (0 - x) * (0 - 0) - (-r/2 - 0) * (0 - y);
	        if ((r1 > 0 && r2 > 0 && r3 > 0) || (r1 < 0 && r2 < 0 && r3 < 0)) {
	            return true;
	        } else if (r!=0 && ( r1 == 0 || r2 == 0 || r3 == 0)) {
	            return true;
	        } else return false;
	    } else
	        return false;
	}
}
