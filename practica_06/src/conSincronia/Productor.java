package conSincronia;

public class Productor implements Runnable{
    private Pila pila;
    private static int numProd= 1;
    
    public Productor(Pila p){
        pila = p;
        numProd++;
    }
    
    @Override
    public void run() {
        char c;
        for(int i = 0; i < 20; i++){
            c = (char)(Math.random() * 26 + 65);
            pila.poner(c);
            System.out.println(" Productor " + numProd + " agregó a " + c + " en hilo " + Thread.currentThread().getName());
            try{
                Thread.sleep((int)(Math.random()*777));
            } catch(InterruptedException e){
            }
        }
    }
}