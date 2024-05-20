import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

    public static PriorityBlockingQueue<Product> products;

    public static void main(String[] args) {
        products = new PriorityBlockingQueue<>();
        try{
            ProductThread t1 = new ProductThread("CKThread", "calvinklein.txt");
            ProductThread t2 = new ProductThread("GuessThread", "guess.txt");
            ProductThread t3 = new ProductThread("TrussardiThread", "trussardi.txt");
            t1.start();
            t2.start();
            t3.start();
        } catch(Exception exception){
            System.out.println("There was an error while reading the data.");
            System.exit(1);
        }

        File file = new File("result_products.txt");
        if (file.exists()){
            System.out.println("File already exists.");
            System.exit(1);
        }
        PrintWriter output=null;
        try{
            output = new PrintWriter(file);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        Iterator<Product> it = products.iterator();
        while(it.hasNext()){
            output.println(it.next()+" ");
        }
        output.close();
    }
}