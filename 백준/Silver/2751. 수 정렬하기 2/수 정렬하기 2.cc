#include <iostream>
#include <algorithm>

int main() {

    int N;
    scanf("%d", &N);
    std::vector<int> v;
    for (int i = 0; i < N; i++) {
        int number;
        scanf("%d", &number);
        v.push_back(number);
    }
    std::sort(v.begin(), v.end());
    v.erase(std::unique(v.begin(), v.end()), v.end());

    for (int num : v) {
        printf("%d\n", num);
    }
}
