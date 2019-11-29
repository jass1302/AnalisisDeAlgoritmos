/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author abam_
 */
public class MergeSort implements AlgoritmoOrdenamiento,Runnable{

    private double[] arreglo;
    private double tt;
    private boolean thread;

    public MergeSort(boolean thread) {
        this.thread = thread;
    }
    
    
    
    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public void ordenarDatos() {
        if (this.thread){
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
    public void run() {
        double ti = System.currentTimeMillis();
        mergeSort(arreglo,arreglo.length);
        double tf = System.currentTimeMillis();
        this.tt = tf - ti;
    }
    
    private void mergeSort(double[] a, int n) {
    if (n < 2) {
        return;
    }
    int mid = n / 2;
    double[] l = new double[mid];
    double[] r = new double[n - mid];
 
    for (int i = 0; i < mid; i++) {
        l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
        r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);
 
    merge(a, l, r, mid, n - mid);
}
    
    	
public static void merge(double[] a, double[] l, double[] r, int left, int right) {
  
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
}

    @Override
    public String id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}