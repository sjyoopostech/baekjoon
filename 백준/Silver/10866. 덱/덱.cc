#include <iostream>
#include <deque>
#include <cstring>

int main() {

    int N;
    scanf("%d", &N);
    std::deque<int> deq;
    for (int i = 0; i < N; i++) {
        char string [100];
        std::cin >> string;

        if (strcmp(string, "push_front") == 0) {
            int num;
            std::cin >> num;
            deq.push_front(num);
        }
        if (strcmp(string, "push_back") == 0) {
            int num;
            std::cin >> num;
            deq.push_back(num);
        }
        else if (strcmp(string, "pop_front") == 0) {
            if (!deq.empty()) {
                printf("%d\n", deq.front());
                deq.pop_front();
            }
            else printf("-1\n");
        }
        else if (strcmp(string, "pop_back") == 0) {
            if (!deq.empty()) {
                printf("%d\n", deq.back());
                deq.pop_back();
            }
            else printf("-1\n");
        }
        else if (strcmp(string, "size") == 0) {
            printf("%d\n", deq.size());
        }
        else if (strcmp(string, "empty") == 0) {
            printf("%d\n", deq.empty());
        }
        else if (strcmp(string, "front") == 0) {
            if (!deq.empty()) {
                printf("%d\n", deq.front());
            }
            else printf("-1\n");
        }
        else if (strcmp(string, "back") == 0) {
            if (!deq.empty()) {
                printf("%d\n", deq.back());
            }
            else printf("-1\n");
        }
    }
}
