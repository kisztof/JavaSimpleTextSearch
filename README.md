# Text Search Engine

Simple text search engine

### Prerequirements

Install java 8+


Prepare catalog containing some text files, or use one provided in repo.

### Installing

Compile the code using your prefered IDE or by command line and javac.

```
javac -d bin src/pl/kslomka/*.java 
```

### Usage
```
cd bin
java pl.kslomka.Main ../resources

```
Where ../resources is directory containing text files.

Now write word or sentence and look if files contains them
```
search>>
Litwa
sienkiewicz2.txt 100%
sienkiewicz.txt 100%
search>>
lody
Words not found!
search>>
how
sienkiewicz2.txt 100%
sienkiewicz.txt 100%
search>>
how are you sienkiewicz
sienkiewicz.txt 100%
sienkiewicz2.txt 75%
search>>
```

### Result Explanation
Rank is computed by words count in file devided by words in provided sentence and multiply by 100 to receive percentage result.