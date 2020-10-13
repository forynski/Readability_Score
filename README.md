# Readibility_Score
Everyone has their own personal reading history, and as we grow up, we are able to comprehend more and more complicated texts. But how do you estimate the level of difficulty of a given text, and how do you teach a computer to do that? In this project, you will find it out: write a program that determines how difficult the text is and for which age it is most suitable. Learn to call programs from the command-line and get more experience with using regexes and Math class.

Result: https://imgur.com/jBA7hm3

# Work on project. Stage 1/4: Simplest estimation
Description
Ever wonder how to measure if the text is hard or easy to read? For a human this task is pretty simple: you just read the text and feel if you're struggling or not. But how to teach a computer do that? In this project, you will write such a program.

Firstly, let's create a simple program. If the text contains more than 100 symbols (including spacebars and punctuation) then the text is considered hard to read. Else, the text is considered easy to read. If the text contains exactly 100 symbols then it is still easy to read.

The input contains a single line with text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.

Examples
The symbol > represents the user input. Notice that it's not the part of the input.

Example 1

> This text is simple to read!
EASY

Example 2

> This text is hard to read. It contains a lot of sentences as well as a lot of words in each sentence.
HARD

# Work on project. Stage 2/4: Words and sentences
But the real text can be pretty long and still can be easy to read isn't it? There need to be done another approach. How about calculating a number of words in each sentence? Clearly, if each sentence of the text contains a lot of words then this text is hard to read.

Let's suppose that if the text contains on average more than 10 words per sentence, then this text is hard to read. Otherwise, this text is easy to read. Don't worry, we will consider more scientific ways in the next stages.

The input contains a single line with text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.

For example, the first example contains two sentences with 6 and 10 words (numbers also counts as words) so the average is 8 and this is less than 10. In the second example, there is also 2 sentences but with 6 and 16 words so the average is 11 and this is greater than 10. If the average is equal to 10 then the text is still considered easy to read.

Don't forget that the sentences can end with a dot as well as with an exclamation mark and a question mark. But the last sentence can be with or without a punctuation character at the end.

Examples
The symbol > represents the user input. Notice that it's not the part of the input.

Example 1

> This text is simple to read! It has on average less than 10 words per sentence.
EASY

Example 2

> This text is hard to read. It contains a lot of sentenses as well as a lot of words in each sentence
HARD

# What you'll do in this stage 3/4: Score!
Description
In this stage, you will program the Automated readability index. It was introduced in 1968 and a lot of research works rely on this. The index is calculated by the following ARI formula (https://en.wikipedia.org/wiki/Automated_readability_index).

You can look at different ages corresponding to the different scores by the table in this article.

Also, your program should read a file instead of typing a text manually. You should pass the filename through the command line arguments.

The program should output the score itself and an approximate age needed to comprehend the text.

Use the appropriate rounding function to calculate the score as integer.

You should also print how many characters, words, and sentences the text has.

The number of characters is any visible symbol (so, in the real text it's everything except space, newline "\n" and tab "\t").

Notice, that the text can contain multiple lines, not just a single line like in the previous stages. You should analyze all the lines.

Examples
The symbol > represents the user input. Notice that it's not the part of the input.

Example 1

> java Main in.txt
The text is:
Readability is the ease with which a reader can understand a written text. In natural language, the readability of text depends on its content and its presentation. Researchers have used various factors to measure readability. Readability is more than simply legibility, which is a measure of how easily a reader can distinguish individual letters or characters from each other. Higher readability eases reading effort and speed for any reader, but it is especially important for those who do not have high reading comprehension. In readers with poor reading comprehension, raising the readability level of a text from mediocre to good can make the difference between success and failure

Words: 108
Sentences: 6
Characters: 580
The score is: 12.86
This text should be understood by 18-24 year olds.

Example 2

> java Main in.txt
The text is:
This is the page of the Simple English Wikipedia. A place where people work together to write encyclopedias in different languages. That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License 3 and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. You may ask questions at Simple talk.

Words: 100
Sentences: 10
Characters: 476
The score is: 5.98
This text should be understood by 11-12 year olds.
