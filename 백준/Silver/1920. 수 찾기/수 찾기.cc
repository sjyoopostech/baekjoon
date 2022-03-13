#include <iostream>
#include <algorithm>

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::cin >> N;
    int array[N];
    for (int i = 0; i < N; i++) std::cin >> array[i];
    std::sort(array, array+N);

    int M;
    std::cin >> M;
    for (int i = 0; i < M; i++) {
        int num;
        std::cin >> num;
        if (std::binary_search(array, array+N, num)) std::cout << "1\n";
        else std::cout << "0\n";
    }
}
