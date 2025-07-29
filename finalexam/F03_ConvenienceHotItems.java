import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int qty = Integer.parseInt(parts[1]);
            items.add(new Item(name, qty));
        }

        for (int i = 1; i < items.size(); i++) {
            Item key = items.get(i);
            int j = i - 1;
            while (j >= 0 && items.get(j).qty < key.qty) {
                items.set(j + 1, items.get(j));
                j--;
            }
            items.set(j + 1, key);
        }

        int limit = Math.min(10, items.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(items.get(i).name + " " + items.get(i).qty);
        }

        sc.close();
    }

    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：
 * 使用插入排序，對每個商品都往前比較插入位置。
 * 最壞情況下，每個元素都要跟前面所有項目比較並移動。
 * 所以整體時間複雜度是平方等級。
 */

