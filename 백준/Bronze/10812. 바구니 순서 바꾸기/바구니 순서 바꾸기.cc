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
        int start, end, mid;
        std::cin >> start >> end >> mid;
        while (start != mid) {
            int t = cnt[start];
            for (int j = start; j < end; j++) {
                cnt[j] = cnt[j+1];
            }
            cnt[end] = t;
            mid--;
        }
    }
    for (int i = 1; i <= N; i++) {
        std::cout << cnt[i] << " ";
    }

    return 0;
}
