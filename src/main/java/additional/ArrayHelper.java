package additional;

import common.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// ResourceForDelegation

public class ArrayHelper {
    public ArrayList<Person> leftUnion(ArrayList<Person> personFirst, ArrayList<Person> personSecond){

        ArrayList <Person> leftUnion = new ArrayList<>();


        leftUnion.addAll(personFirst);

        Iterator<Person> itr = personFirst.iterator();
        while (itr.hasNext())
        {
             Person person = itr.next();
             if(personSecond.contains(person))
             {
                 leftUnion.add(person);
             }
        }

        return leftUnion;
}


    public HashSet<Person> merge (ArrayList<Person> personFirst, ArrayList<Person> personSecond){

        HashSet<Person> merge = new HashSet<>();

        merge.addAll(personFirst);
        merge.addAll(personSecond);

        return merge;
    }

    public HashSet<Person> innerUnion (ArrayList<Person> personFirst, ArrayList<Person> personSecond){

        HashSet<Person> innerUnion = new HashSet<>();


        Iterator<Person> itr = personFirst.iterator();
        while (itr.hasNext())
        {
            Person person = itr.next();
            if(personSecond.contains(person))
            {
                innerUnion.add(person);
            }
        }

        return innerUnion;
    }

    public HashSet<Person> outerUnion (ArrayList<Person> personFirst, ArrayList<Person> personSecond){

        HashSet<Person> outerUnion = new HashSet<>();

        Iterator<Person> itr = personFirst.iterator();
        while (itr.hasNext())
        {
            Person person = itr.next();

            if(!(personSecond.contains(person)))
            {
                outerUnion.add(person);
            }
        }

        Iterator<Person> iter = personSecond.iterator();
        while (iter.hasNext())
        {
            Person person = iter.next();

            if(!(personFirst.contains(person)))
            {
                outerUnion.add(person);
            }
        }

        return outerUnion;
    }

}