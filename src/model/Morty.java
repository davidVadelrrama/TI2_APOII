
package model;


public class Morty {

    private int Pocicion;
    private String Nombre;
    private int puntos = 0;

    
    public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPocicion() {
        return Pocicion;
    }

    public void setPocicion(int Pocicion) {
        this.Pocicion = Pocicion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public void sumarPuntos(){
        puntos++;
    }
    
    public void RecetearPuntos(){
        puntos = 0;
    }

}
