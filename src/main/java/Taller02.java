import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Taller02 {

    /**
     Datos para realizar las pruebas unitarias del Taller02
    int [ ][ ] datosTesting = {
            {2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.6, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2},
            {4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1},
            {2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 2.9},
            {2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.7, 3.8, 4.5, 2.3, 3.2, 3.1},
            {3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1}
    };
    **/

    public static void main(String[] args) {
        /*
        for (int i = 0; i < 50; i++) {
            System.out.println(validacionRandom(9.5));
        }
        */
        /*
        mostraMatriz(matrizSismo(10));
        sismoMasIntenso(matrizSismo(10));
        sismoRepetidos(matrizSismo(10), 4.0);
        */
        System.out.println("Ingrese los dias que quiera estudiar entre 1 y 31");
        int dias;
        do {
            dias = validarNumero();
        }while (dias > 31);
        menu(matrizSismo(dias));
    }

    public static double[][] matrizSismo(int dias) {

        double[][] matriz = new double[dias][24];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = validacionRandom(9.5);
            }
        }
        return matriz;
    }

    public static double validacionRandom(double max) {
        Random rnum = new Random();
        Boolean bandera = true;

        double random;
        do {
            random = rnum.nextInt(95);
            random /= 10;

            if (random <= max && random >= 1.0) {
                bandera = false;
            } else if(random <= 0.9 || random > max){
                bandera = true;
            }

        } while (bandera);

        return random;
    }

    public static void mostraMatriz(double[][] matrizElegida) {

        for (int i = 0; i < matrizElegida.length; i++) {
            for (int j = 0; j < matrizElegida[i].length; j++) {
                System.out.print("["+matrizElegida[i][j]+"]");
            }
            System.out.println("");
        }
    }

    public static double sismoMasIntenso(double[][] sismos){
        double maximo = 0;
        int DD = 0;
        int HH = 0;
        for (int i = 0; i <sismos.length ; i++) {
            for (int j = 0; j < sismos[i].length ; j++) {
                if (maximo < sismos[i][j]) {
                    maximo = sismos[i][j];
                    DD = i +1;
                    HH = j;
                } else {
                    continue;
                }
            }
        }
        System.out.println(maximo+ " Dia: " + DD +" Hora: "+ HH);
        return maximo;
    }

    public static int sismoRepetidos(double[][] matriz, double lineaMaxima) {

        int contadorIndividual = 0;
        int contadorTotal = 0;

        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                if (matriz[i][j] >= lineaMaxima){
                    contadorIndividual++;
                }
            }
            System.out.println("El dia " +(i+1) + " se repitieron " + contadorIndividual + " sismos mayores de " +lineaMaxima );
            contadorTotal += contadorIndividual;
            contadorIndividual = 0;
        }
        System.out.println(contadorTotal);

        return contadorTotal;
    }

    public static void menu(double[][] matriz){
        boolean ejec = true;
        do {
            System.out.println("\nSelecciona la operacion a realizar");
            System.out.println("1 - Mostrar sismo más intenso");
            System.out.println("2 - Mostrar sismos ≥ 4.0 grados Richter");
            System.out.println("3 - Mostrar matriz");
            System.out.println("4 - Generar nueva matriz");
            System.out.println("9 - Terminar");
            int opcion = validarNumero();
            if (opcion >= 1 && opcion <= 3 ) {
                seleccion(opcion, ejec, matriz);

            } else if (opcion == 9) {
                ejec = false;
            } else {
                System.out.println("Opcion no valida");
            }

        } while (ejec);
    }

    private static void seleccion(int opcion, boolean ejec, double[][] matriz) {

        switch(opcion){
            case 1:
                sismoMasIntenso(matriz);
                break;
            case 2:
                sismoRepetidos(matriz, 4.0);
                break;
            case 3:
                mostraMatriz(matriz);
                break;
            default:
                break;
        }

    }

    private static int validarNumero() {
        Scanner teclado = new Scanner(System.in);

        Integer entrada = 0;
        do {
            try {
                entrada = teclado.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("No ingrese letras u oraciones");
                teclado.next();
                entrada = -1;
            }
            if (entrada <= 0){
                System.out.println("Opcion no valida");
            }
        } while (entrada <= 0);
        return entrada;
    }

}
