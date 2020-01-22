package LogicAndDataTypes;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Series<T> implements Iterable<T>
{   private Object[] elements;
    private int size;
    public Series()
    {   elements = new Object[0];
        size = 0;
    }

    public Iterator<T> iterator()
    {   return new Inventory();
    }

    public boolean add(T t)
    {   Object[] temp = elements;
        elements = new Object[size + 1];
        int i;
        for(i = 0; i < size; i++)
        {   if(temp[i].toString().compareTo(t.toString()) > 0)
            {   break;
            }
            else
            {   elements[i] = temp[i];
            }
        }
        elements[i] = t;
        size++;
        for(; i + 1 < size; i++)
        {   elements[i + 1] = temp[i];
        }
        return true;
    }

    public T remove(T t)
    {   int index = indexOf(t);
        if(index != -1)
        {   Object[] temp = elements;
            elements = new Object[size - 1];
            for(int i = 0; i < index; i++)
            {   elements[i] = temp[i];
            }
            for(; index < size - 1; index++)
            {   elements[index] = temp[index + 1];
            }
            size--;
            return (T) (temp[index]);
        }
        return null;
    }

    public String toString()
    {   String s = "[";
        for(T t : this)
        {   s += t.toString() + ", ";
        }
        return s.substring(0, s.length() - 2) + "]";
    }

    public int indexOf(T t)
    {   return binarySearch(0, size - 1, t);
    }

    private int binarySearch(int start, int end, T t)
    {   int mid = ((end - start) / 2) + start;
        if(start == end)
        {   if(elements[start].toString().equals(t.toString()))
            {   return start;
            }
            else
            {   return -1;
            }
        }
        else if(elements[mid].toString().equals(t.toString()))
        {   return mid;
        }
        else if(elements[mid].toString().compareTo(t.toString()) < 0)
        {   return binarySearch(mid + 1, end, t);
        }
        else if(elements[mid].toString().compareTo(t.toString()) > 0)
        {   return binarySearch(start, mid, t);
        }
        return -1;
    }

    private class Inventory<T> implements Iterator<T>
    {   private int index = 0;
        public boolean hasNext()
        {   return index < size;
        }

        public T next()
        {   if(hasNext())
            {   Object current = elements[index++];
                return (T) (current);
            }
            throw new NoSuchElementException();
        }
    }
}