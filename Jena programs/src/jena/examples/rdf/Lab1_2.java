package jena.examples.rdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

public class Lab1_2 {

//	 static final String inputFileName  = "vc-db-lab.rdf";
     static final String outputRDF = "Lab1_2_mvijayakumar.xml";
     static final String outputNTP = "Lab1_2_mvijayakumar.ntp";
     static final String outputN3 = "Lab1_2_mvijayakumar.n3";
	    public static void main (String args[]) {
	        // create an empty model
	    	org.apache.log4j.Logger.getRootLogger(). setLevel(org.apache.log4j.Level.OFF); 
	        Model model = ModelFactory.createDefaultModel();

//	        InputStream in = FileManager.get().open( inputFileName );
//	        if (in == null) {
//	            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
//	        }
//	        
//	        // read the RDF/XML file
//	        model.read(in, "");
//	        
	        String personURI = "http://somewhere/JohnSmith";
	        String title = "Dr";
	        String name = "Keven L. Ates";
	        String bday = "January 1, 1901";
	        String role = "Senior Lecturer";
	        String email = "atescomp@utdallas.edu";
	        
	        org.apache.jena.rdf.model.Resource johnSmith 
	          = model.createResource(personURI)
	          	     .addProperty(VCARD.TITLE, title)
	                 .addProperty(VCARD.FN, name)
	                 .addProperty(VCARD.BDAY, bday)
	                 .addProperty(VCARD.ROLE, role)
	                 .addProperty(VCARD.EMAIL, email);
	        
	 
	        // write it to standard out in RDF/XML Format
	        try {
				model.write(new BufferedWriter(new FileWriter(outputRDF)),"RDF/XML-ABBREV");
				model.write(new BufferedWriter(new FileWriter(outputNTP)),"N-TRIPLES");
				model.write(new BufferedWriter(new FileWriter(outputN3)),"N3");
				System.out.println("Done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
	    
	        
	    }      

}
