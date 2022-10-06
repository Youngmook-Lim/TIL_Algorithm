#include <iostream>

using namespace std;

int main()
{
  ios::sync_with_stdio(false);
  cin.tie(NULL);

  int n, m;
  int *pArr = nullptr;
  cin >> n >> m;

  pArr = new int[n];

  for (int i = 0; i < n; i++)
  {
    cin >> pArr[i];
  }

  for (int i = 0; i < m; i++)
  {
    int a, b, c;
    cin >> a >> b >> c;

    switch (a)
    {
    case 1:
      pArr[b - 1] = c;
      break;
    case 2:
      for (int j = b - 1; j < c; j++)
      {
        pArr[j] = (pArr[j] == 1) ? 0 : 1;
      }
      break;
    case 3:
      for (int j = b - 1; j < c; j++)
      {
        pArr[j] = 0;
      }
      break;
    case 4:
      for (int j = b - 1; j < c; j++)
      {
        pArr[j] = 1;
      }
      break;
    }
  }

  for (int i = 0; i < n; i++)
  {
    cout << pArr[i] << " ";
  }

  delete[] pArr;

  return 0;
}