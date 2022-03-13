#include <iostream>
#include <algorithm>

int main() {

    int N;
    scanf("%d", &N);
    std::vector<int> v(10001, 0);
    for (int i = 0; i < N; i++) {
        int number;
        scanf("%d", &number);
        v[number]++;
    }

    for (int i = 1; i <= 10000; i++) {
        for (int j = 0; j < v[i]; j++) {
            printf("%d\n", i);
        }
    }
}
