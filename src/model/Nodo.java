package model;

public class Nodo {
    private int dato;
    private boolean semilla = false;
    private int tp;
    private boolean tps = false;
    private int posx;
    private int posy;
    private Nodo Siguiente;
    private Nodo anterior;
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public boolean isSemilla() {
		return semilla;
	}
	public void setSemilla(boolean semilla) {
		this.semilla = semilla;
	}
	public int getTp() {
		return tp;
	}
	public void setTp(int tp) {
		this.tp = tp;
	}
	public boolean isTps() {
		return tps;
	}
	public void setTps(boolean tps) {
		this.tps = tps;
	}
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	public Nodo getSiguiente() {
		return Siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		Siguiente = siguiente;
	}
	public Nodo getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
    
    
    
}
