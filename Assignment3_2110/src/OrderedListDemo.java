/**
 * James McKinlay
 * B00867096
 * Assignment 3 - Ordered Lists
 * CSCI 2110
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderedListDemo {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        //Reading in first list from a specified file (list1)
        System.out.println("Please enter a file to read from: ");
        String file1Name = in.nextLine();

        File file1 = new File(file1Name);
        Scanner fileReader = new Scanner(file1);

        OrderedList<String> file1Names = new OrderedList<>();
        while (fileReader.hasNext()) {
            String name = fileReader.nextLine();
            file1Names.insert(name);
        }
        fileReader.close();

        //Reading in the second list from a specified file (list2)
        System.out.println("Please enter a second file to read from: ");
        String file2Name = in.nextLine();

        File file2 = new File(file2Name);
        Scanner fileReader2 = new Scanner(file2);

        OrderedList<String> file2Names = new OrderedList<>();
        while (fileReader2.hasNext()) {
            String name = fileReader2.nextLine();
            file2Names.insert(name);
        }
        fileReader2.close();

        //Method calls for the assignment.
        File merged = new File("merged.txt");
        File common = new File("common.txt");
        File difference = new File("difference.txt");

        OrderedList mergeList = merge(file1Names, file2Names);
        OrderedList commonList = common(file1Names, file2Names);
        OrderedList differenceList = diff(file1Names, file2Names);


        //New lists written to text files. Lists printed with a ",".
        FileWriter writerMergeList = new FileWriter(merged);
        for(int i = 0; i < mergeList.size(); i++) {
            if (i != mergeList.size() - 1) {
                writerMergeList.write(String.valueOf(mergeList.get(i)) + ", ");
            }
            else{
                writerMergeList.write(String.valueOf(mergeList.get(i)));
            }
        }
        writerMergeList.close();

        FileWriter writerCommonList = new FileWriter(common);
        for(int i = 0; i < commonList.size(); i++){
            if (i != commonList.size() - 1) {
                writerCommonList.write(String.valueOf(commonList.get(i)) + ", ");
            }
            else{
                writerCommonList.write(String.valueOf(commonList.get(i)));
            }
        }
        writerCommonList.close();

        FileWriter writerDifferenceList = new FileWriter(difference);
        for(int i = 0; i < differenceList.size(); i++){
           if (i != differenceList.size() - 1) {
            writerDifferenceList.write(String.valueOf(differenceList.get(i)) + ", ");
           }
           else{
                writerDifferenceList.write(String.valueOf(differenceList.get(i)));
           }
        }

        writerDifferenceList.close();

        System.out.println("The merge operations are complete and the results are in merged.txt, difference.txt, and common.txt");
    }

    /**
     * Method that will take in two ordered lists as parameters and merge them together in lexicographic order
     * @param list1 the first list of items
     * @param list2 the second list of items
     * @param <T> A generic value to cover different input types (in this case strings)
     * @return the list merged from the two lists passed in.
     */
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T>
			list2) {
		T item;
		OrderedList finalList = new OrderedList<>();

		int finder1 = 0;
		int finder2 = 0;

		while (finder1 < list1.size() && finder2 < list2.size()){
			if(list1.get(finder1).compareTo(list2.get(finder2)) < 0){
				item = list1.get(finder1);
				finalList.insert(item);
				finder1++;
			}
			else if (list1.get(finder1).compareTo(list2.get(finder2)) > 0){
				item = list2.get(finder2);
				finalList.insert(item);
				finder2++;
			}
			else{
				item = list1.get(finder1);
				finalList.insert(item);
				finder1++;
				finder2++;
			}

			if(finder1 == list1.size() && finder2 < list2.size()){
                while(finder2 < list2.size()) {
                    item = list2.get(finder2);
                    finalList.insert(item);
                    finder2++;
                }
			}
			if(finder2 == list2.size() && finder1 < list1.size()){
                while(finder1 < list1.size()){
                    item = list1.get(finder1);
                    finalList.insert(item);
                    finder1++;
                }
			}
		}

		return finalList;

	}

    /**
     * Method that takes in two ordered lists as parameters and returns a third list of all the items that the two lists have in common
     * @param list1 the first list of items
     * @param list2 the second list of items
     * @param <T> A generic value to cover different input types (in this case strings)
     * @return A new list of items that both lists have in common
     */
	public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T> list1, OrderedList<T>
			list2) {

        OrderedList finalList = new OrderedList<>();
        int finder1 = 0;
        int finder2 = 0;
        while (finder1 < list1.size() && finder2 < list2.size()) {
            if (list1.get(finder1).compareTo(list2.get(finder2)) < 0) {
                finder1++;
            }
            else if (list2.get(finder2).compareTo(list1.get(finder1)) < 0) {
                finder2++;
            }
            else
            {
                finalList.insert(list1.get(finder1));
                finder1++;
                finder2++;
            }
        }
        return finalList;
    }

    /**
     * Method that takes in two ordered lists as parameters and returns a new ordered list of the items that are different
     * in the two lists.
     * @param list1 the first list of items
     * @param list2 the second list of items
     * @param <T> A generic value to cover different input types (in this case strings)
     * @return A new list of all items that differ between the two lists
     */
    public static <T extends Comparable<T>> OrderedList<T> diff(OrderedList<T> list1, OrderedList<T>
			list2){

        OrderedList finalList = new OrderedList<>();

        int finder1 = 0;
        int finder2 = 0;

        while(finder1 < list1.size() && finder2 < list2.size()) {

            if (list1.get(finder1).compareTo(list2.get(finder2)) < 0) {
                finalList.insert(list1.get(finder1));
                finder1++;
            }
            else if (list2.get(finder2).compareTo(list1.get(finder1)) < 0) {
                finalList.insert(list2.get(finder2));
                finder2++;
            }
            else
            {
                finder1++;
                finder2++;
            }
        }
        return finalList;
    }

}
