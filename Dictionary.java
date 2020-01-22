package LogicAndDataTypes;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Dictionary<T>
{   private Object[] elements;
    private int size;
    public Dictionary()
    {   elements = new Object[0];
        size = 0;
    }
    
    public boolean add(T t)
    {   if(!contains(t))
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
            elements[i] = new Union<T, Integer>(t, 1);
            size++;
            for(; i + 1 < size; i++)
            {   elements[i + 1] = temp[i];
            }
        }
        else
        {   int i = indexOf(t);
            elements[i] = new Union<T, Integer>(t, ((Integer) (((Union) (elements[i])).second)).intValue() + 1);
        }
        return true;
    }
    
    public boolean addAll(Collection c)
    {   int count = 0;
        for(Object o : c)
        {   if(add((T) (o)))
            {   count++;
            }
        }
        return count != 0;
    }
    
    public void clear()
    {   elements = new Object[0];
    }

    public boolean contains(Object o)
    {   return indexOf(o) != -1;
    }
    
    public boolean containsAll(Collection c)
    {   int count = 0;
        for(Object o : c)
        {   if(!contains(o))
            {   count++;
            }
        }
        return count == 0;
    }
    
    public int indexOf(Object o)
    {   if(size == 0)
        {   return -1;
        }
        return binarySearch(0, size - 1, o);
    }
    
    private int binarySearch(int start, int end, Object o)
    {   int mid = ((end - start) / 2) + start;
        if(start == end)
        {   if(((Union<T, Integer>)(elements[start])).first.toString().equals(o.toString()))
            {   return start;
            }
            else
            {   return -1;
            }
        }
        else if(((Union<T, Integer>)(elements[mid])).first.toString().equals(o.toString()))
        {   return mid;
        }
        else if(elements[mid].toString().compareTo(o.toString()) < 0)
        {   return binarySearch(mid + 1, end, o);
        }
        else if(elements[mid].toString().compareTo(o.toString()) > 0)
        {   return binarySearch(start, mid, o);
        }
        return -1;
    }
    
    public boolean isEmpty()
    {   return size == 0;
    }

    public Iterator iterator()
    {   return new DictionaryIterator();
    }

    public boolean remove(Object o)
    {   int index = indexOf(o);
        if(index != -1)
        {   if(((Union<T, Integer>) (elements[0])).second <= 0)
            {   Object[] temp = elements;
                elements = new Object[size - 1];
                for(int i = 0; i < index; i++)
                {   elements[i] = temp[i];
                }
                for(; index < size - 1; index++)
                {   elements[index] = temp[index + 1];
                }
                size--;
                return true;
            }
            else
            {   elements[index] = new Union<T, Integer>((T) (o), ((Integer) (((Union) (elements[index])).second)).intValue() - 1);
            }
        }
        return false;
    }
    
    public boolean removeTotal(Object o)
    {   int index = indexOf(o);
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
            return true;
        }
        return false;
    }
    
    public boolean removeAll(Collection c)
    {   int count = 0;
        for(Object o : c)
        {   if(remove(o))
            {   count++;
            }
        }
        return count != 0;
    }

    public boolean retainAll(Collection c)
    {   Object[] temp = new Object[c.size()];
        int count = 0;
        for(Object o : c)
        {   if(contains(o))
            {   temp[count] = o;
                count++;
            }
        }
        Object[] temp2 = new Object[count];
        for(int i = 0; i < count; i++)
        {   temp2[i] = temp[i];
        }
        elements = temp2;
        int size2 = size;
        size = count;
        return size2 != count;
    }
    
    public int size()
    {   return size;
    }
    
    public Object[] toArray()
    {   return elements;
    }
    
    public <T> T[] toArray(T[] a)
    {   for(int i = 0; i < size; i++)
        {   a[i] = (T) (elements[i]);
        }
        return a;
    }
    
    private class DictionaryIterator<T> implements Iterator<T>
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