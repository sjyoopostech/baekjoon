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
        int start, end;
        std::cin >> start >> end;
        while (start < end) {
            std::swap(cnt[start], cnt[end]);
            start++;
            end--;
        }
    }
    for (int i = 1; i <= N; i++) {
        std::cout << cnt[i] << " ";
    }

    return 0;
}
