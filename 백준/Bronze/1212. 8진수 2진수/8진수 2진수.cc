#include <iostream>
#include <string>
#include <bitset>

using namespace std;

int main()
{

  ios::sync_with_stdio(false);
  cin.tie(NULL);

  string n, ans;
  cin >> n;

  for (int i = 0; i < n.length(); i++)
  {
    int num = n[i] - '0';
    string numBin = bitset<3>(num).to_string();
    if (i == 0)
    {
      numBin = to_string(stoi(numBin));
    }
    ans += numBin;
  }

  cout << ans;

  return 0;
}