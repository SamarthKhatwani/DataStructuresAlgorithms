/*
 * addnode.cpp
 *
 *  Created on: Oct 14, 2018
 *      Author: samarth
 */

#include<iostream>
using namespace std;

struct Node{

	int data;
	Node *link;
};

typedef Node* NodePtr;

void head_insert(NodePtr& head, int the_number){
	NodePtr temp_ptr;
	temp_ptr= new Node;
	temp_ptr->data=the_number;
	temp_ptr->link=head;
	head=temp_ptr;
}

NodePtr tail_insert(NodePtr& tail, int the_number){
	NodePtr new_tail;
	new_tail=new Node;
	new_tail->data=the_number;
	new_tail->link=nullptr;
	tail->link=new_tail;
	return new_tail;
}

void insert(NodePtr& after_me, int the_number){
	NodePtr temp_ptr;
	temp_ptr=new Node;
	temp_ptr->data=the_number;
	temp_ptr->link=after_me->link;
	after_me->link=temp_ptr;
}
void insert(NodePtr& head,int data, int position){
	if(position==1){
		head_insert(head,data);
		return;
	}
	NodePtr temp= new Node;
	temp->data=data;
	temp->link=NULL;
	NodePtr itr=head;
	int nodeCount=1;
	while(itr!=NULL){
		if(nodeCount==position-1){
			temp->link=itr->link;
			itr->link=temp;
			break;
		}
		itr=itr->link;
		nodeCount++;

	}

}
void remove(NodePtr& head,int position){

	if(position==1)
	{
		NodePtr temp=head;
		head=temp->link;
		delete temp;
		return;

	}
	int count=1;
	for(NodePtr itr=head;itr!=NULL;itr=itr->link){
		if(count==position-1){
			NodePtr temp=itr->link;
			itr->link=temp->link;
			delete temp;
			return;

		}
		count++;
	}

}
void iterativeReverse(NodePtr& head){
	NodePtr tempHead=head;
	NodePtr curr=NULL;
	NodePtr	prev=NULL;
	NodePtr next=NULL;
	prev=head;
	int count=0;
	curr=head->link;
	if(head->link==NULL){
		return;
	}
	else{
		while(curr!=NULL){
			if(curr->link!=NULL){
				next=curr->link;
			}
			else{
				next=NULL;
			}
			curr->link=prev;
			if(count==0){
				prev->link=NULL;
			}
			prev=curr;
			curr=next;
			count++;
		}
	}
	head=prev;
	return;
}

NodePtr search(NodePtr head, int target){
	NodePtr here;
	here=head;
	if(here!=nullptr)
	{
		while(here->data!=target && here->link!=nullptr)
		{
			here=here->link;
			if(here->data==target)
			{
				return here;
			}
			else
			{
				return nullptr;
			}
		}
	}
	else
	{
		return nullptr;
	}
}

void printList(NodePtr head){
	NodePtr itr;
		for(itr=head;itr!=nullptr;itr=itr->link){
			cout<<(itr->data)<<" ";
		}
}

void interleaveList(NodePtr& list1h, NodePtr& list2h){
	NodePtr temp1;
	NodePtr temp2;
	NodePtr temp3;
	NodePtr temp4;
	while(list1h->link!=NULL || list2h->link!=NULL){
		temp1=list1h->link;
		temp2=list2h->link;
		list1h->link=list2h;
		list2h->link=temp1;
		list1h=temp1;
		list2h=temp2;
	}

	printList(list1h);

}

void inter_leave_list(NodePtr list1h, NodePtr list2h){
	NodePtr next1;//=list1h->link;
	NodePtr next2;//=list2h->link;
	NodePtr curr1=list1h;
	NodePtr curr2=list2h;
	NodePtr headerForPrint=list1h;
	while(curr1!=NULL && curr2!=NULL){
		list1h=curr1;
		list2h=curr2;
		next1=list1h->link;
		next2=list2h->link;

		list1h->link=list2h;
		if(next1==NULL)
		{
			break;
		}
		else{
			list2h->link=next1;
		}

		curr1=next1;
		curr2=next2;


	}
	printList(headerForPrint);
}

int main(){

	//creating the head node
	NodePtr l1=new Node;
	l1->data=1;
	l1->link=nullptr;

	head_insert(l1,2);
	head_insert(l1,3);
	head_insert(l1,4);
	head_insert(l1,14);
	head_insert(l1,15);
	head_insert(l1,9);
	head_insert(l1,10);

	//lets iterate
	/*NodePtr itr;s
	for(itr=l1;itr!=nullptr;itr=itr->link){
		cout<<(itr->data)<<" ";
	}*/
	printList(l1);

	cout<<endl;

	NodePtr l2=new Node;
		l2->data=5;
		l2->link=nullptr;

		head_insert(l2,6);
		head_insert(l2,7);
		head_insert(l2,8);
		insert(l2,3,4);





		//lets iterate
		/*NodePtr itr;
		for(itr=l1;itr!=nullptr;itr=itr->link){
			cout<<(itr->data)<<" ";
		}*/
		printList(l2);
		cout<<endl;
		remove(l2,2);
		printList(l2);
		cout<<endl;
		remove(l2,3);
		printList(l2);
		cout<<endl;
		remove(l2,1);
		printList(l2);

		cout<<endl;

		inter_leave_list(l1,l2);
		cout<<endl;
		printList(l1);
		cout<<endl;

		NodePtr l3=new Node;
		l3->data=20;
		l3->link=nullptr;

		head_insert(l3,21);
		head_insert(l3,22);
		head_insert(l3,23);

		printList(l3);
		iterativeReverse(l3);
		cout<<endl;
		printList(l3);
	//tail insert


	/*NodePtr result=search(l1,3);
	if(result!=nullptr){
		cout<<"Element found!!";
	}
	else{
		cout<<"Element not found :(";
	}


	cout<<endl;

	insert(result,6);


	printList(l1);

		cout<<endl;*/







}
