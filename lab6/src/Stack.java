public class Stack<T> {
    //массив для хранения элементов стека
    private T[] stackArray;
    private int size;

    public Stack(int capacity) {
        stackArray = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T elem) {
        if (size == stackArray.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        size++;
        //новый элемент добавляется в стек на текущую позицию
        stackArray[size-1] = elem;
    }

    //удаление элемента из стека
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        //получаем значение элемента из массива на позиции
        T element = stackArray[size-1];
        stackArray[size-1] = null;
        size--;
        return element;
    }

    //получение верхнего элемента стека без его удаления.
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[size-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
