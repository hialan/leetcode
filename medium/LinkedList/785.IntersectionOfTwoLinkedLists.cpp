#include <iostream>

using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
  
class Solution {
private: 
    int getLength(ListNode *node) {
        int len = 0;
        while(node != NULL) {
            len ++;
            node = node->next;
        }
        return len;
    }
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA = this->getLength(headA);
        int lenB = this->getLength(headB);
        int len = lenA;
        
        if(lenA > lenB) {
            for(int diff = lenA - lenB ; diff > 0 ; diff--) {
                headA = headA->next;
            }

            len = lenB;
        } else if (lenB > lenA) {
            for(int diff = lenB - lenA ; diff > 0 ; diff--) {
                headB = headB->next;
            }

            len = lenA;
        }

        while(headA != NULL && headB != NULL) {
            if(headA == headB) {
                return headA;
            } else {
                headA = headA->next;
                headB = headB->next;
            }
        }

        return NULL;
    }
};

/* best solution */
/*
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *p1 = headA;
        ListNode *p2 = headB;
        
        if (p1 == NULL || p2 == NULL) return NULL;

        while (p1 != NULL && p2 != NULL && p1 != p2) {
            p1 = p1->next;
            p2 = p2->next;
            if (p1 == p2) return p1;
            if (p1 == NULL) p1 = headB;
            if (p2 == NULL) p2 = headA;
        }
        
        return p1;
    }
};
*/

int main() {
    ListNode a1 = ListNode(1),
        a2 = ListNode(2),
        b1 = ListNode(3),
        b2 = ListNode(4),
        b3 = ListNode(5),
        c1 = ListNode(6),
        c2 = ListNode(7),
        c3 = ListNode(8);

    Solution sol = Solution();

    a1.next = &a2;
    a2.next = &c1;
    b1.next = &b2;
    b2.next = &b3;
    b3.next = &c1;
    c1.next = &c2;
    c2.next = &c3;

    ListNode *result = sol.getIntersectionNode(&a1, &b1);

    cout << result->val << endl;

    return 0;
}
