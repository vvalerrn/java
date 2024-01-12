package lab3;
import java.util.LinkedList;

public class HashTable<K,V>{
    private LinkedList<Entry<K, V>>[] table;
    private int length;
    private int size;



    public HashTable(int length){
        this.length = length;
        this.table = new LinkedList[length];
        this.size = 0;
    }

    public HashTable(){
        this.length = 10;
        this.table = new LinkedList[length];
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K,V> entry: table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K,V>(key, value));
        size++;
    }

    public V get(K key){
        int index = hash(key);
        LinkedList<Entry<K,V>> list = table[index]; //создали массив из элементов которые хранятся по этому индексу в массиве
        if (list != null) {
            for (Entry<K,V> entry: list) {
                if (entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K,V>> list = table[index];
        if (list != null) {
            for (Entry<K,V> entry: list){
                if (entry.getKey().equals(key)){
                    list.remove(entry);
                    size --;
                }
            }
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }





    public int hash(K key){
        return Math.abs(key.hashCode() % length);//возвращает для любого объекта 32-битное число типа int
                                                // и находит остаток от деления на количество индексов
    }

}
