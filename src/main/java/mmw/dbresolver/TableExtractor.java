package mmw.dbresolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableExtractor {

     HashMap<String, HashMap<Integer, String>> tabelNameContentMap;
     List<String> relatedTables = new ArrayList<>();


    /***
     *
     * init creates content hashmap and sets its value
     * @param tabelNameContentMap
     */
    public void init(HashMap<String, HashMap<Integer, String>> tabelNameContentMap){
        this.tabelNameContentMap = tabelNameContentMap;
    }


    /***
     *
     * @param original -> Hash map conntaining each line-number and its content of the FULL .sql file
     * @param start --> int value of line postion for the "from" keyword
     * @param end --> int value of line postion for the "where" keyword
     *
     * @return hashmap containing just the lines between the FROM and WHERE keyword of the .sql file.
     */
    private HashMap<Integer, String> extractRelevantTableCode(HashMap<Integer, String> original, int start, int end){
        HashMap<Integer, String> cutMap = new HashMap<Integer, String>();
        int key = 0;
        for (int i = start; i <= end ; i++){
            cutMap.put(key,original.get(i));
            key++;
        }
        return cutMap;
    }

    /**
     * searches in all the lines for "FROM" and "WHERE" keyword and remembers its lines.
     * calls method --extractRelevantTableCode-- and uses these lines to create new Hashmap for further
     * operations.
     */

    public void searchForFromAndWhereKeyWordAndExtract(){
        for(Map.Entry<String, HashMap<Integer, String>> table : tabelNameContentMap.entrySet()) {
            String key = table.getKey();
            int keyFrom = 0;
            int keywhere = 0;
            boolean flagFrom = false;
            int c = 0;
            HashMap<Integer, String> value = table.getValue();
                 for(Map.Entry<Integer, String> line : value.entrySet()) {
                    if(line.getValue().contains("from") && !flagFrom){
                        keyFrom = line.getKey();
                        flagFrom = true;
                    }
                    if(line.getValue().contains("where")){
                        keywhere = line.getKey();
                    }
                }
            if(keyFrom != 0 && keywhere != 0 && c == 0){
                System.out.println("Table: " + table.getKey() +  "  from: " + keyFrom+  "  where: " + keywhere );
                Object h = extractRelevantTableCode(value, keyFrom,keywhere);
                c++;
             }
            }

    }

}

