#include <iostream>

using namespace std;

int main()
{
  int a, b, c, prize;
  cin >> a >> b >> c;
  if (a == b && b == c && c == a)
  {
    prize = 10000 + a * 1000;
  }
  else if (a == b || b == c || c == a)
  {
    if (a == b)
    {
      prize = 1000 + 100 * a;
    }
    else if (b == c)
    {
      prize = 1000 + 100 * b;
    }
    else if (c == a)
    {
      prize = 1000 + 100 * c;
    }
  }
  else
  {
    int maxi = max(max(a, b), c);
    prize = maxi * 100;
  }

  cout << prize;
}
