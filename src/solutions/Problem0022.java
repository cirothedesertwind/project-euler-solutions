/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem0022 {
    public static void main(String[] args) throws IOException{
       long total = 0;
       
       Path path = Paths.get("p022_names.txt");
       List<String> l = Files.readAllLines(path, StandardCharsets.UTF_8);
       
       String[] lines = l.get(0).split("\",\"");
      
       // remove the " marks from the first and last entries
       lines[0] = lines[0].substring(1);
       lines[lines.length-1] = lines[lines.length-1].substring(0, lines[lines.length-1].length()-1);
       
       Arrays.sort(lines);
       
       int v = 0;
       int index = 1;
       for (String line : lines) {
           for (int i = 0; i < line.length(); i++)
               v += charValue(line.charAt(i));
           
           total += v * index;
           v = 0;
           index++;
       }
       
       System.out.println(total);
    }
    
    private static int charValue(char a){
        return a - 64; //A => 65 - 1 = 64, so A returns 1
    }
}
