package utils.comparators;

import model.Item;

import java.util.Comparator;

/**
 * Created by mario on 05.05.2017.
 */
public class ComparatorItem implements Comparator<Item>{


    public static java.util.Comparator<Item> itemPriceComparator() {
        return new Comparator<Item>() {
            public int compare(Item one, Item two) {
                if (one.getPrice() > two.getPrice()) {
                    return -1;
                } else if (one.getPrice() < two.getPrice()) {
                    return 1;
                }
                return 0;
            }
        };
    }
    public static java.util.Comparator<Item> itemStockComparator() {
        return new Comparator<Item>() {
            public int compare(Item one, Item two) {
                if (one.getStock() > two.getStock()) {
                    return -1;
                } else if (one.getStock() < two.getStock()) {
                    return 1;
                }
                return 0;
            }
        };
    }
    public static java.util.Comparator<Item> itemIdComparator() {
        return new Comparator<Item>() {
            public int compare(Item one, Item two) {
                if (one.getId() > two.getId()) {
                    return -1;
                } else if (one.getId() < two.getId()) {
                    return 1;
                }
                return 0;
            }
        };
    }
    public static java.util.Comparator<Item> itemModelComparator() {
        return new Comparator<Item>() {
            public int compare(Item one, Item two) {
                return (one.getModel()).compareTo(two.getModel());
            }
        };
    }
    public static java.util.Comparator<Item> itemProducentComparator() {
        return new Comparator<Item>() {
            public int compare(Item one, Item two) {
                return (one.getProducent()).compareTo(two.getProducent());
            }
        };
    }
    
    
    
    
    
    
    
    
    @Override
    public int compare(Item item, Item t1) {
        return 0;
    }
}
