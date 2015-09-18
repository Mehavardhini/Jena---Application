package jena.examples.rdf ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

public class Tutorial_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String personURI    = "http://somewhere/JohnSmith";
        String givenName    = "John";
        String familyName   = "Smith";
        String fullName     = givenName + " " + familyName;
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // create the resource
        //   and add the properties cascading style
        Resource johnSmith 
          = model.createResource(personURI)
                 .addProperty(VCARD.FN, fullName)
                 .addProperty(VCARD.N, model.createResource()
                                   .addProperty(VCARD.Given, givenName)
                                   .addProperty(VCARD.Family, familyName));
        
        // list the statements in the graph
        StmtIterator iter = model.listStatements();
        
        // print out the predicate, subject and object of each statement
        while (iter.hasNext()) {
            Statement stmt      = iter.nextStatement();         // get next statement
            Resource  subject   = stmt.getSubject();   // get the subject
            Property  predicate = stmt.getPredicate(); // get the predicate
            RDFNode   object    = stmt.getObject();    // get the object
            
            System.out.print("Subject: " + subject.toString() +"\n");
            System.out.print("Predicate: " + predicate.toString() + "\n");
            if (object instanceof Resource) {
                System.out.print("Resource: " + object.toString() + "\n");
            } else {
                // object is a literal
                System.out.print("Literal: "+ " \"" + object.toString() + "\"" + "\n");
            }
        }
        
        System.out.println("--------------------------");
        model.write(System.out);
        
        System.out.println("--------------------------");
        model.write(System.out,"RDF/XML-ABBREV");
        
        System.out.println("--------------------------");
        model.write(System.out,"N-TRIPLES");
        
        
        
        
	}

}
