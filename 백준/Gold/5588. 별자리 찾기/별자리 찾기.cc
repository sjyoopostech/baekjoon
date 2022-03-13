#include <iostream>
#include <unordered_set>
#include <vector>
#include <algorithm>
#include <ctime>

int main() {
    int N1;
    std::cin >> N1;
    std::vector<long long> point1;
    for (int i = 0; i < N1; i++) {
        long long x, y;
        std::cin >> x >> y;
        point1.push_back(x*1000000000+y);
    }

    int N2;
    std::cin >> N2;
    std::unordered_set<long long> point2;
    for (int i = 0; i < N2; i++) {
        long long x, y;
        std::cin >> x >> y;
        point2.insert(x*1000000000+y);
    }


    for (long long p2 : point2) {
        long long x = point1.at(0);
        long long xx = p2-x;
        bool isgood = true;
        for (long long p1 : point1) {
            if (point2.find(p1 + xx) == point2.end()) {
                isgood = false;
                break;
            }
        }
        if (isgood) {
            int xxx = xx/1000000000;
            int yyy = xx%1000000000;
            if (yyy >= 900000000) {
                xxx++;
                yyy-= 1000000000;
            }
            if (yyy <= -900000000) {
                xxx--;
                yyy+= 1000000000;
            }

            std::cout << xxx << " " << yyy;
        }
    }

    return 0;
}
