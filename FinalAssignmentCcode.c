#include <stdio.h>

int main(){
    int lowNum, highNum = 0;
    
    printf("Please enter a positive integer: ");
    scanf("%d", &lowNum);

    printf("Please enter a higher positive integer: ");
    scanf("%d", &highNum);
   
    sumForLoop(lowNum, highNum);
    sumWhileLoop(lowNum, highNum);
    sumDoWhileLoop(lowNum, highNum);
    sumGotoLoop(lowNum, highNum);
    
    
    float array[];
    for(int i=0;i<=50;i++){
        array[i] = i;
    }
    
    printf("Sum of array is: " + sumArray(array));
    return 0;    
}

int sumArray(float array[])
{
    float sum = 0;
    int max = 50;
    for(int i=0;i<max;i++){
        sum +=array[i]; 
    }
    return sum;

}
void sumForLoop(int low, int high){
    int sum = 0;
    for(int i=low; i<=high;i++){
        sum += i;   
    }
    printf("Sum of for = %d\n", sum);
}

void sumWhileLoop(int low, int high){
    int sum = 0;
    while(low<=high){
        sum += low;
        low++;
    }
    printf("Sum of while = %d\n", sum);
}

void sumDoWhileLoop(int low, int high){
    int sum = 0;
    do{
        sum += low;
        low++;
    }
    while(low<=high);
    printf("Sum of do/while = %d \n", sum);
}

void sumGotoLoop(int low, int high){
    int sum = 0;
    while(low<=high){goto sumGoto;}

    sumGoto:
        for(int i=low; i<=high;i++){
        sum += i;   
    }
    printf("Sum of goto = %d\n", sum);
}
    

