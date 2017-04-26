package in.ashwanik.codility.builders;

import in.ashwanik.codility.nodes.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by AshwaniK on 7/10/2016.
 */
public class LinkedListBuilder {

    public static LinkedListNode<Integer> createIntegerDynamicLinkedList() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 27, 9, 37, 4, 57, 6));
        return createDynamicLinkedList(arrayList);
    }


    public static <T> LinkedListNode<T> createDynamicLinkedList(ArrayList<T> dataList) {
        Random random = new Random();
        LinkedListNode<T> head = new LinkedListNode<>(dataList.get(random.nextInt(dataList.size())));
        head.setNext(new LinkedListNode<>(dataList.get(random.nextInt(dataList.size()))));
        head.getNext().setNext(new LinkedListNode<>(dataList.get(random.nextInt(dataList.size()))));
        head.getNext().getNext().setNext(new LinkedListNode<>(dataList.get(random.nextInt(dataList.size()))));
        head.getNext().getNext().getNext().setNext(new LinkedListNode<>(dataList.get(random.nextInt(dataList.size()))));
        return head;
    }

    public static LinkedListNode<Integer> createDynamicLinkedList() {
        LinkedListNode<Integer> head = new LinkedListNode<>(4);
        head.setNext(new LinkedListNode<>(4));
        head.getNext().setNext(new LinkedListNode<>(37));
        head.getNext().getNext().setNext(new LinkedListNode<>(27));
        head.getNext().getNext().getNext().setNext(new LinkedListNode<>(1));
        return head;
    }
}
