/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosestudiantes;

/**
 *
 * @author xXSorzXx
 */
public class Cursos {
    private int semestreCso[] = new int[8];
    private String nombreCso[] = new String[8];
    private int codigoCso[] = new int[8];
    private int zonaCso[] = new int[8];
    private int examenFinalCso[] = new int[8];
    private String fechaCSO[] = new String[8];

    public void setSemestreCso(int[] semestreCso) {
        this.semestreCso = semestreCso;
    }

    public void setNombreCso(String[] nombreCso) {
        this.nombreCso = nombreCso;
    }

    public void setCodigoCso(int[] codigoCso) {
        this.codigoCso = codigoCso;
    }

    public void setZonaCso(int[] zonaCso) {
        this.zonaCso = zonaCso;
    }

    public void setExamenFinalCso(int[] examenFinalCso) {
        this.examenFinalCso = examenFinalCso;
    }

    public void setFechaCSO(String[] fechaCSO) {
        this.fechaCSO = fechaCSO;
    }

    public int[] getSemestreCso() {
        return semestreCso;
    }

    public String[] getNombreCso() {
        return nombreCso;
    }

    public int[] getCodigoCso() {
        return codigoCso;
    }

    public int[] getZonaCso() {
        return zonaCso;
    }

    public int[] getExamenFinalCso() {
        return examenFinalCso;
    }

    public String[] getFechaCSO() {
        return fechaCSO;
    }
}
