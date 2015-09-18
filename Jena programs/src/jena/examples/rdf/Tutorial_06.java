package jena.examples.rdf;

import java.io.InputStream;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class Tutorial_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m = ModelFactory.createDefaultModel();
		 String nsA = "http://somewhere/else#";
		 String nsB = "http://nowhere/else#";
		 Resource root = m.createResource( nsA + "root" );
		 Property P = m.createProperty( nsA + "P" );
		 Property Q = m.createProperty( nsB + "Q" );
		 Resource x = m.createResource( nsA + "x" );
		 Resource y = m.createResource( nsA + "y" );
		 Resource z = m.createResource( nsA + "z" );
		 m.add( root, P, x ).add( root, P, y ).add( y, Q, z );
		 System.out.println( "# -- no special prefixes defined" );
		 m.write( System.out );
		 System.out.println( "# -- nsA defined" );
		 m.setNsPrefix( "nsA", nsA );
		 m.write( System.out );
		 System.out.println("# -- nsA and cat defined" );
		 m.setNsPrefix("cat", nsB );
		 m.write( System.out );
		 
		 Model m2 = ModelFactory.createDefaultModel();
		 final String inputFileName  = "vc-db-2.rdf";
		 InputStream in = FileManager.get().open( inputFileName );
	        if (in == null) {
	            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
	        }
		 m2.read(in,"");
		 m2.write( System.out );
		 System.out.println("Output written to file");
	}

}
