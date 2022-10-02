#include <iostream>

using namespace std;

int main()
{
  int a, b, c, d, e;
  int minBurger, minDrink;
  cin >> a >> b >> c >> d >> e;
  minBurger = min(min(a, b), c);
  minDrink = min(d, e);

  cout << minBurger + minDrink - 50;
  return 0;
}