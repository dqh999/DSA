package dataStructure.stack;

public class LinearNode<E>
{
    private E element;
    private LinearNode<E> next;

    public LinearNode()
    {
        element = null;
        next = null;
    }

    public LinearNode(E element)
    {
        this.element = element;
    }

    public E getElement()
    {
        return element;
    }

    public void setElement(E element)
    {
        this.element = element;
    }

    public LinearNode<E>  getNext()
    {
        return next;
    }

    public void setNext(LinearNode<E>  next)
    {
        this.next = next;
    }
}

