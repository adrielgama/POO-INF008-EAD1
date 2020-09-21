package avap1;

import java.util.ArrayList;


public class AreaMonitorada{
	
	private ArrayList<Unidade> unidades = new ArrayList<>();
	

	public ArrayList<Unidade> getUnidades() {
		return unidades;
	}
	public void setUnidades(ArrayList<Unidade> unidades) {
		this.unidades = unidades;
	}
	
	
	public void monitorar(float abcissa, float ordenada, boolean video, boolean
			termometro, boolean co2, boolean ch4) {

		int i = unidadeProxima(abcissa, ordenada, filtrarUnidades(video, termometro, co2, ch4));
		
		unidades.get(i).setX(abcissa);
		unidades.get(i).setY(ordenada);
		
	}



	/*******************
	   ARMAZENA UNIDADE
	 ******************/
			
	public ArrayList<Integer> filtrarUnidades(boolean video, boolean
			termometro, boolean co2, boolean ch4) {
		
		ArrayList<Integer> posicoes = new ArrayList<>();
		
		for (int i = 0; i < unidades.size(); i++) {	
			if(filtrarUnidade(unidades.get(i), video, termometro, co2, ch4)) {
				posicoes.add(i);
			}
		}
		return posicoes;
	}
	
	/*******************
     FILTRO DA UNIDADE
	******************/
		
	private boolean filtrarUnidade(Unidade unidade, boolean video, boolean
			termometro, boolean co2, boolean ch4) {
		if(video) {
			if(!unidade.temSensor("Video"))
				return false;
		}
		if(termometro) {
			if(!unidade.temSensor("Termometro"))
				return false;
		}
		if(co2) {
			if(!unidade.temSensor("co2"))
				return false;
		}
		if(ch4) {
			if(!unidade.temSensor("ch4"))
				return false;
		}
		return true;
	}
	
	
	/****************************
       PEGA UNIDADE MAIS PROXIMA
	*****************************/
		
	public int unidadeProxima(float abcissa, float ordenada, ArrayList<Integer> unidadesFiltradas) {
		
		Double menorDistancia = 0.0;
		int unidade = 0;
		
		for (Integer i : unidadesFiltradas) {
			Double distancia = unidades.get(i).calcularDistancia(abcissa, ordenada);
			
			if(distancia < menorDistancia) {
				menorDistancia = distancia;
				unidade = i;
			}
		}
		
		return unidade;
	}
}
