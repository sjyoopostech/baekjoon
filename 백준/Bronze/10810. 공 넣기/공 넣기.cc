#include <iostream>
#include <algorithm>

int main() {
    int N, M;
    std::cin >> N >> M;
    int cnt[N+1];
    std::fill_n(cnt, N+1, 0);
    for (int i = 0; i < M; i++) {
        int start, end, num;
        std::cin >> start >> end >> num;
        for (int j = start; j <= end; j++) {
            cnt[j] = num;
        }
    }
    for (int i = 1; i <= N; i++) {
        std::cout << cnt[i] << " ";
    }

    return 0;
}
