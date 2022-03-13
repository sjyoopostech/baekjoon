#include <iostream>
#include <algorithm>
#include <queue>

class Element {
public :
    long long dest;
    long long weight;
    Element(long long dest, long long weight) {
        this->dest = dest;
        this->weight = weight;
    }
};

class Cmp {
public:
    bool operator()(Element a, Element b) {
        return a.weight > b.weight;
    }
};

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int V, E;
    std::cin >> V >> E;

    std::vector<std::vector<Element>> vlist;
    for (int i = 0; i <= V; i++) {
        std::vector<Element> v;
        vlist.push_back(v);
    }

    for (int i = 0; i < E; i++) {
        int u, v, w;
        std::cin >> u >> v >> w;
        vlist.at(u).push_back(Element(v, w));
        vlist.at(v).push_back(Element(u, w));
    }

    int node1, node2;
    std::cin >> node1 >> node2;

    std::vector<int> visitweight1(V+1, -1);
    std::priority_queue<Element, std::vector<Element>, Cmp> pq;
    pq.push(Element(node1, 0));
    while (!pq.empty()) {
        Element e = pq.top();
        pq.pop();
        if (visitweight1.at(e.dest) != -1) continue;
        visitweight1.at(e.dest) = e.weight;
        for (Element v : vlist.at(e.dest)) {
            pq.push(Element(v.dest, e.weight + v.weight));
        }
    }

    std::vector<int> visitweight2(V+1, -1);
    pq.push(Element(node2, 0));
    while (!pq.empty()) {
        Element e = pq.top();
        pq.pop();
        if (visitweight2.at(e.dest) != -1) continue;
        visitweight2.at(e.dest) = e.weight;
        for (Element v : vlist.at(e.dest)) {
            pq.push(Element(v.dest, e.weight + v.weight));
        }
    }
    if (visitweight1.at(1) == -1 || visitweight1.at(node2) == -1 || visitweight1.at(V) == -1) std::cout << "-1";
    else std::cout << visitweight1.at(node2) + std::min(visitweight1.at(1) + visitweight2.at(V), visitweight2.at(1) + visitweight1.at(V));

    return 0;
}
