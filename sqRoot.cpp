// we can use the inbuilt square root function too, but for large no it is better to use the binary search algo due to better time complxity.

#include<iostream> 

using namespace std; 

int square_root(int n){
    int  l = 1 , h = n/2;
    if(n == 1) return 1;
    int mid , sq , ans;
    while (l<=h){
        mid = l + ((h-l)/2);
        sq = mid*mid;

        if (sq > n) { h = mid - 1 ; }

        else if (sq < n){ 
            l = mid + 1 ;
            ans = mid; //this is done as N may not be a perfect sq and mid is returned only if N is a perfect square
            }

        else return mid;
    }
    return ans;
}

int main() 
{ 
    int no;
    cout<<"Enter the no : ";
    cin >> no;

    int sqrt = square_root(no);
    cout << "\n the square root is : " << sqrt ;
    return 0; 
}