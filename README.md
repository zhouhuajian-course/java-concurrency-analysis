# Java 并发分析

## 进程与线程

1. 进程

一个进程有自己独立的运行环境，特别是，有自己的内存空间。

进程与进程之间可以相互通信，例如管道、套接字，不同系统间的进程也能进行通信。

2. 线程

每个Java程序一般都是一个进程，从代码的角度上看，每个进程至少有一个线程，叫做主线程。

但实际上，如果算上内存管理、信号处理等系统线程，每个Java进程至少有多个线程。

如果把线程分用户线程和系统线程，那么可以说每个进程至少有一个用户线程。

![user-and-system-thread.png](readme/user-and-system-thread.png)

## 线程中断

有些方法发现线程已被中断，会抛出线程中断异常 例如Thread.sleep

线程也可以自己检查是否被中断了 Thread.interrupted() 对比 Thread.isInterrupted() 

Thread.interrupted()底层调用的是 currentThread().isInterrupted(true) clearInterrupted参数为true

在某些场景下clearInterrupted非常重要
