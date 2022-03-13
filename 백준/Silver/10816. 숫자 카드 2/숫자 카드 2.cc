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
    std::vector<int> value;
    std::vector<int> count;
    value.push_back(array[0]);
    count.push_back(1);
    for (int i = 1; i < N; i++) {
        if (array[i] > array[i-1]) {
            value.push_back(array[i]);
            count.push_back(1);
        }
        else {
            count.at(count.size()-1)++;
        }
    }

    int M;
    std::cin >> M;
    for (int i = 0; i < M; i++) {
        int target;
        std::cin >> target;
        int start = 0;
        int end = value.size()-1;
        int find = -1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (target < value.at(mid)) end = mid-1;
            else if (target > value.at(mid)) start = mid+1;
            else {
                find = mid;
                break;
            }
        }
        if (find == -1) std::cout << "0 ";
        else std::cout << count.at(find) << " ";
    }

    return 0;
}
