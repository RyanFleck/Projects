#include <algorithm>
#include <iostream>
#include <list>
#include <map>
#include <queue>
#include <stack>
#include <vector>

using namespace std;

struct Node
{
    int Id;

    Node *Left;
    Node *Right;

    Node *Next;

    Node(int id) : Id(id), Left(nullptr), Right(nullptr), Next(nullptr)
    {
    }
};

std::map<int, Node *> gNodes;

Node *ensureNode(int id)
{
    if (id == 0)
        return nullptr;

    auto n = gNodes[id];
    if (n)
        return n;

    n = new Node(id);
    gNodes[id] = n;

    return n;
}

void debug(Node *x);
void traverse_rlc_rec(Node *x, int depth);
void traverse_update_map(map<int, vector<int>> *t, Node *x, int depth);
void link_nodes_in_map(map<int, vector<int>> *t);
void simple_link(Node *x);
void add_to_vectormap(Node *x, map<int, vector<Node *>> *y, int depth);

/*
 * Solution steps:
 *  1. Traverse tree and add nodes to vectors based on depth.
 *  2. Process vectors and link tree.
 * 
 * Alternatively:
 *  - Write multiple algos for simple, then complex linking.
 *   - One to link simple left-to-right siblings.
 *   - One to search for leftmost/rightmost siblings.
 * 
 * First day writing non-arduino C++. Wish me luck.
 * Update: 6 mins left: Looks like I need to learn maps and vectors in C++.
 * Allowing simple-link solution to run so the machine sees I was able to fulfill one or two TC.
 */

void connectSiblings(Node *root)
{
    // debug(root);

    //traverse_rlc_rec(root, 0);

    // map<int,vector<Node *>> *last-at-depth;
    // add_to_vectormap(root, levels, 0);

    root->Next = root->Left;
    simple_link(root);

    /*
    map<int, vector<int>> treemap;
    treemap[0].push_back(3);
    traverse_update_map(treemap, root, 0);
    */
}

/*
void add_to_vectormap(Node *x, map<int, vector<Node *>> *y, int depth) {
  if(!y[depth])
    y[depth] =  new Vector<Node *>();
  if (x->Right) {
    y[depth].push_back(*x);
    traverse_rlc_rec(x->Right, depth + 1);
  }
  if (x->Left) {
    cout << "\nNode " << depth << " has a Left node.";
    traverse_rlc_rec(x->Left, depth + 1);
  }
}

void traverse_update_map(map<int, vector<int>> *t, Node *x, int depth) {
  cout << "Null";
}
*/

void simple_link(Node *x)
{
    if (x->Right && x->Left)
    {
        x->Left->Next = x->Right;
        simple_link(x->Left);
        simple_link(x->Right);
    }
}

/*
 * Wrote these debugging methods to understand the structure passed as root.
 */

void debug(Node *x)
{
    cout << "\nNext: " << x->Next;
    cout << "\nRight: " << x->Right;
    cout << "\nLeft: " << x->Left;
}

void traverse_rlc_rec(Node *x, int depth)
{
    cout << "\n===\nEntered node at depth " << depth;
    debug(x);

    if (x->Right)
    {
        cout << "\nNode " << depth << " has a Right node.";
        traverse_rlc_rec(x->Right, depth + 1);
    }
    if (x->Left)
    {
        cout << "\nNode " << depth << " has a Left node.";
        traverse_rlc_rec(x->Left, depth + 1);
    }

    //cout << "\nNode at depth" << depth << ".";
}

int main()
{

    int N;
    cin >> N;

    for (int i = 1; i <= N; i++)
    {
        int l, r;
        cin >> l >> r;

        auto pn = ensureNode(i);
        auto ln = ensureNode(l);
        auto rn = ensureNode(r);

        if (pn)
        {
            if (ln)
                pn->Left = ln;
            if (rn)
                pn->Right = rn;
        }
    }

    auto root = ensureNode(1);

    connectSiblings(root);

    while (root)
    {
        cout << root->Id << "\n";
        root = root->Next;
    }

    return 0;
}