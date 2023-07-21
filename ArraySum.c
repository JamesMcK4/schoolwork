#include <stdio.h>

int main(){
    //creating an array of size and a sum variable of type int
    int array[50];
    int sum = 0;
    int size = 50; //using this as a size variable instead of just having 50 to avoid magic number code smell
    int oneToFifty = 1; //initializing a variable to increment to add numbers 1-50 to array in order to sum them, instead of asking for user input.
    
    //first loop to add numbers 1-50 to array
    for(int i=0;i<size;i++){
        array[i] = oneToFifty;
        oneToFifty++;
    }
    
    //second loop summing all the numbers in the array using regular flow through for loop 
    for(int i=0;i<size;i++){
        sum += array[i];
    }

    printf("Sum of the array: %d", sum);

    return 0;
}
