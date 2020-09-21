package avap1;

public class UnidadeEuclidiana extends Unidade {

	@Override
	public Double calcularDistancia(float x, float y) {
		
		double distancia = Math.sqrt(Math.sqrt(super.getX() - x) + Math.sqrt(super.getY() - y));
		return distancia;
	}
	
}
