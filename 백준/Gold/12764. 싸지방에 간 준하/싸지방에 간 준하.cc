#include <iostream>
#include <algorithm>
#include <queue>

class Ticket {
public:
    int number;
    int count;
    Ticket(int number) {
        this->number = number;
        count = 0;
    }
};

class Element {
public :
    int start;
    int end;
    Ticket* ticket;
    Element(int start, int end) {
        this->start = start;
        this->end = end;
        ticket = NULL;
    }
};

class CmpStart {
public:
    bool operator()(Element a, Element b) {
        return a.start > b.start;
    }
};

class CmpEnd {
public:
    bool operator()(Element a, Element b) {
        return a.end > b.end;
    }
};

class CmpTicket {
public:
    bool operator()(Ticket* a, Ticket* b) {
        return a->number > b->number;
    }
};

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    std::priority_queue<Element, std::vector<Element>, CmpStart> start;
    std::priority_queue<Element, std::vector<Element>, CmpEnd> end;
    std::priority_queue<Ticket*, std::vector<Ticket*>, CmpTicket> ticketqueue;

    int N;
    std::cin >> N;
    for (int i = 0; i < N; i++) {
        int x, y;
        std::cin >> x >> y;
        start.push(Element(x, y));
    }

    int lastnumber = 0;
    while (!start.empty() || !end.empty()) {
        bool startturn;
        if (start.empty()) startturn = false;
        else if (end.empty()) startturn = true;
        else startturn = start.top().start < end.top().end;

        if (startturn) {
            Element e = start.top();
            start.pop();
            Ticket* t;
            if (ticketqueue.empty()) {
                lastnumber++;
                t = new Ticket(lastnumber);
            }
            else {
                t = ticketqueue.top();
                ticketqueue.pop();
            }
            t->count++;
            e.ticket = t;
            end.push(e);
        }
        else {
            Element e = end.top();
            end.pop();
            ticketqueue.push(e.ticket);
        }
    }

    std::cout << lastnumber << "\n";
    while (!ticketqueue.empty()) {
        Ticket* t = ticketqueue.top();
        ticketqueue.pop();
        std::cout << t->count << " ";
    }

    return 0;
}
