package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InsertionSortMain {

        private static double ordered(int n){
            Integer[] array = new Integer[n];
            for(int i = 0; i < n; i++){
                array[i] = i+1;
//                if(i < 10)
//                System.out.println(array[i]);
            }
            InsertionSort insertionSort = new InsertionSort();
            Benchmark<Boolean> benchmark = new Benchmark_Timer<>("Ordered",x -> {
                insertionSort.sort(array.clone(),0, array.length);
            });
            double time = benchmark.run(true,10);
            return time;
        }

        private static double reverse(int n){
            Integer[] array = new Integer[n];
            for(int i = 0; i < n; i++){
                array[i] = n-i;
//                if(i < 10)
//                    System.out.println(array[i]);
            }
            InsertionSort insertionSort = new InsertionSort();
            Benchmark<Boolean> benchmark = new Benchmark_Timer<>("Reverse",x -> {
                insertionSort.sort(array.clone(),0, array.length);
            });
            double time = benchmark.run(true,10);
            return time;
        }

        private static double random(int n){
            Integer[] array = new Integer[n];
            Random random = new Random();
            for(int i = 0; i < n; i++){
                array[i] = random.nextInt(n+1);
            }
            InsertionSort insertionSort = new InsertionSort();
            Benchmark<Boolean> benchmark = new Benchmark_Timer<>("Random",x -> {
                insertionSort.sort(array.clone(),0, array.length);
            });
            double time = benchmark.run(true,10);
            return time;
        }

        private static double partially(int n){
            Integer[] array = new Integer[n];
            Random random = new Random();
            for(int i = 0; i < n; i++){
                if (i < n/4)
                    array[i] = i;
                else
                    array[i] = random.nextInt(n+1);
            }
            InsertionSort insertionSort = new InsertionSort();
            Benchmark<Boolean> benchmark = new Benchmark_Timer<>("Partially",x -> {
                insertionSort.sort(array.clone(),0, array.length);
            });
            double time = benchmark.run(true,10);
            return time;
        }

        public static void main(String[] args){
            int[] test = {500,1000,2000,4000,8000,16000,32000,64000};
            ArrayList<Double> timelist = new ArrayList<Double>();
            System.out.println("Ordered");
            for(int a : test){
                double time = InsertionSortMain.ordered(a);
                timelist.add(time);
            }
            for(double t : timelist){
                System.out.println(t);
            }
            timelist.clear();
            System.out.println("Random");
            for(int b : test){
                double time = InsertionSortMain.random(b);
                timelist.add(time);
            }
            for(double t : timelist){
                System.out.println(t);
            }
            timelist.clear();
            System.out.println("Partially");
            for(int c : test){
                double time = InsertionSortMain.partially(c);
                timelist.add(time);
            }
            for(double t : timelist){
                System.out.println(t);
            }
            timelist.clear();
            System.out.println("Reverse");
            for(int d : test){
                double time = InsertionSortMain.reverse(d);
                timelist.add(time);
            }
            for(double t : timelist){
                System.out.println(t);
            }
        }

}
