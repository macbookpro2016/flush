package medium;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ÊÇ·ñ½øÎ»
        boolean nextAddOne = false;
        List<ListNode> nodeList = new ArrayList();
        do{
            int node1CurrentResult = 0;
            int node2CurrentResult = 0;
            int sum = 0;
            if(l1 != null){
                node1CurrentResult = l1.val;
            }
            if(l2 != null){
                node2CurrentResult = l2.val;
            }
            sum += node1CurrentResult + node2CurrentResult;
            if(nextAddOne){
                sum += 1;
            }
            nextAddOne = sum >= 10 ? true : false;
            ListNode result = new ListNode(nextAddOne ? (sum - 10) : sum);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            nodeList.add(result);
        }while(l1 != null || l2 != null || nextAddOne);
        for(int j = 0; j < nodeList.size() - 1; j++){
            nodeList.get(j).next = nodeList.get(j + 1);
        }
        return nodeList.get(0);
    }

    /**
     * 342 + 465 = 807
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}