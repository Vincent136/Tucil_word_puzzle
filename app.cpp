#include <iostream>
#include <fstream>
#include <string>
using namespace std;


int main ()
{
   string line;
   ifstream file("test.txt");
   int index = 0;
   while(getline(file, line))
   {
      while(line){}
   }
   return 0;
}