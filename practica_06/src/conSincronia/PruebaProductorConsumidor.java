package conSincronia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PruebaProductorConsumidor {
    public static void main(String[] args){
        Pila pila = new Pila(10);
        Productor p1 = new Productor(pila);
        Productor p2 = new Productor(pila);
        /*Thread prodT1 = new Thread(p1);
        Thread prodT2 = new Thread(p2);
        prodT1.start();
        prodT2.start();*/
        
        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);
        /*Thread conT1 = new Thread(c1);
        Thread conT2 = new Thread(c2);
        Thread conT3 = new Thread(c3);
        conT1.start();
        conT2.start();
        conT3.start();*/
        ExecutorService ejecutor = Executors.newCachedThreadPool();
        ejecutor.execute(p1);
        ejecutor.execute(p2);
        ejecutor.execute(c2);
        ejecutor.execute(c3);
        ejecutor.execute(c1);
        ejecutor.shutdown();
        try{
            //espera un minuto de los consumidore-productores en su ejecucion
            boolean tareasTerminaron = ejecutor.awaitTermination(1, TimeUnit.MINUTES);
            if(tareasTerminaron)
                System.out.println("Todas las tareas terminaron"); //imprime el contenido
            else{
                System.out.println("Se agotò el tiempo esperado a que las tareas terminaran.");
                System.exit(1);
            }
        } catch(InterruptedException ex){
            System.out.println("Hubo una interrupciòn mientras esperaba a que se terminaran las tareas.");
        }
    }
}