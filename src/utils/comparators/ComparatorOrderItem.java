package utils.comparators;

import model.Item;
import model.OrderItem;

import java.util.Comparator;

/**
 * Created by mario on 15.05.2017.
 */
public class ComparatorOrderItem implements Comparator<OrderItem> {
    public static java.util.Comparator<OrderItem> itemOrderPriceComparator() {
        return new Comparator<OrderItem>() {
            public int compare(OrderItem one, OrderItem two) {
                if (one.getPrice() > two.getPrice()) {
                    return -1;
                } else if (one.getPrice() < two.getPrice()) {
                    return 1;
                }
                return 0;
            }
        };
    }
    public static java.util.Comparator<OrderItem> itemOrderQuantityComparator() {
        return new Comparator<OrderItem>() {
            public int compare(OrderItem one, OrderItem two) {
                if (one.getQuantity() > two.getQuantity()) {
                    return -1;
                } else if (one.getQuantity() < two.getQuantity()) {
                    return 1;
                }
                return 0;
            }
        };
    }
    public static java.util.Comparator<OrderItem> itemOrderIdComparator() {
        return new Comparator<OrderItem>() {
            public int compare(OrderItem one, OrderItem two) {
                if (one.getId() > two.getId()) {
                    return -1;
                } else if (one.getId() < two.getId()) {
                    return 1;
                }
                return 0;
            }
        };
    }
    public static java.util.Comparator<OrderItem> itemOrderModelComparator() {
        return new Comparator<OrderItem>() {
            public int compare(OrderItem one, OrderItem two) {
                return (one.getModel()).compareTo(two.getModel());
            }
        };
    }
    public static java.util.Comparator<OrderItem> itemOrderProducentComparator() {
        return new Comparator<OrderItem>() {
            public int compare(OrderItem one, OrderItem two) {
                return (one.getProducent()).compareTo(two.getProducent());
            }
        };
    }

    @Override
    public int compare(OrderItem orderItem, OrderItem t1) {
        return 0;
    }
}
