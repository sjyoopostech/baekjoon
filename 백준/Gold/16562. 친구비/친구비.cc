#include <iostream>
#include <algorithm>

class Unionfind {
public :
    int* array;
    int* rank;
    int* expense;
    Unionfind(int N) {
        array = new int[N+1];
        rank = new int[N+1];
        expense = new int[N+1];
        for (int i = 1; i <= N; i++) {
            array[i] = i;
            rank[i] = 1;
        }
    }
    int find(int num) {
        if (num == array[num]) return num;
        array[num] = find(array[num]);
        return array[num];
    }
    void merge(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) return;
        if (rank[A] > rank[B]) std::swap(A, B);
        array[A] = B;
        expense[B] = std::min(expense[A], expense[B]);
        if (rank[A] == rank[B]) rank[B]++;
    }
};

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N, M, K;
    std::cin >> N >> M >> K;
    Unionfind* uf = new Unionfind(N);

    for (int i = 1; i <= N; i++) {
        std::cin >> uf->expense[i];
    }

    for (int i = 0; i < M; i++) {
        int x, y;
        std::cin >> x >> y;
        uf->merge(x, y);
    }

    int sum = 0;
    for (int i = 1; i <= N; i++) {
        if (uf->array[i] == i) sum += uf->expense[i];
    }
    if (sum <= K) std::cout << sum;
    else std::cout << "Oh no";

    return 0;
}
