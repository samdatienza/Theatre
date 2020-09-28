# Theatre
Group Project 1 Theatre Program
This is a read me file. This will be edited later.

Develop a program to maintain two lists of movies: movies showing in the theater and movies coming
to the theater.

Main program
movie object


Program outline
Keep track of the movies using doubly-linked lists.
Use iterators to iterate through the lists.
Display the movies (showing and coming)
Add a new movie (to the coming list).
   However, do not add the movie in these cases.
   
    • The given dates (receive or release date) are invalid.
    • The release date is earlier than or equal to the receive date.
    • The movie already exists in the list.
Start showing movies in the theater with a given release date. You first need to find all the movies with the given release date. Then, remove it from the coming list to the showing list.

  However, do not show the movie in these cases.
   • The movie does not exist in the coming list.
   • The movie already exists in the showing list.
   • The given release date is invalid.
Edit a movie in the coming list (e.g. edit the release date or the description). You first need to find the movie with the given movie name. 
  However, do not edit the movie in this case.
  
   • The movie does not exist in the coming list.
Keep the coming list of movies ordered by release date (in non-decreasing order).
On demand, count the number of coming movies with release date earlier than a given date.
  However, do not count in this case.
  
   • The given date is invalid.
Your program should be menu-based. Therefore, the user can choose which command to run (display movies, add movies, edit release dates, edit movie description, start showing movies in the theater, number of movies before a date, save, exist). Just show a simple text menu in the console, no GUI needed.
Initially, your program should read movies from a file, and populate your movie lists. There is no input file provided; you need to create your own input files.
Write a function that overwrites the file of movies to reflect the changes (e.g. newly added movies, edited movies and movies started to show in the theater). The function can be called on demand.
