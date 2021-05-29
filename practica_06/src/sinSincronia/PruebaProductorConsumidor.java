package sinSincronia;

public class PruebaProductorConsumidor {
    public static void main(String[] args){
        Pilas pila = new Pilas(10);
        Productor p1 = new Productor(pila);
        Productor p2 = new Productor(pila);
        Thread prodT1 = new Thread(p1);
        Thread prodT2 = new Thread(p2);
        prodT1.start();
        prodT2.start();
        
        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);
        Thread conT1 = new Thread(c1);
        Thread conT2 = new Thread(c2);
        Thread conT3 = new Thread(c3);
        conT1.start();
        conT2.start();
        conT3.start();
    }
}