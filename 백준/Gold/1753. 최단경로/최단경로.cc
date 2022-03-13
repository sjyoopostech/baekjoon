#include <iostream>
#include <algorithm>
#include <queue>

class Element {
public :
    int dest;
    int weight;
    Element(int dest, int weight) {
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

    int V, E, start;
    std::cin >> V >> E >> start;

    std::vector<std::vector<Element>> vlist;
    for (int i = 0; i <= V; i++) {
        std::vector<Element> v;
        vlist.push_back(v);
    }

    for (int i = 0; i < E; i++) {
        int u, v, w;
        std::cin >> u >> v >> w;
        vlist.at(u).push_back(Element(v, w));
    }

    std::vector<int> visitweight(V+1, -1);
    std::priority_queue<Element, std::vector<Element>, Cmp> pq;
    pq.push(Element(start, 0));
    while (!pq.empty()) {
        Element e = pq.top();
        pq.pop();
        if (visitweight.at(e.dest) != -1) continue;
        visitweight.at(e.dest) = e.weight;
        for (Element v : vlist.at(e.dest)) {
            pq.push(Element(v.dest, e.weight + v.weight));
        }
    }

    for (int i = 1; i <= V; i++) {
        if (visitweight.at(i) == -1) std::cout << "INF";
        else std::cout << visitweight.at(i);
        std::cout << "\n";
    }

    return 0;
}
