#include <iostream>
#include <algorithm>

int main() {
    int N, M;
    std::cin >> N >> M;
    int cnt[N+1];
    for (int i = 1; i <= N; i++) {
        cnt[i] = i;
    }
    for (int i = 0; i < M; i++) {
        int a, b;
        std::cin >> a >> b;
        std::swap(cnt[a], cnt[b]);
    }
    for (int i = 1; i <= N; i++) {
        std::cout << cnt[i] << " ";
    }

    return 0;
}
