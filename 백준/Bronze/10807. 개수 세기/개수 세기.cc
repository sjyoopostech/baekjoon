#include <iostream>
#include <queue>

int main() {
    int N;
    std::cin >> N;
    int cnt[201];
    std::fill_n(cnt, 201, 0);
    for (int i = 0; i < N; i++) {
        int num;
        std::cin >> num;
        cnt[num+100]++;
    }
    int num;
    std::cin >> num;
    std::cout << cnt[num+100];

    return 0;

}
