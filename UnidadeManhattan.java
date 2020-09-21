package avap1;

public class UnidadeManhattan extends Unidade {
	
	@Override
	public Double calcularDistancia(float x, float y) {
		double distance = Math.abs(super.getY() - y) + Math.abs(super.getY() - y);
		return distance;
	}
}
