package Bio09;

import java.util.LinkedList;
import java.util.Queue;

public class OrderList {
    private Queue<Order> orderlist;

    public OrderList() {
        this.orderlist = new LinkedList<>();
    }

    public void addOrder(Order order){
        this.orderlist.offer(order);
    }

    public Order getNextOrder(){
        return orderlist.poll();
    }

    public boolean isEmpty(){
        return orderlist.isEmpty();
    }

    public void AllOrder(){
        int i = 1;
        for(Order o : orderlist){
            System.out.println("주문"+ i++ +"." );
            System.out.println(o);
        }
    }


}
