
package datosestudiantes;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author xXSorzXx
 */
public class DatosEstudiantes {
    //Metodo Main que ejecuta el programa
    
    public static void main(String[] args) {
        ObjectOutputStream datosEstudiante = null;
        ObjectInputStream lecturaDatosEstudiante = null;
        Scanner in = new Scanner(System.in);
        boolean menuInicial = true;
        int op1 = 0;
        
        //Se crea un objeto para almacenar la información de los estudiantes.
        Estudiante estudiante = new Estudiante();
        
        //Variable String que almacenará los campos con llaves
        String cadenasLlave[] = new String[13]; 
    
        while (menuInicial){
        
        System.out.println("--------------------------------------------------------");
        System.out.println("           Análisis de Datos de Estudiantes             ");
        System.out.println("--------------------------------------------------------");
        System.out.println(" ");
        System.out.println("1.Ingreso de datos");
        System.out.println("2.Analisis de Datos");
        System.out.println("3.Salir");
        op1 = in.nextInt();  in.nextLine();
        switch (op1){
            case 1:
                    
                    System.out.println("Ingrese la cadena");
                    String recibeTemporal = in.nextLine();
                    System.out.println(recibeTemporal);
                    String[] datosInicialesEstudiante = recibeTemporal.split(Pattern.quote("["));
                    String[] datosSeparadosEstudiante = datosInicialesEstudiante[0].split(Pattern.quote(" \""));
                    for (int i = 0; i < datosSeparadosEstudiante.length; i++) {
                        System.out.println(datosSeparadosEstudiante[i]);
                    }  
                    estudiante.setNombres(datosSeparadosEstudiante[1]);
                    estudiante.setApellidos(datosSeparadosEstudiante[3]);
                    estudiante.setCarne(datosSeparadosEstudiante[5]);
                    estudiante.setEdad(datosSeparadosEstudiante[6].substring(8,9));
                    estudiante.setSexo(datosSeparadosEstudiante[8]);
                    estudiante.setCarrera(datosSeparadosEstudiante[10]);
                    estudiante.setCreditosObtenidos(datosSeparadosEstudiante[11].substring(17,19));
                    estudiante.setCursosAprobados(Integer.parseInt(datosSeparadosEstudiante[12].substring(27,29)));
                    Estudiante.Cursos(1, recibeTemporal);
                     try{
                            if (Files.exists(Paths.get("Estudiantes.txt"))) {
                                datosEstudiante = new AppendingObjectOutputStream(Files.newOutputStream(Paths.get("Estudiantes.txt"), StandardOpenOption.APPEND));
                            } else {
                                datosEstudiante = new ObjectOutputStream(Files.newOutputStream(Paths.get("Estudiantes.txt")));
                            }    
                           
                            datosEstudiante.writeObject(estudiante);
                            datosEstudiante.close();
                            System.out.println("Se guardó el Registro");
                            }catch(IOException ioException){
                               System.err.println("Error al escribir en el archivo. " + ioException.toString());
                               System.out.println("No se guardó el registro");

                            }      
                    
                break;
            case 2:
            int op2;
                System.out.println("------------------------------------------");
                System.out.println("-----------Análisis de Datos -------------");
                System.out.println("-------de Estudiantes ------ -------------");
                System.out.println("------------------------------------------");
                System.out.println("");
                System.out.println("1. Datos Personales de Estudiantes ");
                System.out.println("2. Cantidad de Estudiantes Masculinos y Femeninos ");
                op2 = in.nextInt(); in.nextLine();
                switch (op2){
                    case 1:
                        try{
                            lecturaDatosEstudiante = new ObjectInputStream(Files.newInputStream(Paths.get("Estudiantes.txt")));
                                System.out.print("Nombres");
                                System.out.print("                           ");
                                System.out.print("Apellidos");
                                System.out.print("                           ");
                                System.out.print("Edad");
                                System.out.print("                           ");
                                System.out.println("Sexo");
                            while (true) {
                                
                                estudiante = (Estudiante) lecturaDatosEstudiante.readObject();
                                System.out.print(estudiante.getNombres());
                                System.out.print("                           ");
                                System.out.print(estudiante.getApellidos());
                                System.out.print("                           ");
                                System.out.println(estudiante.getSexo());
                                
                            }
                        
                            
                        } catch (EOFException endOfFileException) {
                            System.out.printf("%s%n", "No hay más registros");
                        } catch (ClassNotFoundException classNotFoundException) {
                            System.err.println("Tipo de objeto inválido.");
                        } catch (IOException ioException) {
                            System.err.println("Error al leer archivo. Terminando. Error: " + ioException.getMessage());
                        } finally{
                            System.out.println("");
                            
                        }
                        
                        break;
                    case 2:
                        int contadorF=0;
                        int contadorM=0;
                        try{
                            
                            lecturaDatosEstudiante = new ObjectInputStream(Files.newInputStream(Paths.get("Estudiantes.txt")));                                
                            
                            while (true) {
                                if (estudiante.getSexo() =="femenino\""){
                                    contadorF = contadorF + 1;
                                } else {
                                    contadorM = contadorM + 1;
                                }
                            
                                
                            }
                      
                        } catch (EOFException endOfFileException) {
                            System.out.printf("%s%n", "No hay más registros");
                        } catch (IOException ioException) {
                            System.err.println("Error al leer archivo. Terminando. Error: " + ioException.getMessage());
                        } finally{
                            System.out.println("");
                            
                        }
                        System.out.println("Hombres: " + contadorM);
                            System.out.println("Mujeres: " + contadorF);
                        break;
                }
                
                break;
            case 3:
                break;
            default:
                System.out.println("Opción no Valida");
                menuInicial = true;
                break;

            }
        }
  
    }

}
    

