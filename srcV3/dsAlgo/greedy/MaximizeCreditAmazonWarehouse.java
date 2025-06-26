package dsAlgo.greedy;

import java.util.Arrays;

/**
 * Amazon operates numerous warehouses, with each warehouse i holding inventory[i] units of a particular product.
 * You and your co-worker are responsible for dispatching these items to fulfill customer orders, following a specific process:
 * When dispatching from warehouse i, you begin by reducing the inventory of the ith warehouse by dispatch1 units.
 * After your dispatch, your co-worker reduces the inventory by dispatch2 units.
 * This process repeats until the inventory of the ith warehouse reaches zero or becomes negative (i.e., inventory[i] ≤ 0).
 * For every warehouse that is emptied during your dispatch, you and your co-worker collectively earn 1 credit.
 * Your co-worker has the option to skip their turn, but they can only do this a limited number of times, defined by skips.
 * Your task is to determine the best strategy to maximize the total credits that both you and your co-worker can earn together.
 * Example
 * n = 6
 * inventory = [10, 6, 12, 8, 15, 1]
 * dispatch1 = 2
 * dispatch2 = 3
 * skips = 3
 * An optimal dispatch strategy is as follows:
 * Your co-worker skips 2 turns, allowing you to empty the inventory of the 1st warehouse (Inventory: 10 → 8 → 5 → 3 → 1 → -1).
 * Your co-worker doesn't skip any turns, and you empty the inventory of the 2nd warehouse (Inventory: 6 → 4 → 1 → -1).
 * Your co-worker doesn't skip any turns, and you empty the inventory of the 3rd warehouse (Inventory: 12 → 10 → 7 → 5 → 2 → 0).
 * Your co-worker skips 1 turn, and you drain the inventory of the 4th warehouse (Inventory: 8 → 6 → 3 → 1 → -1).
 * Your co-worker doesn't skip any turns, and they empty the inventory of the 5th warehouse (Inventory: 15 → 13 → 10 → 8 → 5 → 3 → 0).
 * Your co-worker doesn't skip any turns, and you empty the inventory of the 6th warehouse (Inventory: 1 → -1).
 * As a result, the 1st, 2nd, 3rd, 4th, and 6th warehouses were completely dispatched by you, and the two of you collectively earned 5 credits,
 * which is the maximum possible in this scenario.
 * Hence, the answer is 5.
 * Function Description
 * Complete the function getMaximumCredits in the editor below.
 * getMaximumCredits has the following parameters:
 *     int inventory[n]:  An array of integers denoting the inventory level of each warehouse.
 *     int dispatch1: An integer indicating your dispatch level per turn.
 *     int dispatch2: An integer indicating your co-worker's dispatch level per turn.
 *     int skips: An integer specifying the maximum number of times your co-worker can skip their turn.
 * Return
 *     int: the maximum number of credits both of you can achieve collectively.
 * Constraints
 * 1 ≤ n ≤ 105
 * 1 ≤ inventory[i] ≤ 109
 * 1 ≤ dispatch1, dispatch2, skips ≤ 109
 */
public class MaximizeCreditAmazonWarehouse {
    /*
     * Complete the 'getMaximumCredits' function below.
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY inventory
     *  2. INTEGER dispatch1
     *  3. INTEGER dispatch2
     *  4. INTEGER skips
     */

    public static int getMaximumCredits(int[] inventories, int dispatch1, int dispatch2, int maxSkips) {
        int dsum = dispatch1 + dispatch2;
        int[] skips = new int[inventories.length];
        for(int x = 0; x< inventories.length;x++){
            int inventory = inventories[x];
            for(int skip = 0 ; true; skip++){
                if((inventory + skip * dispatch2) % dsum > 0 && (inventory + skip * dispatch2) % dsum <= dispatch1){
                    skips[x] = skip;
                    break;
                }
            }
        }
        Arrays.sort(skips);
        int credit = 0;
        for(int x : skips){
            maxSkips = maxSkips - x;
            if(maxSkips < 0){
                break;
            }
            credit++;
        }
        return credit;
    }

    public static void main(String[] args) {
        if(getMaximumCredits(new int[]{10, 6, 12, 8, 15, 1}, 2, 3, 3) != 5) {System.out.println("failed");};
    }

}
