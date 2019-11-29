package ordenamiento;

/**
 *
 * @author mijum
 */

public class QuickSort implements AlgoritmoOrdenamiento,Runnable {
    private double arreglo[];
    private double tt;
    private boolean thread;
    
    public QuickSort(){
        this.arreglo= null;
        this.thread = false;
    }
    public QuickSort(Boolean th){
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

    @Override
    public double getTt() {
     return this.tt;
    }

    @Override
    public String id() {
        return "Quick Sort";
    }

    @Override
    public void run() {
      double ti = System.currentTimeMillis();
      sort(this.arreglo);
      // calculamos el tiempo cuando termina 
    double tf = System.currentTimeMillis();
        // calculamos el tiempo total
    this.tt = tf - ti;

    }
    
    private void sort(double[] arreglo) {
        // check for empty or null array
        if (arreglo ==null || arreglo.length==0){
            return;
        }
        this.arreglo = arreglo;
        quicksort(0, arreglo.length - 1);
    }

    private void quicksort(int low, int high){
      int i = low, j = high;
        // Get the pivot element from the middle of the list
        double pivot = this.arreglo[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (this.arreglo[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (this.arreglo[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }
    private void exchange(int i, int j) {
        double temp = this.arreglo[i];
        this.arreglo[i] = this.arreglo[j];
        this.arreglo[j] = temp;
    }
 
}  
