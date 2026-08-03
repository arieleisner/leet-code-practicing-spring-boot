# JVM

## 1. Definition
JVM stands for Java Virtual Machine, which is a *runtime environment for running Java code*.
It is multiplatform, so the code can be compiled and run independently of the OS and hardware.

## 2. Why it exists
It exists to run java bytecode, abstracting the complexities of the OS and hardware, making the Java code multiplatform.

## 3. How it works
Java source code is compiled into bytecode (.class), and the JVM either interprets it or JIT compiles that bytecode into
native machine code for execution.

The main responsibilities of the JVM are:
* *Class loading:* loads classes dynamically using class loaders.
* *Bytecode verification:* ensures that code is safe and follows JVM rules before execution.
* *Memory management:* manages heap, stack, metaspace, code cache and performs garbage collection.
* *Execution engine:*
  * *Interpreter* executes code initially.
  * *JIT compiler* compiles frequently used code into optimized native instructions for performance.
* *Garbage collection:* reclaims memory of classes that are no longer used and clean it.

*JVM Memory areas*

* *Heap:* stores objects and arrays, is shared between threads.
* *Stack:* stores variables, method frames and references, one per thread.
* *Metaspace:* stores class metadata.
* *Code cache:* contains JIT compiled native code.

## 4. Example

## 5. Interview answer (30 sec)

## 6. Common interview questions

## 7. Best practices

## 8. Related topics