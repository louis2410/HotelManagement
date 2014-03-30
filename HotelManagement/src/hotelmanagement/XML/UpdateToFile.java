/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelmanagement.XML;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import java.io.File;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author Louis
 */
public class UpdateToFile {
    
      public static void main(String[] args) {
	
		// prepares the file strategy to directory /tmp
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/Users/Louis/HotelManagement/HotelManagement/Rooms"));
		// looks up the list:
		List list = new XmlArrayList(strategy);
		
		
		
		for(Iterator it = list.iterator(); it.hasNext(); ) {
			Author author = (Author) it.next();
			if(author.getName().equals("joe walnes")) {
				author.setName("mike");
			} else {
				System.out.println("Keeping " + author.getName());
			}
		}
        
	
	}
    
    
    
}
