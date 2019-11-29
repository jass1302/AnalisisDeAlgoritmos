package ordenamiento;

/**
 *
 * @author mijum
 */
public class Optimizado implements AlgoritmoOrdenamiento,Runnable{
    
    private double arreglo[];
    private double tt;
    private boolean thread;
    
    public Optimizado(){
        this.arreglo= null;
        this.thread = false;
    }
    public Optimizado(Boolean th){
        this.thread = th;
        this.arreglo = null;
    }

    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo=arreglo;
    }

    @Override
    public void ordenarDatos() {
         if (this.thread) {
             Thread hilo = new Thread(this);
             hilo.start();
        }else{
            run();
        }
    }

    /**
     * @return the id
     */
   
    @Override
    public String id() {
        return "Burbuja Optimizado";
    }

    @Override
    public double getTt() {
        return this.tt;
    }

    @Override
    public void run() {
        // calcular cuando empieza 
        double ti = System.currentTimeMillis();
        
        for (int i = arreglo.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arreglo[j]>arreglo[j+1]) {
                    double temp = arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=temp;
                }
            }
        }
        // calculamos el tiempo cuando termina 
        double tf = System.currentTimeMillis();
        // calculamos el tiempo total
        this.tt = tf - ti;
    }
    
}
