package com.dao.zang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class JucPractice {
    private static final Logger logger = Logger.getLogger(JucPractice.class.getName());
    public static void main(String[] args) {
        // thread + countdownLatch
        /*int num = 5;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            new Thread(() -> {
                try {
                    System.out.println("this is thread " + Thread.currentThread().getName());
                } finally {
                    countDownLatch.countDown();
                }
            },i + "").start();
        }
        try {
            countDownLatch.await();
            System.out.println("zhu");
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
        }*/

        // callable + future
        /*int num = 5;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        ExecutorService executor = Executors.newFixedThreadPool(num);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int finalI = i;
            Callable<String> task = () -> {
                try {
                    System.out.println("thread" + finalI);
                    String res = "thread - " + finalI;
                    return res;
                }finally {
                    countDownLatch.countDown();
                }
            };
            futures.add(executor.submit(task));
        }
        System.out.println(111);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(2222);
        futures.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });*/

        // runnable
        /*int num = 5;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        Executor executor = Executors.newFixedThreadPool(num);
        for (int i = 0; i < num; i++) {
            Runnable task = () -> {
                try {
                    System.out.println("this is thread " + Thread.currentThread().getName());
                }finally {
                    countDownLatch.countDown();
                }
            };
            executor.execute(task);
        }
        try {
            countDownLatch.await();
            System.out.println(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // completableFuture
        int num = 5;
        List<CompletableFuture<String>>  futures = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("running" + Thread.currentThread().getName());
                logger.info(Thread.currentThread().getName() + "log-info");
                return Thread.currentThread().getName();
            });
            futures.add(future);
        }
        System.out.println(111);
        CompletableFuture<Void> tasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        System.out.println(222);
        tasks.join();
        System.out.println(333);
        List<String> results = new ArrayList<>();
        for (CompletableFuture<String> future : futures) {
            try {
                results.add(future.get());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // 5. 输出结果
        // 6. git
        // 7. resolve
        System.out.println("\n==== 所有任务完成 =====");
        results.forEach(System.out::println);

    }

}
