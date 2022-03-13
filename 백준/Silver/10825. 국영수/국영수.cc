#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>

typedef std::tuple<std::string, int, int, int> Student;

bool Compare(Student a, Student b) {
    if (std::get<1>(a) != std::get<1>(b)) return std::get<1>(a) > std::get<1>(b);
    if (std::get<2>(a) != std::get<2>(b)) return std::get<2>(a) < std::get<2>(b);
    if (std::get<3>(a) != std::get<3>(b)) return std::get<3>(a) > std::get<3>(b);
    return std::get<0>(a) < std::get<0>(b);

}

int main() {
    int N;
    std::cin >> N;
    std::vector<Student> v;
    for (int i = 0; i < N; i++) {
        std::string s;
        int a, b, c;
        std::cin >> s >> a >> b >> c;
        v.push_back({s, a, b, c});
    }
    std::sort(v.begin(), v.end(), Compare);
    for (Student stu : v) {
        std::cout << std::get<0>(stu) << "\n";
    }

    return 0;
}
