/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexx;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class metodo {

    int numeroRestricciones;
    int numeroVariables;
    boolean esMaximizar = true;

    String funcionObjetivo;
    int contadorSignos = 0;
    List<Float> funcionOnjetivoInt = new ArrayList<>();

    List<String> restriccionesString = new ArrayList<>(); // ingresando las restricciones
    // 13x1+62x2>=12 , 13x1+62x2>=12

    List<List<Float>> tabla = new ArrayList<>();//
    // ( 13 , 62 , 12 ) , ( 13 , 62 , 12 ) , ( 13 , 62 , 12 ) , ( 13 , 62 , 12 )
    

    List<String> filaVariables = new ArrayList<>();
    List<String> columnaVariables = new ArrayList<>();

    public void main() {

        for (String cadaRestriccion : restriccionesString) { // reccoriendo las restriciones para agregar las variables
                                                             // de holgura

            if (cadaRestriccion.indexOf("<") != -1) {
                List<Float> fila = new ArrayList<>();
                fila.add(+1);
                tabla.add(fila); // añado el valor de las variables de holgura
                contadorSignos++;
            }
            if (cadaRestriccion.indexOf(">") != -1) {
                List<Float> fila = new ArrayList<>();
                fila.add(-1);
                tabla.add(fila); // añado el valor de las variables de holgura
                contadorSignos++;
            }
        }

        if (esMaximizar == true) {
            for (int numeroFuncion : funcionOnjetivoInt) {
                numeroFuncion = numeroFuncion * (-1);
            }

        }

        tabla.add(funcionOnjetivoInt);

        // agregarcabecera fila columna

        for (int i = 0; i <= numeroRestricciones + 2; i++) {
            filaVariables.add("c");
        }
        for (int i = 0; i <= numeroVariables + contadorSignos; i++) {
            columnaVariables.add(0, "x" + i);
        }
        columnaVariables.add("b");
    }

    public void iteracion() {
        List<List<Float>> tablaClone = new ArrayList<>(tabla);//clonamos la tabla

        int numUltimaFila = tabla.size() - 1;
        List<Integer> ultimaFila = tabla.get(numUltimaFila);
        int menorNumero = 10000000;
        for (Integer integer : ultimaFila) {
            if (integer <= menorNumero) {
                menorNumero = integer;
            }

        }
        int idColumnaPivote = ultimaFila.indexOf(menorNumero);

        float disionFila = 1000000;
        int idFilaPivote = 0;
        int contador = 0;
        float elementoPivote = 0;
        List<Float> columnaPivote = new ArratyList<>();//creo la nueva filapivote
        for (List<IFloat> cadaFila : tabla) {
            float celdaPivote = cadaFila.get(idColumnaPivote);
            if (contador != tabla.size() - 1) {
                int celdaResultado = cadaFila.get(cadaFila.size() - 1);
                float resuladoFila = celdaResultado / celdaPivote;
                if (resuladoFila <= disionFila) {//encontrara en menor numero
                    disionFila = resultadofila;//resultado de las divisiones
                    idFilaPivote = contador; //encuentro fila pivote
                    elementoPivote = celdaPivote; //encuentro el elemento pivote
                }

            }
            columnaPivote.add(celdaPivote);
            contador++;
        }

        List<Float> nuevafilaPivote = new ArratyList<>();//creo la nueva filapivote
        List<Float> antiguaFilaPivote = tabla.get(idFilaPivote); //obtengo la fila vieja

        for (Float cadaElementoFilaAntigua : antiguaFilaPivote) {
            float cadaElementoFilaNueva=acadaElementoFilaAntigua/elementoPivote;
            nuevafilaPivote.add(cadaElementoFilaNueva);
        }

        tablaClone.set(idFilaPivote, nuevafilaPivote);


    }
}
