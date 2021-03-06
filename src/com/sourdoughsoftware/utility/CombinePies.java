package com.sourdoughsoftware.utility;
/**
 * This class provides a static function for combining weapons in
 * a binary search tree.
 */

import com.sourdoughsoftware.gamepieces.Pie;

public class CombinePies {
    /**
     *   returns the original weapon if it can not be combined otherwise it returns
     *   the higher level combined weapon
     * @param pie1 Pie to combine
     * @param pie2 Pie to combine
     * @param tree BST to look for pies
     * @return pie1 if not found in tree, parent pie if found in tree
     */
    public static Pie combine(Pie pie1, Pie pie2, ItemTree tree) {
        Node[] parentAndSibling = tree.getParentAndSibling(pie1);
        Pie sibling;
        if(parentAndSibling[1] != null) {
            sibling = (Pie) parentAndSibling[1].getItem();
            if (sibling == pie2) {
                return (Pie) parentAndSibling[0].getItem();
            }
        }
        return pie1;
    }
}
