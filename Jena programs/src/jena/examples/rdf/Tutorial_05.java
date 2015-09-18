package jena.examples.rdf;
import java.io.InputStream;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class Tutorial_05 {
	 static final String inputFileName  = "vc-db-1.rdf";
     
	    public static void main (String args[]) {
	        // create an empty model
	        Model model = ModelFactory.createDefaultModel();

	        InputStream in = FileManager.get().open( inputFileName );
	        if (in == null) {
	            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
	        }
	        
	        // read the RDF/XML file
	        model.read(in, "");
	                    
	        // write it to standard out
	        model.write(System.out);  
	        
	        model.write(System.out,"N-TRIPLES");  
	        
	        
	    }
}