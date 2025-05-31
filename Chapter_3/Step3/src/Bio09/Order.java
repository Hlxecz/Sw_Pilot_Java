package Bio09;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Order {
    private List<OrderItem> orderItemList = new ArrayList<>();
    private String customerName;
    private LocalDateTime orderTime;

    public Order(String customerName, LocalDateTime orderTime, OrderItem orderItem) {
        this.customerName = customerName;
        this.orderTime = orderTime;
        if(orderItem.getMenu() instanceof SandWich sandwich){
            if(sandwich.getExpiryDate().isBefore(orderTime.toLocalDate())){
                //Time 까지 포함하고 있으니까 orderItem 의 LocalDate 타입으로 맞춰준다
                System.out.println("주문할 수 없는 상품입니다. (" +
                        sandwich.getName() + ", 만료날짜: " + sandwich.getExpiryDate() + ")");
                return; // 또는 throw new IllegalArgumentException(...) 로 막기
            }
        }
        orderItemList.add(orderItem);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public int calculateTotal() {
        int total = 0;
        for (OrderItem item : orderItemList) {
            total += item.getTotalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        StringBuilder sb = new StringBuilder();
        sb.append("고객: ").append(customerName).append("\n");
        sb.append("주문 시각: ").append(orderTime.format(formatter)).append("\n\n");

        for (OrderItem item : orderItemList) {
            sb.append(item.toString()).append("\n");
        }

        sb.append("\n총 금액: ").append(calculateTotal()).append("원\n");

        return sb.toString();
    }


}
