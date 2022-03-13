#include <iostream>
#include <algorithm>
#include <numeric>

int main() {
    int a, b;
    std::cin >> a >> b;
    std::cout << std::gcd(a, b) << std::endl;
    std::cout << std::lcm(a, b) << std::endl;
    return 0;

}
