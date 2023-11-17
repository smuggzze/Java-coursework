import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuestionsOneToFour {

    public static int mergeSwaps = 0;
    public static void main(String[] args) throws IOException {
        String[] theGoodWords = deleteStopWords(new File("C:\\Users\\3this\\OneDrive\\Code\\javaStuff\\JavaCoursework2\\src\\input"), new File("C:\\Users\\3this\\OneDrive\\Code\\javaStuff\\JavaCoursework2\\src\\stopwords"));

        String[] first100WordsInsert = new String[100];
        String[] first100WordsMerge = new String[100];
        String[] first200WordsInsert = new String[200];
        String[] first200WordsMerge = new String[200];
        String[] first434WordsInsert = new String[theGoodWords.length - 1];
        String[] first434WordsMerge = new String[theGoodWords.length - 1];

        for (int i = 0; i < theGoodWords.length; i++) {
            if (i < 100) {
                first100WordsInsert[i] = theGoodWords[i];
                first100WordsMerge[i] = theGoodWords[i];
            }if (i < 200){
                first200WordsInsert[i] = theGoodWords[i];
                first200WordsMerge[i] = theGoodWords[i];
            }if (i < theGoodWords.length - 1){
                first434WordsInsert[i] = theGoodWords[i];
                first434WordsMerge[i] = theGoodWords[i];
            }
            if (i == 100){
                System.out.println("first 100 words:");

                long beforeInsertion = System.nanoTime();
                insertionSort(first100WordsInsert);
                long afterInsertion =  System.nanoTime();
                System.out.println("insertion sort: " + (afterInsertion - beforeInsertion) + "ns");


                mergeSwaps = 0;
                long beforeMerge = System.nanoTime();

                mergeSort(first100WordsMerge);
                long afterMerge = System.nanoTime();

                System.out.println("merge swaps: " + mergeSwaps);
                System.out.println("Merge sort: " + (afterMerge - beforeMerge) + "ns");
                System.out.println();
            } else if (i == 200) {
                System.out.println("first 200 words:");

                long beforeInsertion = System.nanoTime();
                insertionSort(first200WordsInsert);
                long afterInsertion =  System.nanoTime();
                System.out.println("insertion sort: " + (afterInsertion - beforeInsertion) + "ns");

                long beforeMerge = System.nanoTime();
                mergeSort(first200WordsMerge);
                System.out.println("merge swaps: " + mergeSwaps);
                long afterMerge = System.nanoTime();
                System.out.println("Merge sort: " + (afterMerge - beforeMerge) + "ns");
                System.out.println();


            }else if (i == theGoodWords.length - 1){

                System.out.println("first 434 words:");

                long beforeInsertion = System.nanoTime();
                insertionSort(first434WordsInsert);
                long afterInsertion =  System.nanoTime();
                System.out.println("insertion sort: " + (afterInsertion - beforeInsertion) + "ns");

                long beforeMerge = System.nanoTime();
                mergeSort(first434WordsMerge);
                System.out.println("merge swaps: " + mergeSwaps);
                long afterMerge = System.nanoTime();
                System.out.println("Merge sort: " + (afterMerge - beforeMerge) + "ns");
            }
        }

    }

    /**
     * Delete stop words from a text file.
     * Given an input file and a file containing stop words, this method reads the input file and removes any stop words
     * from the contents, returning an array of the remaining "good" words.
     *
     * @param input The file to remove stop words from.
     * @param stopWords The file containing stop words to remove.
     * @return An array of "good" words (i.e., the words from the input file that are not in the stop words file).
     * @throws IOException If there is an error reading the input or stop words files.
     *
     * {@code @example}
     * File inputFile = new File("input.txt");
     * File stopWordsFile = new File("stopwords.txt");
     * String[] goodWords = deleteStopWords(inputFile, stopWordsFile);
     */
    public static String[] deleteStopWords(File input, File stopWords) throws IOException {


        // create readers for files
        BufferedReader reader1 = new BufferedReader(new FileReader(input));

        BufferedReader reader2 = new BufferedReader(new FileReader(stopWords));

        List<String> goodWords = new ArrayList<>();

        String line1 = reader1.readLine();


        List<String> stopWordsList = new ArrayList<>();
        String line = reader2.readLine();

        // add contents of stopWords to list
        while (line != null) {
            stopWordsList.add(line);
            line = reader2.readLine();
        }
        // close reader
        reader2.close();



        // turn the input into an array and remove stopWords
        while(line1 != null) {
            String[] lineContents = line1.split(" ");

            goodWords.addAll(Arrays.asList(lineContents));
            goodWords.removeIf(word -> stopWordsList.contains(word.toLowerCase()));


            line1 = reader1.readLine();
            }

        reader1.close();
        // turn back to an array and return
        return goodWords.toArray(new String[goodWords.size()]);
    }   

    /**
     * Sort using insertion sort.
     * Given a list of words they will be sorted.
     * returns sorted list
     *
     * @param listOfWords The array of strings to sort.
     * @return Sorted array of strings .
     */
    public static String[] insertionSort(String [] listOfWords) {
        int swaps = 0;
        for ( int i = 0; i <= (listOfWords.length - 1); i++ ) {
            String currentWord = listOfWords[i];
            int previous = i - 1;
            // if compareToIgnoreCase <=0 word is lexicographically before or equal to current word
            while( previous >= 0 && currentWord.compareToIgnoreCase(listOfWords[previous]) <= 0 ) {
                listOfWords[previous + 1] = listOfWords[previous];
                previous = previous - 1;
                swaps ++;
            }
            listOfWords[previous + 1] = currentWord;
        }
        System.out.println("number of swaps for insertion sort: " + swaps);
    return listOfWords;
    }

    /**
     * Sort using merge sort.
     * this part mostly just divides the data
     * returns sorted list
     *
     * @param listOfWords The array of strings to sort.
     * @return Sorted array of strings .
     */
    public static String[] mergeSort(String[] listOfWords) {


        // base case
        if (listOfWords.length <= 1) {
            return listOfWords;
        }

        int mid = listOfWords.length / 2; // place to split the array
        String[] leftData = new String[mid];
        String[] rightData = new String[listOfWords.length - mid];

        for (int i = 0; i < mid; i++) { // fill the left data up to the middle data point
            leftData[i] = listOfWords[i];
        }
        for (int i = mid; i < listOfWords.length; i++) { // fill right data past middle data point
            rightData[i - mid] = listOfWords[i];
        }

        return merge(mergeSort(leftData), mergeSort(rightData)); // recursion
    }

    /**
     * Sort using insertion sort.
     * two arrays, they will be merged.
     * returns sorted list
     *
     * @param leftData one of the arrays of strings to sort.
     * @param rightData the other array of strings to sort.
     * @return Sorted array of strings .
     */
    public static String[] merge(String[] leftData, String[] rightData) {
        int lenLeft = leftData.length;
        int lenRight = rightData.length;
        int counterLeft = 0;
        int counterRight = 0;


        String[] mergedData = new String[lenLeft + lenRight];

        // sorting
        while (counterLeft < lenLeft && counterRight < lenRight) {
            // if left data is before right data in alphabet sort appropriately
            if (leftData[counterLeft].compareToIgnoreCase(rightData[counterRight]) <= 0) {
                mergedData[counterLeft + counterRight] = leftData[counterLeft];
                counterLeft++;
           } else { // else right is before left
                mergedData[counterLeft + counterRight] = rightData[counterRight];
                counterRight++;
                mergeSwaps ++;

            }

        }

        // adds words to the merge list which is the spare list that contains sorted items
        while (counterLeft < lenLeft) {
            mergedData[counterLeft + counterRight] = leftData[counterLeft];
            counterLeft++;


        }

        // adds words to the merge list which is the spare list that contains sorted items
        while (counterRight < lenRight) {
            mergedData[counterLeft + counterRight] = rightData[counterRight];
            counterRight++;


        }

        return mergedData;
    }



}









