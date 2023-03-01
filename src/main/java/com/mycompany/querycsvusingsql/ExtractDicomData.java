/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.querycsvusingsql;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.tool.dcm2json.Dcm2Json;

/**
 *
 * @author almadb
 */
public class ExtractDicomData {
    private JsonElement root; 
    private String jsonString;
    
    private boolean isData(){
        return root != null && jsonString != null;
    }
    
    ExtractDicomData(){
        root = null;
        jsonString = null;
        try {
            DicomInputStream dis = new DicomInputStream(new FileInputStream("temp.dcm"));
        
                    
            // lets get the metadata from the dicom image
            Dcm2Json main = new Dcm2Json();
            main.setIndent(true);

            // Redirect output stream to a ByteArrayOutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps2Array = new PrintStream(baos);

            PrintStream ps2Default = System.out;
            System.setOut(ps2Array);
            // Begin of extracting JSON metadata
            main.parse(dis);

            // Return to default output
            System.out.flush();
            System.setOut(ps2Default);

            // End of extracting JSON metadata

            // test if it worked
            jsonString = baos.toString();

            dis.close();
            
            root = new JsonParser().parse(jsonString);
            System.out.println(root.getAsJsonObject().get("00100020"));
        } catch (Exception e) {
            System.err.println("Error opening Dicom file. " + e.getMessage());
        }
    }
    
    public String get(String key){
        String value = "";
        if(isData()){
            value = root.getAsJsonObject().get(key).toString();
        }
        return value;
    }
    
    public String get(String key1, String key2){
        String value = "";
        if(isData()){
            value = root.getAsJsonObject().get(key1).getAsJsonObject().get(key2).toString();
        }
        return value;
    }
    
    public String getStudyId(){
        // 00200010
        String value = "";
        if(isData()){
            value = root.getAsJsonObject()
                    .get("00200010").getAsJsonObject()
                    .get("Value").getAsJsonArray()
                    .get(0).toString();
        }
        return value;
    }
        
}
