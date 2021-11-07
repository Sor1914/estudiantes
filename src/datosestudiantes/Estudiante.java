package datosestudiantes;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author xXSorzXx
 */
public class Estudiante implements Serializable{
    //Declaración de Variables a Utilizar
    private String nombres;
    private String apellidos;
    private String carne;
    private String edad;
    private String sexo;
    private String carrera;
    private String creditosObtenidos;
    private int cursosAprobados;
    private int cursosReprobados;
    private String semestreCso[] = new String[8];
    private String nombreCso[] = new String[8];
    private int codigoCso[] = new int[8];
    private int zonaCso[] = new int[8];
    private int examenFinalCso[] = new int[8];
    private String fechaCSO[] = new String[8];
    
    public void setSemestreCso(String[] semestreCso) {
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

    public String[] getSemestreCso() {
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
    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCarne() {
        return carne;
    }

    public String getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getCreditosObtenidos() {
        return creditosObtenidos;
    }

    public int getCursosAprobados() {
        return cursosAprobados;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCursosReprobados() {
        return cursosReprobados;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setCreditosObtenidos(String creditosObtenidos) {
        this.creditosObtenidos = creditosObtenidos;
    }

    public void setCursosReprobados(int cursosReprobados) {
        this.cursosReprobados = cursosReprobados;
    }


    public void setCursosAprobados(int cursosAprobados) {
        this.cursosAprobados = cursosAprobados;
    }

    public static void Cursos(int cursosAprobados, String cadena){
        Estudiante estudiante = new Estudiante();
        cursosAprobados = 3;
        Scanner in = new Scanner(System.in);
        String[] datosInicialesCurso = cadena.split(Pattern.quote("{"));
       // System.out.println(datosInicialesCurso[0]);
        in.nextLine();
        String datosMedioCursos[] = new String[cursosAprobados];
        int incremento;
        for (int i = 0; i < cursosAprobados; i++) {
            incremento = i + 2;
            datosMedioCursos[i] = datosInicialesCurso[incremento];            
         }
        String[] AprobadoUno = datosMedioCursos[0].split(Pattern.quote(" \""));
        String[] AprobadoDos = datosMedioCursos[1].split(Pattern.quote(" \""));
        String[] AprobadoTres = datosMedioCursos[2].split(Pattern.quote(" \""));
   
            estudiante.semestreCso[0] = (AprobadoUno[0].substring(13));
            estudiante.nombreCso[0] = AprobadoUno[3];
            estudiante.codigoCso[0] = Integer.parseInt(AprobadoUno[4].substring(0,3));
            estudiante.zonaCso[0] = Integer.parseInt(AprobadoUno[5].substring(8,10));
            estudiante.examenFinalCso[0] = Integer.parseInt(AprobadoUno[6].substring(15,17));
            estudiante.fechaCSO[0] = AprobadoUno[8];
            
            estudiante.semestreCso[1] = (AprobadoDos[0].substring(13));
            estudiante.nombreCso[1] = AprobadoDos[3];
            estudiante.codigoCso[1] = Integer.parseInt(AprobadoDos[4].substring(0,3));
            estudiante.zonaCso[1] = Integer.parseInt(AprobadoDos[5].substring(8,10));
            estudiante.examenFinalCso[1] = Integer.parseInt(AprobadoDos[6].substring(15,17));
            estudiante.fechaCSO[1] = AprobadoDos[8];
            
            estudiante.semestreCso[2] = (AprobadoTres[0].substring(13));
            estudiante.nombreCso[2] = AprobadoTres[3];
            estudiante.codigoCso[2] = Integer.parseInt(AprobadoTres[4].substring(0,3));
            estudiante.zonaCso[2] = Integer.parseInt(AprobadoTres[5].substring(8,10));
            estudiante.examenFinalCso[2] = Integer.parseInt(AprobadoTres[6].substring(15,17));
            estudiante.fechaCSO[2] = AprobadoTres[8];
            
            
       /* System.out.println("este es el dato");
        System.out.println(estudiante.examenFinalCso[0]);
        for (int i = 0; i < AprobadoUno.length; i++) {
            System.out.println(AprobadoUno[i]);
        }  */
        
        
    }





}
