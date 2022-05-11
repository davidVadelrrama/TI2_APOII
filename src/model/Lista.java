package model;

public class Lista {

    Nodo Primero = new Nodo();
    Nodo Ultimo = new Nodo();
    int CantidadNodos = 0;
    

    public Lista() {
        Primero = null;
        Ultimo = null;

    }

    public void insertarNodo(int x, int y, int[] semillas, int[] portales, int [] conexion) {
        Nodo nuevo = new Nodo();
        CantidadNodos++;
        nuevo.setDato(CantidadNodos);
        nuevo.setPosx(x);
        nuevo.setPosy(y);
        
        //asignar portales
        for (int i = 0; i < portales.length; i++) {
            if (CantidadNodos == portales[i]) {
                nuevo.setTps(true);
                nuevo.setTp(conexion[i]);
            }
        }
        
        //asignar semillas
        for (int i = 0; i < semillas.length; i++) {
            if (CantidadNodos == semillas[i]) {
                nuevo.setSemilla(true);
            }
        }

        if (Primero == null) {
            Primero = nuevo;
            Primero.setSiguiente(null);
            Ultimo = nuevo;
        } else {
            Ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(null);
            Ultimo = nuevo;
        }
    }

    public void mostrarNodos(int Columnas, Rick j1, Morty j2) {
        Nodo actual = new Nodo();
        actual = Primero;
        if (Primero != null) {
            while (actual != null) {
                for (int i = 0; i < Columnas; i++) {
                    if (j1.getPocicion() == actual.getDato() && j2.getPocicion() == actual.getDato()) {
                        System.out.print("[ RM ] ");
                    } else if (j1.getPocicion() == actual.getDato() && j2.getPocicion() != actual.getDato()) {
                        System.out.print("[ R ] ");
                    } else if (j2.getPocicion() == actual.getDato() && j1.getPocicion() != actual.getDato()) {
                        System.out.print("[ M ] ");
                    } else if (actual.isSemilla()) {
                        System.out.print("[ * ] ");
                    } else {
                        System.out.print("[ "+actual.getDato() + " ] ");
                    }
                    actual = actual.getSiguiente();
                }
                System.out.println("");
            }
        } else {
            System.out.println("El nodo se encuentra vacio.");
        }
    }

    public void mostrarPortales(int Columnas) {
        Nodo actual = new Nodo();
        actual = Primero;
        System.out.println("");
        if (Primero != null) {
            while (actual != null) {
                for (int i = 0; i < Columnas; i++) {
                    System.out.print(actual.getTp() + "  ");
                    actual = actual.getSiguiente();
                }
                System.out.println("");
            }
        } else {
            System.out.println("El nodo se encuentra vacio.");
        }
    }
    public boolean validarPunto(int posicion, int[] semillas){
        for (int i = 0; i < semillas.length; i++) {
            if(semillas[i] == posicion){
                semillas[i] = 0;
                return true;
            }
        }
        return false;
    }
    public int[] actualizarSemillas(int porsicion, int[] semillas){
        for (int i = 0; i < semillas.length; i++) {
            if(semillas[i] == porsicion){
                semillas[i] = 0;
                return semillas;
            }
        }
        return semillas;
    }
    public int validarTP(int porsicion, int[] posicion, int[] conexion){
        for (int i = 0; i < posicion.length; i++) {
            if(posicion[i] == porsicion){
                return conexion[i];
            }
        }
        return 0;
    }

}
