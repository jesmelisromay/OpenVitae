package Ejercicio_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesarFichero {

        public static final String SEPARADOR = ",";
        public static int numError=0;

        public static void main(String[] args) {

            List<Ususarios> usuarios = new ArrayList<>();
            usuarios.add(new Ususarios());//Creo uno vacio para que entre en el for

            BufferedReader bufferLectura = null;
            try {
                bufferLectura = new BufferedReader(new FileReader("ficheroPrueba.csv"));
                String lineaLeida =bufferLectura.readLine();

                int numLinea=0;
                while (lineaLeida != null) {
                    numLinea++;

                    boolean error = true;
                    String[] lineasArray = lineaLeida.split(SEPARADOR);

                    Ususarios usu = new Ususarios();

                    if(lineasArray.length<3){
                        crearError("Faltan Campos, debe rellenar los tres datos",numLinea);
                    }else {
                        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
                        Matcher matcher = pattern.matcher(lineasArray[0]);
                        if (matcher.matches()) {
                            usu.setCorreo(lineasArray[0]);
                        } else {
                            error = crearError("Linea mal formada, el primer campo debe ser el correo.", numLinea);
                        }
                        if (!lineasArray[1].contains("@") && !lineasArray[1].equals("")) {
                            usu.setNombre(lineasArray[1]);
                        } else {
                            error = crearError("Linea mal formada, el segundo campo debe ser el nombre.", numLinea);
                        }
                        if (!lineasArray[2].contains("@")) {
                            usu.setUsuario(lineasArray[2]);
                        } else {
                            error = crearError("Linea mal formada, el tercer campo debe ser el usuario.", numLinea);
                        }
                    }

                    for (Ususarios u: usuarios
                         ) {
                        if (u.getCorreo() != null)
                            if(u.getCorreo().equalsIgnoreCase(lineasArray[0])) {
                                error=crearError("Correo Existente el correo es: " + u.getCorreo(), numLinea);
                        }
                    }
                        if (error)//si no hay errores
                        usuarios.add(usu);


                    lineaLeida =bufferLectura.readLine();
                }

                //Imprimir arrayList
                System.out.println("Los usuarios son: ");
                for (Ususarios u: usuarios
                     ) {
                    if(u.getCorreo()!=null)//no imprimo los null
                    System.out.println(u);
                }
                System.out.println();
                System.out.println("Cantidad de usuarios Procesados correctamente: " + (usuarios.size()-1));
                System.out.println("Cantidad de Errores: "+numError);

            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                // Cierro el buffer de lectura
                if (bufferLectura != null) {
                    try {
                        bufferLectura.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        }
    }

    private static Boolean crearError(String s, int numLinea) {
        System.err.println(s +" El numero de linea del Error es: "+numLinea);
        numError++;
        return false;
    }
}
