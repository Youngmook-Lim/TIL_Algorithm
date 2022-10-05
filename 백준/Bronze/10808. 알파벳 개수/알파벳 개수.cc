#include <iostream>

using namespace std;

int main()
{

  int arr[26];
  fill(arr, arr + 26, 0);
  string S;
  cin >> S;

  for (int i = 0; i < S.length(); i++)
  {
    arr[S[i] - 'a']++;
  }

  for (int x : arr)
  {
    cout << x << " ";
  }

  return 0;
}
