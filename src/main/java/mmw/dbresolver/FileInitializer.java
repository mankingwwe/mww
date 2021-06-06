package mmw.dbresolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FileInitializer {

    private List<String> allFilesInFolder;
    private File folder;


    public void init(File f){
        setFolder(f);
        allFilesInFolder = getFilesForFolder(f);
    }

    public List<String> getAllFilesInFolder(){
        return  allFilesInFolder;
    }

    public void setFolder(File f){
        folder =  f;
    }

    public List<String> getFilesForFolder(File folder) {
        List<String> allFileNames = new ArrayList<String>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getFilesForFolder(fileEntry);
                allFileNames.add(fileEntry.getName());

            } else {
                allFileNames.add(fileEntry.getName());
            }
        }
        return allFileNames;

    }
}
