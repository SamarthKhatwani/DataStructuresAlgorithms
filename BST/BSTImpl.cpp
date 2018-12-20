/*
 * BSTImpl.cpp
 *
 *  Created on: Nov 23, 2018
 *      Author: Asus
 */

// Binary search tree implementation in c++

#include<iostream>
#include<queue>
using namespace std;

struct BstNode{
	BstNode* left;
	int data;
	BstNode* right;
};

BstNode* getNewNode(int data){
	BstNode* newNode= new BstNode;
	newNode->data=data;
	newNode->left=NULL;
	newNode->right=NULL;
	return newNode;
}

BstNode* insert(BstNode* root, int data){
	if(root==NULL){
		root=getNewNode(data);

	}
	else if(data<= root->data){
		root->left=insert(root->left,data);
	}
	else if(data>root->data){
		root->right=insert(root->right,data);
	}
	return root;
}

BstNode* search(BstNode* root, int data){
	if(root==NULL){
		return NULL;
	}
	else if(data==root->data){
		return root;
	}
	else if(data<= root->data){
		return search(root->left,data);
	}
	else if(data> root->data){
		return search(root->right,data);
	}
}

BstNode* findMinElement(BstNode* root){

	if(root==NULL){
		return root;
	}
	else if(root->left==NULL){
		return root;
	}
	else {
		return findMinElement(root->left);
	}
}

BstNode* findMaxElement(BstNode* root){

	if(root==NULL){
		return root;
	}
	else if(root->right==NULL){
		return root;
	}
	else {
		return findMaxElement(root->right);
	}
}
int findHeight(BstNode* root){
	if(root->left==NULL && root->right==NULL){
		return 0;
	}
	else if(root->left!=NULL && root->right==NULL){
		return 1+ findHeight(root->left);
	}
	else if(root->right!=NULL && root->left==NULL){
		return 1+ findHeight(root->right);
	}
	else{
		int leftHeight=findHeight(root->left);
		int rightHeight=findHeight(root->right);
		if(leftHeight<rightHeight){
			return 1+rightHeight;
		}
		else{
			return 1+leftHeight;
		}
	}
}

void levelOrderTraversal(BstNode* root){

	if(root==NULL){
		return;
	}
	queue<BstNode*> nodeQ;
	nodeQ.push(root);

	while(nodeQ.size()>0){
		BstNode* temp=nodeQ.front();
		cout<<temp->data<<" ";
		if(temp->left!=NULL && temp->right==NULL){
			nodeQ.push(temp->left);
		}
		else if(temp->right!=NULL && temp->left==NULL){
			nodeQ.push(temp->right);
		}
		else if(temp->right!=NULL && temp->left!=NULL){
			nodeQ.push(temp->left);
			nodeQ.push(temp->right);
		}
		else{

		}
		nodeQ.pop();
	}

}
void preOrderTraversal(BstNode* root){
	if(root==NULL){
		return;
	}
	else{
		cout<<root->data<<" ";
		preOrderTraversal(root->left);
		preOrderTraversal(root->right);
	}
}

void inOrderTraversal(BstNode* root){
	if(root==NULL){
		return;
	}
	else{
		inOrderTraversal(root->left);
		cout<<root->data<<" ";
		inOrderTraversal(root->right);
	}
}

void postOrderTraversal(BstNode* root){
	if(root==NULL){
		return;
	}
	else{
		postOrderTraversal(root->left);
		postOrderTraversal(root->right);
		cout<<root->data<<" ";
	}
}

BstNode* deleteNode(BstNode* root, int data){

	if(root== NULL){
		return root;
	}
	else if(data < root->data){
		root->left=deleteNode(root->left,data);
	}
	else if(data> root->data){
		root->right=deleteNode(root->right,data);
	}
	else{
		//case 1: No child
		if(root->left==NULL && root->right==NULL){
			delete root;
			root=NULL;
		}
		//case 2: 1 child
		else if(root->left==NULL){
			BstNode* temp=root;
			root=root->right;
			delete temp;
		}
		else if(root->right==NULL){
			BstNode* temp=root;
			root=root->left;
			delete temp;
		}
		//case 3: 2 chilren
		else{
			BstNode* temp= findMinElement(root->right);
			root->data= temp->data;
			root->right= deleteNode(root->right, temp->data);
		}
	}
	return root;
}

BstNode* getInorderSuccessor(BstNode* root, int data){

	// search the node for which the succesor needs to be found
	BstNode* current=search(root, data);
	if(current==NULL){
		return NULL;
	}
	if(current->right!=NULL){
		return findMinElement(current->right);
	}
	else{
		BstNode* successor=NULL;
		BstNode* ancestor=root;
		while(ancestor!=current){
			if(current->data <ancestor->data){
				successor= ancestor;
				ancestor=ancestor->left;
			}
			else{
				ancestor=ancestor->right;
			}
		}
		return successor;
	}
}



int main(){
	cout<<"Lets implement a Binary Search tree, yayy!! "<<endl;
	BstNode* root=NULL;
	root=insert(root,15);
	root=insert(root,10);
	root=insert(root,20);
	root=insert(root,25);
	root=insert(root,8);
	root=insert(root,12);
	root=insert(root,4);
	root=insert(root,104);
	root=insert(root,105);

	int number;
	cout<<"Enter number to search- ";
	cin>>number;
	if(search(root,number)!=NULL){
		cout<<"Number found in the tree"<<endl;
	}
	else{
		cout<<"Not found!!"<<endl;
	}

	BstNode* minElement=findMinElement(root);
	cout<<"The minimum element of this binary tree is- "<<minElement->data<<endl;

	BstNode* maxElement=findMaxElement(root);
	cout<<"The maximum element of this binary tree is- "<<maxElement->data<<endl;

	int treeHeight=findHeight(root);
	cout<<"Height of this tree is- "<<treeHeight<<endl;

	cout<<"Level Order Traversal- ";
	levelOrderTraversal(root);
	cout<<endl;
	cout<<"Pre Order Traversal- ";
	preOrderTraversal(root);
	cout<<endl;
	cout<<"In Order Traversal- ";
	inOrderTraversal(root);
	cout<<endl;

	root=deleteNode(root,12);
	cout<<"After deletion- ";
	inOrderTraversal(root);
	cout<<endl;
	cout<<"Enter number to search- ";
	cout<<12<<endl;
	if(search(root,number)!=NULL){
			cout<<"Number found in the tree"<<endl;
	}
	else{
			cout<<"Not found!!"<<endl;
	}
	cout<<"Inorder successor of 20- ";
	BstNode* successor=getInorderSuccessor(root, 20);
	cout<<successor->data;







}


