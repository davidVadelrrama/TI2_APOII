package model;


public class Rick {

    private int Pocicion;
    private String Nombre;
    private int puntos = 0;

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
        setPuntos(getPuntos() + 1);
    }
    
    public void RecetearPuntos(){
        setPuntos(0);
    }

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
