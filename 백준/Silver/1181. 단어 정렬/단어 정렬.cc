#include <iostream>
#include <algorithm>
#include <vector>

bool CompareString(std::string a, std::string b) {
    if (a.size() != b.size()) return a.size() < b.size();
    return a < b;
}

int main() {
    int N;
    std::cin >> N;
    std::vector<std::string> StrVec;
    for (int i = 0; i < N; i++) {
        std::string s;
        std::cin >> s;
        StrVec.push_back(s);
    }
    std::sort(StrVec.begin(), StrVec.end(), CompareString);
    StrVec.erase(std::unique(StrVec.begin(), StrVec.end()), StrVec.end());
    for (std::string s : StrVec) {
        std::cout << s << std::endl;
    }
    return 0;
}
