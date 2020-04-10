package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	int [] a = new int[9];
	Scanner initial = new Scanner(System.in);
    int j = 0;
    int sum = 0;

    //populate the array starting with initial input number
	for(int i = initial.nextInt();j<a.length; j++,i++)
    {
        a[j] = i;
    }

	//find sum of lines
    for(j = 0; j<a.length; j++)
    {
        sum = sum + a[j];
    }
	    int target = sum / 3;


	    System.out.println(target);


    }
}