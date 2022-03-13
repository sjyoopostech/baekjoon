#include <iostream>
#include <unordered_set>
#include <vector>
#include <algorithm>
#include <ctime>

bool IsDuplicated(int N, std::string str1, std::string str2, long long hashvalue[]) {
    int S1 = str1.size();
    std::unordered_set< long long> hashset;
    long long hashval = 0;
    for (int i = 0; i < N; i++) {
        hashval += hashvalue[str1.at(i) - 'a'];
    }
    hashset.insert(hashval);
    for (int i = N; i < S1; i++) {
        hashval += hashvalue[str1.at(i) - 'a'];
        hashval -= hashvalue[str1.at(i-N) - 'a'];
        hashset.insert(hashval);
    }

    int S2 = str2.size();
    hashval = 0;
    for (int i = 0; i < N; i++) {
        hashval += hashvalue[str2.at(i) - 'a'];
    }
    if (hashset.find(hashval) != hashset.end()) return true;
    for (int i = N; i < S2; i++) {
        hashval += hashvalue[str2.at(i) - 'a'];
        hashval -= hashvalue[str2.at(i-N) - 'a'];
        if (hashset.find(hashval) != hashset.end()) return true;
    }
    return false;
}

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    long long hashvalue[26];
    srand(time(NULL));
    for (int i = 0; i < 26; i++) {
        hashvalue[i] = 0;
        for (int j = 0; j < 3; j++) {
            hashvalue[i] += rand();
            hashvalue[i] <<= 16;
        }
        hashvalue[i] += rand();
    }

    std::string str1, str2;
    std::cin >> str1 >> str2;

    int start = 1;
    int end = std::min(str1.size(), str2.size());
    while (end > 0) {
        if (IsDuplicated(end, str1, str2, hashvalue)) {
            std::cout << end;
            return 0;
        }
        end--;
    }
    std::cout << '0';

    return 0;
}
