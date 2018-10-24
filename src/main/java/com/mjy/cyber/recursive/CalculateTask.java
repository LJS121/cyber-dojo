package com.mjy.cyber.recursive;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CalculateTask {

    public static int calc(List<Integer> list) {
        // 任务太大,一分为二:
        int middle = list.size() / 2;
        SumTask subtask1 = new SumTask(list.subList(0, middle));
        SumTask subtask2 = new SumTask(list.subList(middle, list.size()));
        ForkJoinTask.invokeAll(subtask1, subtask2);
        Integer subresult1 = subtask1.join();
        Integer subresult2 = subtask2.join();
        Integer result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}


class SumTask extends RecursiveTask<Integer> {
    List<Integer> array;

    SumTask(List array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        Integer sum = 0;
        for (Integer i : this.array) {
            sum += i;
        }
        return sum;
    }
}
