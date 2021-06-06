package mmw.dbresolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class FileResolver {

    HashMap<String, HashMap<Integer, String>> values;
    TableExtractor tableExtractor = new TableExtractor();

    public void readFiles(String path, List<String> allFileNames) throws FileNotFoundException {
        HashMap<String, HashMap<Integer, String>> tabelNameContentMap = new HashMap<>();
        for (String fileName   :  allFileNames   ) {
            int linecounter = 1;
            File file = new File(path + "\\" + fileName);
            HashMap<Integer, String> lineContentMap = new HashMap<>();
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lineContentMap.put(linecounter, data);
                linecounter++;
            }
            tabelNameContentMap.put(fileName, lineContentMap);
        }
        tableExtractor.init(tabelNameContentMap);
    }

    public void calculateRelations(){
        tableExtractor.searchForFromAndWhereKeyWordAndExtract();
    }
}
