package practice.collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
 
public class CopyOnWriteArrayListExample {
	
    public static void main(String args[]) {
 
           // creates array with initial capacity of 10.
           List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
 
           copyOnWriteArrayList.add("ind");
           copyOnWriteArrayList.add("america");
 
           /**
            
           // fail-safe
           Iterator<String> iterator = copyOnWriteArrayList.iterator();
           while (iterator.hasNext()) {
                  copyOnWriteArrayList.add("newEle1");
                  System.out.println(iterator.next());
           }
 
           for (String string : copyOnWriteArrayList) {
                  System.out.println(string);
           }
 
           // fail-safe
           ListIterator<String> listIterator = copyOnWriteArrayList.listIterator();
           listIterator.next();
           listIterator.previous();
           while (listIterator.hasNext()) {
                  copyOnWriteArrayList.add("newEle2");
                  System.out.println(listIterator.next());
           }
 
           // fail-safe
           Enumeration<String> listEnum = Collections
                        .enumeration(copyOnWriteArrayList);
           while (listEnum.hasMoreElements()) {
                  copyOnWriteArrayList.add("newEle3");
                  System.out.println(listEnum.nextElement());
           }
           
           */
           
           //enhanced for loop is fail-safe
           for (String string : copyOnWriteArrayList) {
                  copyOnWriteArrayList.add("newEle"); // Note the newly added element will not be part of this foreach loop
                  System.out.println(string);         // you will get more idea when u see the output
           }
 
           System.out.println(copyOnWriteArrayList);
           

    }
}
