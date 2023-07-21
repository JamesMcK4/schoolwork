/*
James McKinlay
Assignment2 - Binary Files
2022/04/07
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct StudentInformation
{
    char studentID[20];
    char studentName[20];
    char studentEmail[20];
    char courseID[20];
    char courseGrade[20];
};

void createBinaryFile();
void displayFile();
void findRecord();
void updateRecord();
void deleteRecord();
FILE *filepointer;

int main(){

    int i = 0;
    
    int inputChoice;

    char stdId[20];

    while(inputChoice != 6)
    {
        printf("\t\t--MAIN MENU--\n");
        printf("1.\t Create the Binary File\n");
        printf("2.\t Display the contents of the file\n");
        printf("3.\t Seek a specific record\n");
        printf("4.\t Update the contents of a record\n");
        printf("5.\t Delete a record for the specific name\n");
        printf("6.\t Exit\n");

        printf("Please enter your choice: ");
        scanf("%d", &inputChoice); 

        switch(inputChoice)
        {
            case 1:     //Adding information to file 
                createBinaryFile();
                break;
            
            case 2:     //Displaying the contents of the file
                displayFile();
                break;
                
            case 3:     //Seek specific records in the file
                findRecord();               
                break;

            case 4:     //Update the contents of a specific record in the file
                updateRecord();
                break;

            case 5:     //Delete a record
                deleteRecord();
                break;
        }
    }
    return 0;
}

void createBinaryFile()
{
    //using .bin to open a binary file and wb to write to the binary file.
    filepointer = fopen("Records.bin", "ab"); 
    
    //creating a struct to store the data in
    struct StudentInformation info;
    
    printf("Please enter the student ID: ");
    scanf("%s", info.studentID);
    printf("Please enter the students full name: ");
    scanf("%s", info.studentName);
    printf("Please enter the student email: ");
    scanf("%s", info.studentEmail);
    printf("Please enter the course ID: ");
    scanf("%s", info.courseID);
    printf("Please enter the grade: ");
    scanf("%s", info.courseGrade);
    
    fwrite(&info, sizeof(info), 1, filepointer);
    fclose(filepointer);
}

void displayFile(){
    //using rb in order to read the binary file
    filepointer=fopen("Records.bin", "rb");

    struct StudentInformation info;

    while(fread(&info, sizeof(info), 1, filepointer))
    {
        printf("\t\t----------------\n");
        printf("\nStudent ID: %s", info.studentID);
        printf("\nStudent Name: %s", info.studentName);
        printf("\nStudent Email: %s", info.studentEmail);
        printf("\nCourse ID: %s", info.courseID);
        printf("\nStudent Grade: %s", info.courseGrade);
        printf("\n\t\t----------------\n");
    }
    fclose(filepointer);
    
}

void findRecord(){
    
    char stdId[10];
    struct StudentInformation info;
    printf("Please enter the Student ID: ");
    scanf("%s", &stdId);

    filepointer=fopen("Records.bin", "rb");
    //fseek(filepointer, sizeof(info), SEEK_CUR);  *COULDNT GET THIS TO WORK

    while(fread(&info, sizeof(info), 1, filepointer))
    {            
        if(strcmp(info.studentID, stdId) == 0)
        {
            printf("\t\t----------------\n");
            printf("\nStudent ID: %s", info.studentID);
            printf("\nStudent Name: %s", info.studentName);
            printf("\nStudent Email: %s", info.studentEmail);
            printf("\nCourse ID: %s", info.courseID);
            printf("\nStudent Grade: %s", info.courseGrade);
            printf("\n\t\t----------------\n");
        }
        if(strcmp(info.studentID, stdId) != 0)
        {
            printf("ID not found!");
        } 
    }          
}

void updateRecord(){


    /*Going to try and combine two portions of my previous code in order to overwrite the data in the struct.
    Did not work, try idea from notes*/
    
    struct StudentInformation info, tempInfo;
    char stdId[10];
    FILE *tempFilePointer;
    printf("Please enter the Student ID: ");
    scanf("%s", &stdId);
    filepointer = fopen("Records.bin", "rb");
    tempFilePointer = fopen("Temp.bin", "wb");
    
    while(fread(&info, sizeof(info), 1, filepointer))
    {
        if(strcmp(info.studentID, stdId) != 0)
        {
            fwrite(&info, sizeof(info), 1, tempFilePointer);
        }
    }
    printf("Please enter the new student ID: ");
    scanf("%s", tempInfo.studentID);
    printf("Please enter the students new full name: ");
    scanf("%s", tempInfo.studentName);
    printf("Please enter the new student email: ");
    scanf("%s", tempInfo.studentEmail);
    printf("Please enter the new course ID: ");
    scanf("%s", tempInfo.courseID);
    printf("Please enter the new grade: ");
    scanf("%s", tempInfo.courseGrade);

    //write into second file    
    fwrite(&tempInfo, sizeof(tempInfo), 1, tempFilePointer);
    
        //close files and remove/rename
        fclose(filepointer);
        fclose(tempFilePointer);
        //try delete original file and use/rename temp file instead. Fingers crossed!
        remove("Records.bin");
        rename("Temp.bin", "Records.bin");
    }
    


void deleteRecord(){
    
    //same as opening for update, remember that if the id DOES NOT MATCH, write into new file (like update (delete file then make new))

    struct StudentInformation info;
    char stdId[10];
    FILE *tempFilePointer;
    printf("Please enter the Student ID: ");
    scanf("%s", &stdId);
    filepointer = fopen("Records.bin", "rb");
    tempFilePointer = fopen("Temp.bin", "wb");

    while(fread(&info, sizeof(info), 1, filepointer))
    {
        if(strcmp(info.studentID, stdId) != 0)
        {
            fwrite(&info, sizeof(info), 1, tempFilePointer);
        }
    }
    //try like update!
    fclose(filepointer);
    fclose(tempFilePointer);
    remove("Records.bin");
    rename("Temp.bin", "Records.bin");
}

/* NOTES:
    Make sure to remember to continually check back with the C text book for information.  Mostly pg 160+ on file input, and 129 on structures
    Remember to cite your research!!!!!!***!*!**!*!
    Suggestion for update/delete: Try two different file pointers and copy/delete.  Suggested by friend, and seems to be what several people
    are doing in my research.
*/

/* Citations:
    1. https://easycodebook.com/2019/06/c-program-to-append-add-more-records-in-binary-file/
    2. https://www.programiz.com/c-programming/c-file-input-output
    3. https://www.youtube.com/watch?v=0SkdAoVzWpk&ab_channel=PortfolioCourses
    4. https://www.youtube.com/watch?v=QrKpqdBiFRI&ab_channel=CodeVault
    5. https://www.youtube.com/watch?v=Gge76h47kx4&ab_channel=GeekySatyam
    6. https://www.youtube.com/watch?v=-CxtJsJBJB0&ab_channel=GeekySatyam
    7. The C Programming Language by Brian Kernighan and Dennis Ritchie
    
*/