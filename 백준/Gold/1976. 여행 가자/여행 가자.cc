#include <iostream>
#include <algorithm>

class Unionfind {
public :
    int* array;
    int* rank;
    Unionfind(int N) {
        array = new int[N+1];
        rank = new int[N+1];
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
        if (rank[A] == rank[B]) rank[B]++;
    }
};

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N, M;
    std::cin >> N >> M;
    Unionfind* uf = new Unionfind(N);

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            int x;
            std::cin >> x;
            if (x == 0) continue;
            uf->merge(i,j);
        }
    }

    bool yes = true;
    int x;
    std::cin >> x;
    x = uf->find(x);
    for (int i = 1; i < M; i++) {
        int y;
        std::cin >> y;
        if (x != uf->find(y)) {
            yes = false;
            break;
        }
    }
    if (yes) std::cout << "YES";
    else std::cout << "NO";

    return 0;
}
