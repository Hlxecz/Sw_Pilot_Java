package Bio09;

import Bio09.Enum.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

import static Bio09.Enum.CoffeeType.*;
import static Bio09.Enum.DrinkType.*;
import static Bio09.Enum.Sandwichingredient.*;
import static Bio09.Enum.Size.*;

public class BiodomeFamily09 {
    public static void main(String[] args) {
        OrderList list = new OrderList();

        // 메뉴 생성
        Coffee blend = new Coffee(BLEND, TALL);
        Coffee dark = new Coffee(DARK, SHORT);
        Coffee decaf = new Coffee(DECAF, VENTI);

        Drink camomile = new Drink(CAMOMILE, TALL);
        Drink juice = new Drink(ORANGE_JUICE, SHORT);
        Drink water = new Drink(WATER, VENTI);

        SandWich vegetable = new SandWich(VEGETABLE);
        SandWich ham = new SandWich(HAM);
        SandWich cheese = new SandWich(CHEESE); // 유통기한 지난 것

        System.out.println("커피가 추가되었습니다. " + BLEND);
        System.out.println("커피가 추가되었습니다. " + DARK);
        System.out.println("커피가 추가되었습니다. " + DECAF);

        System.out.println("음료가 추가되었습니다. " + CAMOMILE);
        System.out.println("음료가 추가되었습니다. " + ORANGE_JUICE);
        System.out.println("음료가 추가되었습니다. " + WATER);

        System.out.println("샌드위치가 추가되었습니다. " + vegetable);
        System.out.println("샌드위치가 추가되었습니다. " + ham);
        System.out.println("샌드위치가 추가되었습니다. " + cheese);



        System.out.println();

        // 주문 1 - 커피 2잔, 샌드위치 1개
        Order order1 = new Order("제이미", LocalDateTime.of(2123, 10, 7, 14, 5, 32),
                new OrderItem(blend, 2));
        order1.addOrderItem(new OrderItem(vegetable, 1));
        list.addOrder(order1);

        System.out.println("=== 주문이 추가되었습니다. ===");
        System.out.println(order1);

        // 주문 2 - 음료 1개
        Order order2 = new Order("레냐", LocalDateTime.of(2123, 10, 7, 14, 6, 15),
                new OrderItem(camomile));
        list.addOrder(order2);

        System.out.println("=== 주문이 추가되었습니다. ===");
        System.out.println(order2);

        // 주문 3 - 유통기한 지난 샌드위치
        System.out.println("\n--\n치즈 샌드위치 주문 시도...");
        Order order3 = new Order("미나", LocalDateTime.of(2123, 10, 7, 15, 0, 0),
                new OrderItem(cheese)); // 내부에서 유통기한 검사 및 거절됨

        System.out.println("\n--\n");

        // 주문 전체 출력
        list.AllOrder();
    }
}
