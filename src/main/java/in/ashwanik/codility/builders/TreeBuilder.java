package in.ashwanik.codility.builders;

import in.ashwanik.codility.nodes.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by AshwaniK on 7/10/2016.
 */
public class TreeBuilder {

    public static TreeNode<Integer> createIntegerDynamicTree() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 27, 9, 37, 4, 57, 6));
        return createDynamicTree(arrayList);
    }


    public static <T> TreeNode<T> createDynamicTree(List<T> dataList) {
        Random random = new Random();
        TreeNode<T> root = new TreeNode<>(dataList.get(random.nextInt(dataList.size())));
        root.setLeft(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        root.setRight(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        root.getLeft().setLeft(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        root.getRight().setLeft(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));

        root.getLeft().setRight(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        root.getRight().setRight(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        return root;

    }


}
