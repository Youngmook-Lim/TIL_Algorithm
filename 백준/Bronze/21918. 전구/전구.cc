#include <iostream>

using namespace std;

int main()
{
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  int arr[4000] = {0};
  cin >> n >> m;

  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  for (int i = 0; i < m; i++)
  {
    int a, b, c;
    cin >> a >> b >> c;

    switch (a)
    {
    case 1:
      arr[b - 1] = c;
      break;
    case 2:
      for (int j = b - 1; j < c; j++)
      {
        arr[j] = (arr[j] == 1) ? 0 : 1;
      }
      break;
    case 3:
      for (int j = b - 1; j < c; j++)
      {
        arr[j] = 0;
      }
      break;
    case 4:
      for (int j = b - 1; j < c; j++)
      {
        arr[j] = 1;
      }
      break;
    }
  }

  for (int i = 0; i < n; i++)
  {
    cout << arr[i] << " ";
  }

  return 0;
}