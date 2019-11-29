package ordenamiento;
/**
 *
 * @author mijum
 */
public class InsertSort implements AlgoritmoOrdenamiento,Runnable{
    
    private double datos[];
    private double tt;
    private boolean thread;
    
    
    public InsertSort(){
        this.datos=null;
        this.thread=false;
    }
    public InsertSort(Boolean thread){
        this.datos=null;
        this.thread=thread;
    }

    @Override
    public void definirDatos(double[] arreglo) {
        this.datos=arreglo;
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

    @Override
    public String id() {
        return "Insert Sort";
    }

    @Override
    public double getTt() {
        return this.tt;
    }

    @Override
    public void run() {
        //Tiempo de inicio
        double ti = System.currentTimeMillis();
        //Algoritmo
        for (int i = 1; i < datos.length; i++) {
            double k = datos[i];
            int ind = i-1;
            while((ind>-1) && (datos[ind]>k)){
                datos[ind+1]=datos[ind];
                ind--;
            }
            datos[ind+1]=k;
        }
        //.. fin

        //Tiempo de finalizacion
        double tf = System.currentTimeMillis();
        this.tt = tf-ti;
    }

    /**
     * @return the id
     */
    
    
}
