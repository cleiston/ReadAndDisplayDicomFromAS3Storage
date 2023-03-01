/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.querycsvusingsql;

/**
 *
 * @author almadb
 */
public class QueryCsvUsingSql {

    public static void main(String[] args) {
        /*
        String url = "jdbc:relique:csv:" + "/home/almadb/Downloads/" + "?" +
      "separator=," + "&" + "fileExtension=.csv";
        try (Connection conn = DriverManager.getConnection(url)){

        // Create a Statement object to execute the query with.
        // A Statement is not thread-safe.
        Statement stmt = conn.createStatement();

        // Select the ID and NAME columns from sample.csv
        
        ResultSet results = stmt.executeQuery("SELECT * FROM SampleCohort_patData ORDER BY Height");
        while(results.next()){
            System.out.println(results.getFloat("height"));
        }
      
        }catch (SQLException ex) {
            Logger.getLogger(QueryCsvUsingSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        /*
        
        QueryCSV qcsv = new QueryCSV("/home/almadb/Downloads/");
        List<Patient> p = qcsv.findByQuery("Height >= '150' AND BirthYear > '1940'");
        System.out.println(p.get(0).getWeight());

        */
        
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        
        
    }
}
