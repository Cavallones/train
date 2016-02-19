#include <iostream>
#include <vector>

using namespace std;

void tab()
{
  vector<vector<int> >tab;
  tab = vector<vector<int> > (20);
  for(int i = 0; i < 20; i++)
  {
    if(i != 0)
    {
      cout<<"\n";
    }
    cout<<"_________________________________________________________________________________\n";
    cout<<"| ";
    tab[i] = vector<int>(20);
    for(int j = 0; j < 20; j++)
    {
      tab[i][j] = 0;
      cout<<tab[i][j]<<" | ";
    }
  }
}

int main()
{
  tab();
  return 0;
}
