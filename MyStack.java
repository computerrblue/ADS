public class MyStack<T> {
    private MyArrayList<T> list;

    
    public MyStack(){

        list = new MyArrayList<>();
    }

    public void push(T element){
        list.add(element);
    }

    public T pop(){
    if(isEmpty())throw new RuntimeException("Stack Empty");
    return list.remove(list.size() - 1);
    }

    public T peek(){
     if(isEmpty())throw new RuntimeException("Stack Empty");
    return list.get(list.size() - 1);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int size(){
        return list.size();
    }


}
