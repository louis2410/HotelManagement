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
import java.util.Iterator;
 
/**
 *
 * @author Louis
 */
public class DeleteFromFile {
    
    public static void main(String[] args) {
	
		// prepares the file strategy to directory /tmp
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/Users/Louis/HotelManagement/HotelManagement/Rooms"));
		// looks up the list:
		List list = new XmlArrayList(strategy);
		
		// remember the list is still there! the files int@[1-5].xml are still in /tmp!
		// the list was persisted!
		
		for(Iterator it = list.iterator(); it.hasNext(); ) {
			Author author = (Author) it.next();
			if(author.getName().equals("mama")) {
				System.out.println("Removing mama...");
				it.remove();
			} else {
				System.out.println("Keeping " + author.getName());
			}
		}
	
	}
    
}
