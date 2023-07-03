import java.io.*;
import java.util.LinkedHashSet;

public class cleanFile {

    public static StringBuilder removeDuplicates(String str){

        LinkedHashSet knownChars = new LinkedHashSet();
        StringBuilder noDups = new StringBuilder();

        for(Character c : str.toCharArray()){
            if(!knownChars.contains(c)){
                knownChars.add(c);
                noDups.append(c);
            }
        }
        return noDups;
    }




    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new FileReader("data1.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("data2.txt"));

            String line;
            String oldData = "";

            while((line=br.readLine()) != null){
                String a = line.replaceAll("[^a-zA-Z]" , "");
                String b = String.valueOf(removeDuplicates(a));
                oldData = oldData + b + "\n";
            }

            String newData = oldData;

            bw.write(newData);
            bw.close();
            br.close();
        }catch(Exception e){

        }
    }

}

