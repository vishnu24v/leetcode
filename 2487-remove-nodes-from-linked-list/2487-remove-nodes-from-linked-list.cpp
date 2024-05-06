/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode *reverse(ListNode *head)
    {
        ListNode *curr, *nxt, *prv;
        prv = NULL;
        curr = head;
 
        while (curr)
        {
            nxt = curr->next;
            curr->next = prv;
            prv = curr;
 
            curr = nxt;
        }
 
        return prv;
    }
 
    void remove(ListNode *head)
    {
        ListNode *prv = head;
        int ma = head->val;
 
        while (head)
        {
            ma = max(ma, head -> val);
            if (head->val < ma)
            {
                prv->next = head->next;
            }
            else
            {
                prv = head;
            }
            
            head = head -> next;
        }
    }
 
    ListNode *removeNodes(ListNode *head)
    {
        head = reverse(head);
        remove(head);
        return reverse(head);   
    }
};