package com.vmc.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFlesToAnotherFolder {
public static void main(String[] args) {
        // Source and destination folder paths
        String sourceFolder = "F:\\AJAY PHOTOS\\GROOM";
        String destinationFolder = "D:\\Selected\\Day_1";
        String fileListPath = "Day1.txt";

        // Copy files listed in filelist.txt from source to destination folder
        try {
            copyFilesFromList(sourceFolder, destinationFolder, fileListPath);
            System.out.println("Files copied successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void copyFilesFromList(String sourceFolder, String destinationFolder, String fileListPath) throws IOException {
        // Read filenames from the filelist.txt
        List<String> fileNames = Files.readAllLines(Paths.get(fileListPath));

        // Create Paths for source and destination folders
        Path sourcePath = Paths.get(sourceFolder);
        Path destinationPath = Paths.get(destinationFolder);

        // Iterate over filenames and copy corresponding files from source to destination folder
        for (String fileName : fileNames) {
            // Construct source and destination file paths
            Path sourceFile = sourcePath.resolve(fileName);
            Path destinationFile = destinationPath.resolve(fileName);

            // Copy file
            Files.copy(sourceFile, destinationFile);
            System.out.println("Copied: " + sourceFile + " to " + destinationFile);
        }
    }}
