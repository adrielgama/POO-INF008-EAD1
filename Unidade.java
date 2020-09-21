package avap1;

import java.util.ArrayList;

public abstract class Unidade {
	
	private int id;
	public double x;
	public double y;
	
	
	private ArrayList<Sensors> listaSensors = new ArrayList<>();
	
	
	
	/*******************
	     GET and SET
	 ******************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	
	/*******************
         Metodos
	 ******************/
	
	public abstract Double calcularDistancia(float x, float y);
	
	public boolean temSensor(String nomeSensor) {
		for (Sensors s : listaSensors) {
			if(s.toString().equals(nomeSensor)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
