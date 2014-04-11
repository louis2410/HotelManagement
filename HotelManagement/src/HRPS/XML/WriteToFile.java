/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HRPS.XML;



import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import java.io.File;
import java.util.List;
 
/**
 *
 * @author Louis
 */



public class WriteToFile {
    
    public static void main(String[] args) {


	// prepares the file strategy to directory /tmp
                String fileName = System.getProperty("user.dir"); 
                File xmlFile = new File(fileName + "/src/HRPS/data/Author");
		PersistenceStrategy strategy = new FilePersistenceStrategy(xmlFile);
		// creates the list:
		List list = new XmlArrayList(strategy);
		
		// adds four authors
                Author temp = new Author("joe walnes");
		list.add(temp);
		list.add(new Author("joerg schaible"));
		list.add(new Author("mauro talevi"));
		list.add(new Author("guilherme silveira"));
		
		// adding an extra author
		Author mistake = new Author("mama");
		list.add(mistake);
}

}