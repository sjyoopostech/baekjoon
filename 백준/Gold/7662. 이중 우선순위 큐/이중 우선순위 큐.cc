#include <iostream>
#include <algorithm>
#include <queue>

class Element {
public :
    int x;
    bool deleted;
    Element(int x) {
        this->x = x;
        this->deleted = false;
    }
};

struct CmpSmall {
    bool operator()(Element* a, Element* b) {
        return a->x > b->x;
    }
};

struct CmpBig {
    bool operator()(Element* a, Element* b) {
        return a->x < b->x;
    }
};

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int T;
    std::cin >> T;
    for (int test = 0; test < T; test++) {
        int N;
        std::cin >> N;
        std::priority_queue<Element*, std::vector<Element*>, CmpSmall> small;
        std::priority_queue<Element*, std::vector<Element*>, CmpBig> big;

        for (int i = 0; i < N; i++) {
            char cmd;
            int number;
            std::cin >> cmd >> number;
            if (cmd == 'I') {
                Element* e = new Element(number);
                small.push(e);
                big.push(e);
            }
            if (cmd == 'D') {
                if (number == -1) {
                    while (!small.empty()) {
                        if (!small.top()->deleted) break;
                        small.pop();
                    }
                    if (small.empty()) continue;
                    small.top()->deleted = true;
                    small.pop();
                }
                else {
                    while (!big.empty()) {
                        if (!big.top()->deleted) break;
                        big.pop();
                    }
                    if (big.empty()) continue;
                    big.top()->deleted = true;
                    big.pop();
                }
            }
        }
        while (!small.empty()) {
            if (!small.top()->deleted) break;
            small.pop();
        }
        while (!big.empty()) {
            if (!big.top()->deleted) break;
            big.pop();
        }

        if (small.empty() || big.empty()) std::cout << "EMPTY\n";
        else std::cout << big.top()->x << " " << small.top()->x << "\n";

    }

    return 0;
}
