#include <iostream>

using namespace std;

int hour, min, sec, cnt, n, k;

void check();

int main()
{
  cin >> ::n >> ::k;

  ::hour = 0;
  ::min = 0;
  ::sec = 0;
  ::cnt = 0;

  while (true)
  {
    check();

    ::sec++;
    if (sec == 60)
    {
      ::min++;
      ::sec = 0;
      if (::min == 60)
      {
        ::hour++;
        ::min = 0;
      }
    }
    if (::hour == n + 1 && ::min == 0 && ::sec == 0)
    {
      break;
    }
  }

  cout << cnt;

  return 0;
}

void check()
{
  if (::hour % 10 == k || ::hour / 10 == k || ::min % 10 == k || ::min / 10 == k || ::sec % 10 == k || ::sec / 10 == k)
  {
    cnt++;
  }
}
