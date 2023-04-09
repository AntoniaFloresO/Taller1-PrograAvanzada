import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;
import java.util.Random;

//Buenas
public class ProtectorPantalla {
    //Primer subprograma: Contiene los valores y arreglos para después ser iniciado en el main
    public static void iniciarPrograma() {

        //Tamaño de pantaña
        double min = -1.0;
        double max = 1.0;

        //Arreglos
        double[] x = new double[6];
        double[] y = new double[6];
        double[] velocidadX = new double[6];
        double[] velocidadY = new double[6];

        Color[] colores = {Color.PINK, Color.CYAN, Color.MAGENTA, Color.GREEN, Color.GRAY, Color.ORANGE};

        //Arreglos en subprogramas
        GenerarAzar(x,y,velocidadX,velocidadY,min,max);
        Actualizar(x,y,velocidadX,velocidadY,min,max,colores);
    }

    //Segundo subprograma: Donde se generaran las posiciones y velocidades al azar para cada línea
    public static void GenerarAzar(double[] x, double[] y, double[] velocidadX, double[] velocidadY, double min, double max) {
        Random random = new Random();

        x[0] = random.nextDouble() * Math.random();
        y[0] = random.nextDouble() * Math.random();
        velocidadX[0] = random.nextDouble() * Math.random();
        velocidadY[0] = random.nextDouble() * Math.random();

        //Hacer que el resto de líneas sigan a la primera con un ciclo for c:
        for (int i = 1; i < 6; i++) {
            x[i] = x[i-1] + random.nextDouble() * Math.random();
            y[i] = y[i-1] + random.nextDouble() * Math.random();
            velocidadX[i] = velocidadX[i-1] + random.nextDouble() * Math.random();
            velocidadY[i] = velocidadY[i-1] + random.nextDouble() * Math.random();

        }
    }

    //Tercer subprograma: Se actuactualizaran las posiciones de las líneas y se ve si alguna choca con el borde para hacerla rebotar
    public static void Actualizar(double[] x, double[] y, double[] velocidadX, double[] velocidadY, double min, double max, Color[] colores) {

        while (true) {
            for (int i = 0; i < 6; i++) {
                //Actualizar posición de las líneas
                x[i] += velocidadX[i];
                y[i] += velocidadY[i];

                //Revisar si la línea choca con el borde y hacerla rebotar
                if (x[i] < 0 || x[i] > max && x[i] > min) { //Revisar esta mamada de max y min
                    velocidadX[i] = -velocidadX[i];
                }

                if (y[i] < 0 || y[i] > min && y[i] > max) {
                    velocidadY[i] = -velocidadY[i];
                }

                //Se lleva la posición actualizda a la siguiente línea
                if (i < 6 -1) {
                    x[i +1] = x[i];
                    y[i +1] = y[i];
                    velocidadX[i + 1] = velocidadX[i];
                    velocidadY[i + 1] = velocidadY[i];
                }
            }

            //Dibujar líneas
            StdDraw.clear();
            for (int i = 0; i < 6; i++) {
                StdDraw.setPenColor(colores[i]);
                StdDraw.line(x[i],y[i],x[(i + 1) % 6], y[(i + 1) % 6]);
            }
            StdDraw.show();
            StdDraw.pause(20);
        }
    }

    //Main para iniciar el código
    public static void main(String[] args) {
        iniciarPrograma();
    }
}

//Antonia Flores
//21.202.798-7
