package jena.examples.rdf;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class Lab1_4d {

	static final String outputRDF = "Lab1_4_mvijayakumar.xml";
    static final String outputNTP = "Lab1_4_mvijayakumar.ntp";
    static final String outputN3 = "Lab1_4_mvijayakumar.n3";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.apache.log4j.Logger.getRootLogger(). setLevel(org.apache.log4j.Level.OFF); 
		Dataset dataset=TDBFactory.createDataset("MyDatabases/Dataset1");
		
		dataset.begin(ReadWrite.WRITE);
		try
	 	{
			Model model=dataset.getNamedModel("myrdf");
			dataset.end();
			dataset.begin(ReadWrite.READ);
			FileManager.get().readModel(model, "mehavardhini_FOAFFriends.rdf");
			
			try {
				model.write(new BufferedWriter(new FileWriter(outputRDF)),"RDF/XML-ABBREV");
				model.write(new BufferedWriter(new FileWriter(outputNTP)),"N-TRIPLES");
				model.write(new BufferedWriter(new FileWriter(outputN3)),"N3");
				System.out.println("Done!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	       	dataset.commit();
		}
		finally
		{
			dataset.end();
		}
		
	    	
	}

}
