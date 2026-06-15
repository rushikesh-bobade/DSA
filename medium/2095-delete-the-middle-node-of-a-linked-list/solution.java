        return head;
       }

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=head;

        while(fast!=null && fast.next==null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
