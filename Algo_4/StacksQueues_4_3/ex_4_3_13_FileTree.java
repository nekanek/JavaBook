/*
* 4.3.7. Listing files with a stack. 
* Write a program that takes the name of a directory as a command line argument, 
* and prints out all of the files contained in this directory and any subdirectories.
* Also prints out the file size (in bytes) of each file. 
* Use a stack instead of a queue. Repeat using recursion and name your program DirectoryR.java. 
* Modify DirectoryR.java so that it prints out each subdirectory and its total size. 
* The size of a directory is equal to the sum of all of the files it contains or that its subdirectories contain.  
*/

package JavaBook.Algo_4.StacksQueues_4_3;

import static java.nio.file.FileVisitResult.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

public class ex_4_3_13_FileTree
    extends SimpleFileVisitor<Path> {


    @Override
    public FileVisitResult visitFile(Path file,
                                   BasicFileAttributes attr) {
        if (attr.isSymbolicLink()) {
            System.out.format("Symbolic link: %s ", file);
        } else if (attr.isRegularFile()) {
            System.out.format("Regular file: %s ", file);
        } else {
            System.out.format("Other: %s ", file);
        }
        System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }


    @Override
    public FileVisitResult postVisitDirectory(Path dir,
                                          IOException exc) {
        System.out.format("Directory: %s%n", dir);
        return CONTINUE;
    }


    @Override
    public FileVisitResult visitFileFailed(Path file,
                                       IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }
    
    public static void main(String[] args) {
        // Path startingDir = FileSystems.getDefault().getPath("/home/neko/NetBeansProjects/Default");
        Path startingDir = FileSystems.getDefault().getPath(args[0]);
        ex_4_3_13_FileTree pf = new ex_4_3_13_FileTree();
        try {
        Files.walkFileTree(startingDir, pf);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
   
}