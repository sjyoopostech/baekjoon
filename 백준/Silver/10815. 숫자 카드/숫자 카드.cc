#include <iostream>
#include <algorithm>
#include <vector>

int main() {

    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::cin >> N;
    int array[N];
    for (int i = 0; i < N; i++) {
        std::cin >> array[i];
    }
    std::sort(array, array+N);
    int M;
    std::cin >> M;
    for (int i = 0; i < M; i++) {
        int target;
        std::cin >> target;
        if (std::binary_search(array, array+N, target)) std::cout << "1 ";
        else std::cout << "0 ";

    }

    return 0;
}
