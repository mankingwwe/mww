package mmw.dbresolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class DbresolverApplication {

    static File folder = new File("C:\\Users\\Anwender\\Desktop\\ddl");

    public static void main(String[] args) throws FileNotFoundException {
    FileInitializer fileInitializer = new FileInitializer();
    FileResolver fileResolver = new FileResolver();
    fileInitializer.init(folder);
    fileResolver.readFiles("C:\\Users\\Anwender\\Desktop\\ddl", fileInitializer.getAllFilesInFolder());
    fileResolver.calculateRelations();





    }

}
