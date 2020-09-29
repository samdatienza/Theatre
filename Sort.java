package project_1;

public class sort(){

    public static LinkedList<Movies> sortMovies(LinkedList<Movies> list){
        //Convert to an Array
        Movies movieList[] = list.toArray(new Movies[list.size()]);
        int listSize = list.size();
        
        //Recursian to sort the Array
        recursiveSort(movieList, listSize);
        LinkedList<Movies> sortedList = arrayToLinkedList(movieList);
        return sortedList; 
  }
    static void recursiveSort(Movies arr[], int n) { 
        // Base case 
        if (n <= 1) 
            return; 
       
        // Sort first n-1 Elements 
        recursiveSort( arr, n-1 ); 
       
        // Insert last element at its correct position in sorted array. 
        Movies last = arr[n-1]; 
        int j = n-2; 
       
        /* Move elements of arr[0..i-1], that are 
          greater than the key, to one position ahead 
          of their current position */
        while (j >= 0 && arr[j].getReleaseDate.compareTo(last.getReleaseDate()) == 0) 
        { 
            arr[j+1] = arr[j]; 
            j--; 
        } 
        arr[j+1] = last; 
    } 
    //Return to an array
    LinkedList<Movies> arrayToLinkedList(Movies arr[]){
        LinkedList<Movies> newList = new LinkedList<Movies>();
        for(Movies mov : arr){
            newList.add(mov);
        }
        return newList;
    }
}
