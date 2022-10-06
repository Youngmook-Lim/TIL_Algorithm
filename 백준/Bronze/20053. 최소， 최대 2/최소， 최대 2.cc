#include <iostream>

using namespace std;

int main() {

  ios::sync_with_stdio(false);
  cin.tie(NULL);

  int T, n, minimum, maximum, num;

  cin >> T;

  for (int t = 0; t < T; t++) {

    cin >> n;
    minimum = 1000001;
    maximum = -1000001;

    for (int i = 0; i < n; i++) {
      cin >> num;
      if (num > maximum) {
        maximum = num;
      }
      if (num < minimum) {
        minimum = num;
      }
    }

    cout << minimum << " " << maximum << '\n';
  }
}