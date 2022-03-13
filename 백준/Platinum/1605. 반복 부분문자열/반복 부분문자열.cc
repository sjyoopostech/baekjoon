#include <iostream>
#include <unordered_set>
#include <unordered_map>
#include <vector>

long long GetRExpN(long long R, long long N, long long M) {
    if (N == 0) return 1;
    if (N == 1) return R;
    long long n2 = GetRExpN(R, N/2, M);
    long long n = n2*n2%M;
    if (N % 2 == 1) n = n * R % M;
    return n;
}

bool IsDuplicated(int N, std::string str) {
    long long r = 31;
    long long M = 100050001;
    long long hashval = 0;
    for (int i = 0; i < N; i++) {
        hashval += str.at(i) - 96;
        if (i != N-1) hashval *= r;
        hashval %= M;
    }
    std::unordered_map<long long, std::vector<int>> set;
    std::vector<int> v;
    v.push_back(0);
    set.insert(std::make_pair(hashval, v));

    long long RN = GetRExpN(r, N-1, M);
    int S = str.size();
    for (int i = N; i < S; i++) {
        hashval -= ((str.at(i-N) - 96) * RN) % M;
        if (hashval < 0) hashval += M;
        hashval *= r;
        hashval += str.at(i) - 96;
        hashval %= M;
        if (set.find(hashval) != set.end()) {
            std::vector<int>& vector = set.at(hashval);
            for (int start : vector) {
                if (str.substr(start, N).compare(str.substr(i+1-N, N)) == 0) {
                    return true;
                }
            }
            vector.push_back(i+1-N);
        }
        else {
            std::vector<int> v;
            v.push_back(i+1-N);
            set.insert(std::make_pair(hashval, v));
        }
    }
    return false;
}

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::string str;
    std::cin >> N >> str;

    int start = 1;
    int end = N-1;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (IsDuplicated(mid, str)) start = mid+1;
        else end = mid-1;
    }
    std::cout << end;

    return 0;
}
