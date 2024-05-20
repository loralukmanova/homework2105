import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ProductThread extends Thread{
    private String filename;

    ProductThread (String name, String filename){
        super(name);
        this.filename=filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        File file = new File(filename);

        Scanner input = null;
        try{
            input = new Scanner(file);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        while (input.hasNext()){
            String name = input.next();
            String category = input.next();
            Double price = input.nextDouble();
            Product p = new Product(name, category, price);
            Main.products.add(p);
        }

        input.close();
    }
}
