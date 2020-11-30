package assignment3;

import java.util.LinkedList;
/* COURSE      : COP 3530
 * Section     : U02
 * Semester    : Fall 2012
 * Instructor  : Alex Pelin
 * Author      : Anibal Sicilia
 * Assignment #: 3
 * Due date    : September 11, 2012
 * Description :
 *
 *
 *
 *  I certify that the work is my own and did not consult with
 *  anyone.
 *
 *
 *   Anibal Sicilia
 */
public class SortedLinkedList<T extends Comparable<? super T>> extends LinkedList<T>
{
    private LinkedList<T> list; // the sorted list

    // the constructor
    public SortedLinkedList(LinkedList<T> in)
    {
        // sort in and put it in list
        // write your own method, do not use the Collections.sort
        // you write it
        super(in);

        for (int i = in.size(); i > 0; --i )
        {
            if(in.get(i-1) == null)
            {
                System.out.println("\nThe list cannot contain null values."
                        + "\nSorting will stop here.\n ");
                break;
            }
            for (int j = 0; j<i-1; j++)
            {
                if(in.get(j) == null)
                {
                    System.out.println("\nThe list cannot contain null values. "
                            + "\nSorting will stop here.\n ");
                    break;
                }
                if (in.get(j) != null && in.get(j+1) != null)
                {
                    if(this.get(j).compareTo(this.get(j+1)) > 0)
                    {
                        T t = this.get(j);
                        this.set(j,this.get(j+1));
                        this.set(j+1,t);
                    }
                }

            }
       }
       list = this;
    }

    public SortedLinkedList<T> makeUnion( SortedLinkedList<T> other)
    {
        // you write the loop. Use the merge in mergeSort as an example.
        if(list.isEmpty())
            return other;
        if(other.isEmpty())
            return this;

        SortedLinkedList <T> tmp = new SortedLinkedList <T> (new LinkedList());
        SortedLinkedList <T> l1 = new SortedLinkedList <T> (this);
        SortedLinkedList <T> l2 = new SortedLinkedList <T> (other);
        int implicit = 0;
        int explicit = 0;

        while(l1.size() > 0 && l2.size() > 0)
        {
            if(l1.get(implicit) == null || l2.get(explicit) == null)
            {
                System.out.println("The list cannot contain null values."
                        + "\nSorting will stop here. ");
                break;
            }
            if(l1.get(implicit) != null && l2.get(explicit) != null)
            {
                if(l1.get(implicit).compareTo(l2.get(explicit)) < 0)
                            tmp.add(l1.remove(0));
                else
                    tmp.add(l2.remove(0));
            }
        }
        if(l1.size()> 0)
            tmp.addAll(l1);
        else
            tmp.addAll(l2);
        return tmp;
    }

    // print the items in list
    public void print()
    {
        //you write it
        for(T item : list)
            System.out.println(item);
    }
}