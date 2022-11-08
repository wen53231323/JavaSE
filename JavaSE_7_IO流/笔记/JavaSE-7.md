---
title: JavaSE笔记-IO流
date: 2021-06-01 3:00:00
categories: Java
tags: JavaSE
cover: java.png
toc: true
---

## IO流简介

（1）IO流是一个抽象的概念，可以理解为一段单向的数据序列，是Java实现输入输出的基础

| 概念             | 简介                                             |
| ---------------- | ------------------------------------------------ |
| 流（Stream）     | 数据在数据源（文件）和程序（内存）之间经历的路径 |
| 输入流（Input）  | 数据从数据源（文件）到程序（内存）的路径         |
| 输出流（Output） | 数据从数据源（文件）到程序（内存）的路径         |

（2）Java把所有的传统的流类型都放到在java.io包下，用于实现输入和输出功能，输入也叫做读取数据，输出也叫做作写出数据

（3）Java的IO模型使用装饰者模式（Decorator），按功能划分Stream，您可以动态装配这些流Stream，以便获得您需要的功能



## IO流分类

### 输入流和输出流

按照流的流向分，可以分为输入流和输出流

| IO流         | 简介                 |
| ------------ | -------------------- |
| Input输入流  | 负责读，外部 -> 内存 |
| Output输出流 | 负责写，内存 -> 外部 |

### 字节流和字符流

按照操作单元划分，可以划分为字节流和字符流，使用字节流读取文件为中文的时候，GBK占用2个字节(byte)，UTF-8占用3个字节

| IO流   | 简介                                                         |
| ------ | ------------------------------------------------------------ |
| 字节流 | 操作的单元是数据单元是8位的字节，例如图片、音乐、视频等文件，可以对二进制文件进行处理 |
| 字符流 | 操作的是数据单元为16位的字符，例如.txt、.java、.c、.cpp等文本文件，.doc、excel、ppt这些不是文本文件 |

### 节点流和处理流

按照流的角色划分为节点流和处理流

| IO流   | 简介                                                         |
| ------ | ------------------------------------------------------------ |
| 节点流 | 直接从数据源或目的地读写数据                                 |
| 处理流 | 处理流也叫包装流，`对节点流进行包装`，使用了修饰器设计模式，不会直接与数据源相连，而是“连接”在已存在的流（节点流或处理流）之上，处理流也被称为高级流，处理流以增加缓冲的方式来提高输入输出的效率 |



## 常用 IO 流

### 抽象基类

（1）Java的IO流共涉及40多个类，实际上非常规则，都是从4个抽象基类派生，派生出来的子类名称都是以其父类名作为子类名后缀

| 分类       | 抽象基类     |
| ---------- | ------------ |
| 字节输入流 | InputStream  |
| 字节输出流 | OutputStream |
| 字符输入流 | Reader       |
| 字符输出流 | Writer       |

（2）由于抽象基类都是抽象类，本身不能创建实例，但是继承它们的子类有对应的功能

### 常用流分类表

#### 节点流

| 分类       | 字节输入流           | 字节输出流            | 字符输入流      | 字符输出流      |
| ---------- | -------------------- | --------------------- | --------------- | --------------- |
| 抽象基类   | `InputStream`        | `OutputStream`        | `Reader`        | `Writer`        |
| 访问文件   | `FileInputStream`    | `FileOutputStream`    | `FileReader`    | `FileWriter`    |
| 访问数组   | ByteArrayInputStream | ByteArrayOutputStream | charArrayReader | charArrayWriter |
| 访问管道   | PipedInputStream     | PipedOutputStream     | PipedReader     | PipedWriter     |
| 访问字符串 | 无                   | 无                    | StringReader    | StringWriter    |

#### 处理流

| 分类   | 字节输入流            | 字节输出流             | 字符输入流          | 字符输出流           |
| ------ | --------------------- | ---------------------- | ------------------- | -------------------- |
| 缓冲流 | `BufferedInputStream` | `BufferedOutputStream` | `BufferedReader`    | `BufferedWriter`     |
| 转换流 | 无                    | 无                     | `InputStreamReader` | `OutputStreamWriter` |
| 对象流 | `ObjectInputStream`   | `ObjectOutputStream`   | 无                  | 无                   |
| 过滤流 | FilterInputStream     | FilterOutputStream     | FilterReader        | FilterWriter         |
| 打印流 | 无                    | PrintStream            | 无                  | PrintWriter          |
| 回退流 | PushbackInputStream   | 无                     | PushbackReader      | 无                   |
| 数据流 | DataInputStream       | DataOutputStream       | 无                  | 无                   |

## File类

### 路径分隔符

路径中的每级目录之间需要用一个路径分隔符隔开，但路径分隔符和系统有关，比如windows和DOS系统默认使用`\\`来表示、UNIX和URL使用`/`来表示，为了解决Java程序跨平台运行，File类提供了一个常量，可以根据操作系统，动态的提供分隔符（盘符+路径+文件名）

```java
public static final String separator;
```

### File类简介

（1）java.io.File类的一个对象，代表一个文件或一个文件目录（文件夹）

（2）File 能新建、删除、重命名文件和目录，但File不能访问文件内容本身，如果需要访问文件内容本身，则需要使用输入/输出流。

（3）想要在Java程序中表示一个真实存在的文件或目录，那么必须有一个File对象，但是Java程序中的一个File对象，可能没有一个真实存在的文件或目录。

### File类构造器

| 构造器                           | 简介                                                     |
| -------------------------------- | -------------------------------------------------------- |
| File(String pathname)            | 以pathname为路径创建File对象，可以是绝对路径或者相对路径 |
| File(String parent,String child) | 以parent为父路径，child为子路径创建File对象              |
| File(File parent,String child)   | 根据一个父File对象和子文件路径创建File对象               |

```java
public class Demo {
	@Test
    public void test() {
        // 相对路径
        File file1 = new File("hello.txt");
        System.out.println(file1);// hello.txt

        // 绝对路径
        File file2 = new File("E:\\test\\hello.txt");
        System.out.println(file2);// E:\test\hello.txt

        // 路径+目录
        File file3 = new File("E:\\test", "java");
        System.out.println(file3);// E:\test\java

        // File类型+文件名
        File file4 = new File(file3, "hello.txt");
        System.out.println(file4);// E:\test\java\hello.txt

        /**
         *路径中的每级目录之间需要用一个路径分隔符隔开，但路径分隔符和系统有关，
         *比如windows和DOS系统默认使用`\\`来表示、UNIX和URL使用`/`来表示，
         *为了解决Java程序跨平台运行，File类提供了一个常量，可以根据操作系统，动态的提供分隔符（盘符+路径+文件名）
         *public static final String separator;
         */
        File file5 = new File("E:" + File.separator + "test" + File.separator + "hello.txt");
        System.out.println(file5);// E:\test\hello.txt
    }
}
```

### File类常用方法

#### 获取操作

（1）方法示例

| 方法              | 简介                                           |
| ----------------- | ---------------------------------------------- |
| getAbsolutePath() | 获取绝对路径                                   |
| getPath()         | 获取路径                                       |
| getName()         | 获取名称                                       |
| getParent()       | 获取上层文件目录路径，若无则返回null           |
| length()          | 获取文件长度（字节数）不能获取目录的长度       |
| lastModified()    | 获取最后一次的修改时间，毫秒值                 |
| list()            | 获取指定目录下的所有文件或者文件目录的名称数组 |
| listFiles()       | 获取指定目录下的所有文件或者文件目录的File数组 |

（2）代码示例

```java
public class Demo {
    @Test
    public void test() {
        File file1 = new File("hello.txt");
        // getAbsolutePath()：获取绝对路径
        System.out.println(file1.getAbsolutePath());// D:\Java\IDEA-2018.2.7\Java\JavaSE\JavaSE_7_IO流\hello.txt
        // getPath()：获取路径
        System.out.println(file1.getPath());// hello.txt
        // getName()：获取名称
        System.out.println(file1.getName());// hello.txt
        // getParent()：获取上层文件目录路径，若无则返回null
        System.out.println(file1.getParent());// null
        // length()：获取文件长度（字节数）,不能获取目录的长度。
        System.out.println(file1.length());//5
        // lastModified()：获取最后一次的修改时间，毫秒值
        System.out.println(file1.lastModified());//1667315658044
        System.out.println(new Date(file1.lastModified()));//Tue Nov 01 23:14:18 CST 2022

        File file2 = new File("E:\\java");
        // list()：获取指定目录下的所有文件或者文件目录的名称数组
        String[] list = file2.list();
        // 遍历
        for (String f : list) {
            System.out.println(f);
        }
        // listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
        File[] files = file2.listFiles();
        // 遍历
        for (File f : files) {
            System.out.println(f);
        }
    }
}
```

#### 重命名操作

（1）方法示例

| 方法                | 简介                         |
| ------------------- | ---------------------------- |
| renameTo(File dest) | 把文件重命名为指定的文件路径 |

（2）代码示例

```java
public class Demo {
    @Test
    public void test(){
        // public boolean renameTo(File dest)：把文件重命名为指定的文件路径
        File file1 = new File("E:\\test\\hello.txt");
        File file2 = new File("hello.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }
}
```

#### 判断操作

（1）方法示例

| 方法          | 简介               |
| ------------- | ------------------ |
| isDirectory() | 判断是否是文件目录 |
| isFile()      | 判断是否是文件     |
| exists()      | 判断是否存在       |
| canRead()     | 判断是否可读       |
| canWrite()    | 判断是否可写       |
| isHidden()    | 判断是否隐藏       |

（2）代码示例

```java
public class Demo {
    @Test
    public void test() {
        File file = new File("hello.txt");
        // isDirectory()：判断是否是文件目录
        System.out.println(file.isDirectory());//false
        // isFile()：判断是否是文件
        System.out.println(file.isFile());//true
        // exists()：判断是否存在
        System.out.println(file.exists());//true
        // canRead()：判断是否可读
        System.out.println(file.canRead());//true
        // canWrite()：判断是否可写
        System.out.println(file.canWrite());//true
        // isHidden()：判断是否隐藏
        System.out.println(file.isHidden());//false
    }
}
```

#### 创建操作

（1）方法示例

注意事项：如果创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下

| 方法            | 简介                                                         |
| --------------- | ------------------------------------------------------------ |
| createNewFile() | 创建文件，若文件存在，则不创建，返回false                    |
| mkdir()         | 创建文件目录，  如果此文件目录存在，就不创建了   如果此文件目录的上层目录不存在，也不创建 |
| mkdirs()        | 创建文件目录，如果上层文件目录不存在，一并创建               |

（2）代码示例

```java
public class 创建操作 {
    @Test
    public void test5() throws IOException {
        File file1 = new File("test1.txt");
        // createNewFile()：创建文件。若文件存在，则不创建，返回false
        boolean exists = file1.createNewFile();
        if (exists) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }

        File file2 = new File("E:\\test1");
        // mkdir()：创建文件目录。如果此文件目录存在，就不创建了,如果此文件目录的上层目录不存在，也不创建（不能创建多级目录）
        // 如果file2不存在，就创建为目录，存在就打印失败
        boolean mkdir = file2.mkdir();
        if (mkdir) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }

        File file3 = new File("E:\\test1\\test2\\test3");
        // mkdirs()：创建文件目录。如果上层文件目录不存在，一并创建（可以创建多级目录）
        boolean mkdirs = file3.mkdirs();
        if (mkdirs) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
    }
}
```

#### 删除操作

（1）方法示例

注意事项： Java中的删除不走回收站，要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录

| 方法     | 简介               |
| -------- | ------------------ |
| delete() | 删除文件或者文件夹 |

（2）代码示例

```java
public class Demo {
    @Test
    public void test() throws IOException {
        File file = new File("test.txt");
        file.mkdir();
        boolean delete = file.delete();
        if (delete){
            System.out.println("删除成功");
        }else{
            System.out.println("没有这个文件");
        }
    }
}
```



## 字符流

### FileReader读取文件

```java
public class FileReaderTest {

    /**
     * 读取文件流程：
     * （1）实例化File类的对象，指明要操作的文件
     * （2）提供具体流读取文件，FileReader
     * （3）数据的读入：创建一个临时存放数据的数组、调用流对象的读取方法，将流中的数据读入到数组中，并遍历数组
     * （4）流的关闭操作
     */
    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");

            //（2）提供具体流读取文件，FileReader
            fileReader = new FileReader(file);

            //（3）数据的读入
            // read()：返回读入的一个字符，如果达到文件末尾，返回-1
            int data = fileReader.read();//记录每次读入到数组的个数
            while (data != -1) {
                System.out.print((char) data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");

            //（2）提供具体流读取文件，FileReader
            fileReader = new FileReader(file);

            //（3）数据的读入
            int data;//记录每次读入到数组的个数
            // read()：返回读入的一个字符，如果达到文件末尾，返回-1
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取文件优化：对read()操作升级，使用read的重载方法
     */
    @Test
    public void test3() {
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //（2）提供具体流
            fileReader = new FileReader(file);
            //（3）数据的读入
            char[] c = new char[5];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = fileReader.read(c)) != -1) {
                for (int i = 0; i < num; i++) {
                    System.out.print(c[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() {
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //（2）提供具体流
            fileReader = new FileReader(file);
            //（3）数据的读入
            char[] c = new char[5];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = fileReader.read(c)) != -1) {
                String str = new String(c, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
```



### FileWriter写出文件

```java
public class FileWriterTest {
    /**
     * 写出文件流程：
     * （1）实例化File类的对象，指明写出的文件及地址
     * （2）提供具体流写出文件，FileWriter
     * （3）从内存中写出数据到硬盘的文件里
     * （4）流的关闭操作
     * 注意事项：
     * （1）File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
     * （2）File对应的硬盘中的文件如果存在，
     * 如果流使用的构造器是FileWrite(file,false)、FileWrite(file)，则会对原有文件覆盖
     * 如果流使用的构造器是FileWrite(file,true)，则不会对原有文件覆盖，而是进行追加数据
     */
    @Test
    public void test() {
        FileWriter fileWriter = null;
        try {
            //（1）实例化File类的对象，指明写出的文件及地址
            File file = new File("E:\\test.txt");
            //（2）提供具体流写出文件，FileWriter
            fileWriter = new FileWriter(file);
            //（3）从内存中写出数据到硬盘的文件里
            fileWriter.write("FileWriter流测试");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



### FileReader、FileWriter复制文件

```java
public class FileReader_FileWriter_Copy {
    /**
     * 读取并写出（文本文件复制）
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，输入流和输出流fileReader、FileWriter
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     */
    @Test
    public void test() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("hello.txt");
            File file2 = new File("E:\\test.txt");

            //（2）提供具体流读写文件，输入流和输出流fileReader、FileWriter
            fileReader = new FileReader(file1);// 读取
            fileWriter = new FileWriter(file2);// 写出

            //（3）读入数据并写出数据到硬盘的文件里（复制的过程）
            char[] c = new char[5];//创建一个临时存放数据的数组
            int num;// 记录每次读入到数组的个数
            while ((num = fileReader.read(c)) != -1) {
                // 每次写入num个字符
                fileWriter.write(c, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



## 字节流

### FileInputStream读取文件

```java
public class FileInputStreamTest {
    /**
     * 文件读取
     * （1）实例化File类的对象，指明要操作的文件
     * （2）造字节输入流，FileInputStream
     * （3）读数据
     * （4）关闭流
     */
    @Test
    public void test() {
        FileInputStream fileInputStream = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("1.png");
            //（2）造字节流，FileInputStream
            fileInputStream = new FileInputStream(file);
            //（3）读数据
            byte[] b = new byte[3];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = fileInputStream.read(b)) != -1) {
                String str = new String(b, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）关闭流
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### FileOutputStream写出文件

```java
public class FileOutputStreamTest {
    /**
     * 写出文件流程：
     * （1）实例化File类的对象，指明写出的文件及地址
     * （2）造字节输出流，FileOutputStream
     * （3）从内存中写出数据到硬盘的文件里
     * （4）关闭流
     */
    @Test
    public void test() {
        FileOutputStream fileOutputStream = null;
        try {
            //（1）实例化File类的对象，指明写出的文件及地址
            File file = new File("E:\\test.txt");
            //（2）造流
            fileOutputStream = new FileOutputStream(file);
            //（3）从内存中写出数据到硬盘的文件里
            fileOutputStream.write(12345);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）关闭流
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### FileInputStream、FileOutputStream复制文件

（1）FileInputStream、FileOutputStream复制非文本文件复制

```java
public class FileInputStream_FileOutputStream_Copy {
    /**
     * 非文本文件复制:.mp3、mp4、.avi、.rmvb、.jpg、.doc、.ppt
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，输入流和输出流FileInputStream、FileOutputStream
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     */
    @Test
    public void test() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("1.png");
            File file2 = new File("E:\\1.png");
            //（2）提供具体流读写文件，输入流和输出流FileInputStream、FileOutputStream
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);
            //（3）读入数据并写出数据到硬盘的文件里(复制的过程)
            byte[] b = new byte[3];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = fileInputStream.read(b)) != -1) {
                //每次写入num个字符
                fileOutputStream.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

（2）复制代码逻辑封装

```java
public class copyUtils {

    public static void main(String[] args) {
        // 获取开始的时间
        long startTime = System.currentTimeMillis();

        // 调用封装的复制文件逻辑实现复制
        String startPath = "E:\\1.png";
        String endPath = "E:\\1.png";
        copyFile(startPath, endPath);

        // 获取结束的时间
        long endTime = System.currentTimeMillis();

        System.out.println("复制花费的时间为：" + (endTime - startTime));//54
    }

    /**
     * 指定路径下的文件复制：将代码封装，使用时只需要填入开始与结束路径
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，输入流和输出流FileInputStream、FileOutputStream
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     *
     * @param startPath 开始路径
     * @param endPath   结束路径
     */
    public static void copyFile(String startPath, String endPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File(startPath);
            File file2 = new File(endPath);
            //（2）提供具体流读写文件，输入流和输出流FileInputStream、FileOutputStream
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);
            //（3）读入数据并写出数据到硬盘的文件里（复制的过程）
            byte[] b = new byte[3];
            int num;//记录每次读入到数组的个数
            while ((num = fileInputStream.read(b)) != -1) {
                //每次写入num个字符
                fileOutputStream.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



## 字符缓冲流

### BufferedReader

```java
public class BufferedReaderTest {
    /**
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读文件，输入流FileReader、输入缓冲流bufferedReader
     * （3）读取数据
     * （4）流的关闭操作
     * 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
     */
    @Test
    public void readerFile() {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file = new File("hello.txt");
            //（2）提供具体流读写文件
            //造节点流
            fileReader = new FileReader(file);
            //造缓冲流
            bufferedReader = new BufferedReader(fileReader);
            //（3）读取数据
            char[] c = new char[3];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = bufferedReader.read(c)) != -1) {
                String str = new String(c, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作(关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略)
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



### BufferedWriter

```java
public class BufferedWriterTest {
    @Test
    public void writerFile() {
        BufferedWriter bufferedWriter = null;
        try {
            //（1）实例化File类的对象，指明写出的文件及地址
            File file = new File("E:\\test.txt");
            //（2）提供具体流写出文件，FileWriter
            // 造节点流
            FileWriter fileWriter = new FileWriter(file);
            // 造缓冲流
            bufferedWriter = new BufferedWriter(fileWriter);
            //（3）从内存中写出数据到硬盘的文件里
            bufferedWriter.write("hello");
            bufferedWriter.newLine();//插入一个和系统相关的换行符
            bufferedWriter.write("hello");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\note.txt";
        //（1）创建BufferedWriter,在节点流上多一个 true 表示追加写入内容，不加就是覆盖
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        //（2）写入内容与换行
        bufferedWriter.write("hello");
        bufferedWriter.newLine();//插入一个和系统相关的换行符
        bufferedWriter.write("hello");

        //（3）关闭外层流即可，传入的 new FileWriter(filePath)会在底层自动关闭
        bufferedWriter.close();
    }
}
```

### BufferedReader、BufferedWriter复制文件

```java
public class BufferedReader_BufferedWriter_Copy {
    /**
     * 指定路径下的文件复制：将代码封装，使用时只需要填入开始与结束路径
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，
     * 输入流和输出流FileReader、FileWriter
     * 输入缓冲流和输出缓冲流bufferedReader、bufferedWriter
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     * 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
     */
    @Test
    //文本文件复制
    public void copyFile() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("E:\\1.png");
            File file2 = new File("E:\\1.png");
            //（2）提供具体流读写文件
            // 造节点流
            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2);
			// 造缓冲流
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            //（3）复制的细节：读取、写入
            char[] c = new char[3];
            int num;//记录每次读入到数组的个数
            while ((num = bufferedReader.read(c)) != -1) {
                //每次写入num个字符
                bufferedWriter.write(c, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作(关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略)
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



## 字节缓冲流

### BufferedInputStream

```java
public class BufferedInputStreamTest {
    @Test
    public void inputFile() {
        BufferedInputStream bufferedInputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("1.png");

            //（2）提供具体流读写文件
            //造节点流
            FileInputStream fileInputStream = new FileInputStream(file1);
            //造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            //（3）复制的细节：读取、写入
            byte[] b = new byte[3];
            int num;//记录每次读入到数组的个数
            while ((num = bufferedInputStream.read(b)) != -1) {
                String str = new String(b, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            // 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



### BufferedOutputStream

```java
public class BufferedOutputStreamTest {
    /**
     * 写出文件流程：
     * （1）实例化File类的对象，指明写出的文件及地址
     * （2）造字节输出流和缓冲流，FileOutputStream、BufferedOutputStream
     * （3）从内存中写出数据到硬盘的文件里
     * （4）关闭流
     */
    @Test
    public void outputFile() {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //（1）实例化File类的对象，指明写出的文件及地址
            File file = new File("E:\\test.txt");
            //（2）造流
            //造节点流
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            //造缓冲流
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //（3）从内存中写出数据到硬盘的文件里
            bufferedOutputStream.write(12345);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）关闭流
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



### BufferedInputStream、BufferedOutputStream复制文件

（1）FileInputStream、FileOutputStream复制非文本文件复制

```java
public class BufferedInputStream_BufferedOutputStream_Copy {
    /**
     * 指定路径下的文件复制：将代码封装，使用时只需要填入开始与结束路径
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，
     * 输入流和输出流FileInputStream、FileOutputStream
     * 输入缓冲流和输出缓冲流bufferedInputStream、bufferedOutputStream
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     * 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
     */
    @Test
    public void copyFile() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("E:\\1.png");
            File file2 = new File("E:\\1.png");

            //（2）提供具体流读写文件
            //造节点流
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            //造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //（3）复制的细节：读取、写入
            byte[] b = new byte[3];
            int num;//记录每次读入到数组的个数
            while ((num = bufferedInputStream.read(b)) != -1) {
                //每次写入num个字符
                bufferedOutputStream.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            // 先关闭外侧的流，再关闭内层的流
            //先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

（2）复制代码逻辑封装

```java
public class Demo {

    public static void main(String[] args) {
        // 获取开始的时间
        long startTime = System.currentTimeMillis();

        // 调用封装的复制文件逻辑实现复制
        String startPath = "E:\\1.png";
        String endPath = "E:\\1.png";
        copyFile(startPath, endPath);

        // 获取结束的时间
        long endTime = System.currentTimeMillis();

        System.out.println("复制花费的时间为：" + (endTime - startTime));//1
    }

    /**
     * 指定路径下的文件复制：将代码封装，使用时只需要填入开始与结束路径
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，
     * 输入流和输出流FileInputStream、FileOutputStream
     * 输入缓冲流和输出缓冲流bufferedInputStream、bufferedOutputStream
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     * 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
     *
     * @param startPath 开始路径
     * @param endPath   结束路径
     */
    //指定路径下的文件复制
    //将代码封装，使用时只需要填入开始与结束路径
    public static void copyFile(String startPath, String endPath) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File(startPath);
            File file2 = new File(endPath);

            //（2）提供具体流读写文件
            //造节点流
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            //造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //（3）复制的细节：读取、写入
            byte[] b = new byte[3];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = bufferedInputStream.read(b)) != -1) {
                //每次写入num个字符
                bufferedOutputStream.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            // 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



## 转换流

```java
public class Demo {
    /**
     * 将已有的utf-8格式的文件装换为gbk格式
     * 解码：字节、字节数组 —> 字符串、字符数组
     * 编码：字符串、字符数组 —> 字节、字节数组
     */
    @Test
    public void test() throws IOException {
        InputStreamReader inputStreamReader = null;
        java.io.OutputStreamWriter outputStreamWriter = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("hello.txt");
            File file2 = new File("test.txt");

            //（2）提供具体流读写字节文件，输入流和输出流FileInputStream、FileOutputStream
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");

            //（3）读入数据并写出数据到硬盘的文件里(复制的过程)
            char[] c = new char[5];
            int num;//记录每次读入到数组的个数
            while ((num = inputStreamReader.read(c)) != -1) {
                //每次写入num个字符
                outputStreamWriter.write(c, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        }
    }
}
```



## 对象流

### ObjectOutputStream序列化

```java
public class Demo {
    /**
     * 序列化：对象—>字节序列
     * 用ObjectOutputStream类将内存中的java对象保存到磁盘中或通过网络传输出去
     */
    @Test
    public void test() {
        ObjectOutputStream objectOutputStream = null;
        try {
            //（1）创建连接到指定文件的数据输出流对象
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("hello.txt"));
            //（2）写入对象数据
            objectOutputStream.writeObject(new String("你好java"));
            objectOutputStream.writeObject(new Person("小明", 18));
            objectOutputStream.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）关闭流
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### ObjectInputStream反序列化

```java
public class Demo {
    /**
     * 反序列化：字节序列—>对象
     * 用ObjectInputStream类将磁盘文件读取(还原)为内存中的一个java对象
     */
    @Test
    public void test() {
        ObjectInputStream objectInputStream = null;
        try {
            //（1）创建连接到指定文件的数据输入流对象
            objectInputStream = new ObjectInputStream(new FileInputStream("hello.txt"));
            //（2）读取对象数据
            Object o = objectInputStream.readObject();
            String str = (String) o;
            Person person = (Person) objectInputStream.readObject();

            System.out.println(str);//你好java
            System.out.println(person);//Person{name='小明', age=18}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



## 数据流

### DataOutputStream

```java
public class DataOutputStreamTest {
    /**
     * 将内存中的字符串、基本数据类型的变量写出到文件中
     */
    @Test
    public void test() {
        DataOutputStream dataOutputStream = null;
        try {
            //（1）创建连接到指定文件的数据输出流对象
            dataOutputStream = new DataOutputStream(new FileOutputStream("test.txt"));
            //（2）写入数据
            dataOutputStream.writeUTF("你好!"); // 写UTF字符串
            dataOutputStream.writeBoolean(false); // 写入布尔值
            dataOutputStream.writeLong(1234567890L); // 写入长整数
            System.out.println("写文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）关闭过滤流时,会自动关闭它包装的底层节点流
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



### DataInputStream

```java
public class DataInputStreamTest {
    /**
     * 将文件中的字符串、基本数据类型的变量读取到内存中(保存在变量中)
     */
    @Test
    public void test() {
        DataInputStream dataInputStream = null;
        try {
            //（1）创建连接到指定文件的数据输入流对象
            dataInputStream = new DataInputStream(new FileInputStream("E:\\test.txt"));
            //（2）读取数据
            String info = dataInputStream.readUTF();
            boolean flag = dataInputStream.readBoolean();
            long time = dataInputStream.readLong();
            System.out.println(info);
            System.out.println(flag);
            System.out.println(time);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）关闭过滤流时,会自动关闭它包装的底层节点流
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



## 打印流

```java
public class PrintStreamTest {
    /**
     * 将控制台输出的数据改为输出为文件
     */
    @Test
    public void test() {
        PrintStream printStream = null;
        try {
            //（1）指明输出文件地址并提供流
            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\text.txt"));
            //（2）创建打印输出流,把标准输出流改成输出为文件
            // true表示设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            printStream = new PrintStream(fileOutputStream, true);
            // 如果不为空就把控制台输出的数据改为输出为文件
            if (printStream != null) {
                System.setOut(printStream);
            }
            //（3）打印输出的数据：打印ASCII字符
            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                //设置每50个数据换一行
                if (i % 50 == 0) {
                    System.out.println(); //换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}
```

## 其他流

### 标准输入输出流

| 标准输入输出流 | 简介                           |
| -------------- | ------------------------------ |
| System.in      | 标准的输入流，默认从键盘输入   |
| System.out     | 标准的输出流，默认从控制台输出 |

```java
public class Demo {
    /**
     * 例题：
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
     * 然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
     * 实现方式
     * 方式一：使用Scanner实现
     * 方式二：使用标准输入输出流
     */
    @Test
    public void test1() {
        Scanner scan = new Scanner(System.in);
        String num = scan.next();

        System.out.println("请输入字符：");
        while (true) {
            //判断是否为e或exit，如果是就退出，否则变为大写
            //equalsIgnoreCase()：忽略大小写判断是否为某个值
            if ("e".equalsIgnoreCase(num) || "exit".equalsIgnoreCase(num)) {
                System.out.println("安全退出!!");
                break;//退出并结束程序
            } else {
                //toUpperCase()：将读取到的整行字符串转成大写输出
                System.out.println(num.toUpperCase());
            }
        }
    }

    @Test
    public void test2() {
        System.out.println("请输入信息(退出输入e或exit):");
        // 把"标准"输入流(键盘输入)这个字节流包装成字符流,再包装成缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            while ((s = br.readLine()) != null) {
                //判断是否为e或exit，如果是就退出，否则变为大写
                //equalsIgnoreCase()：忽略大小写判断是否为某个值
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("安全退出!!");
                    break;//退出并结束程序
                }
                //toUpperCase()：将读取到的整行字符串转成大写输出
                System.out.println("-->:" + s.toUpperCase());
                System.out.println("继续输入信息");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    //关闭过滤流时,会自动关闭它包装的底层节点流
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```



## RandomAccessFile类

### 简介

（1）RandomAccessFile类是 Java 输入/输出流体系中功能最丰富的文件内容访问类，不属于流但提供了众多的方法来访问文件内容，可以读取文件内容，也可以向文件输出数据，既可以作为一个输入流也可以作为一个输出流，

（2）RandomAccessFile类直接继承于java.lang.Object类，实现了DataInput、DataOutput这两个接口，与普通的输入/输出流不同的是，RandomAccessFile 支持“随机访问”的方式，程序可以直接跳转到文件的任意地方来读写数据。

（3）与输入输出流不同的是，RandomAccessFile类允许自由定位文件记录指针，可以不从开始的地方开始输出，因此如果只需要访问文件部分内容，而不是把文件从头读到尾或向已存在的文件后追加内容，使用 RandomAccessFile类是更好的选择

（4）RandomAccessFile 类的构造器

| 构造器                                     | 简介                                              |
| ------------------------------------------ | ------------------------------------------------- |
| RandomAccessFile(File file, String mode)   | 使用File参数来指定文件本身，mode 参数用来访问模式 |
| RandomAccessFile(String name, String mode) | 使用String参数来指定文件名，mode 参数用来访问模式 |

创建 RandomAccessFile 类实例需要指定一个 mode 参数，该参数指定 RandomAccessFile 的访问模式

| 访问模式 | 简介                                           |
| -------- | ---------------------------------------------- |
| r        | 以只读方式打开                                 |
| rw       | 打开以便读取和写入                             |
| rwd      | 打开以便读取和写入；同步文件内容的更新         |
| rws      | 打开以便读取和写入；同步文件内容和元数据的更新 |

（5）RandomAccessFile类常用的方法

| 方法                      | 简介                                                 |
| ------------------------- | ---------------------------------------------------- |
| skipBytes(int n)          | 使读写指针从当前位置开始，跳过n个字节                |
| write(byte[] b)           | 将指定的字节数组写入到这个文件，并从当前文件指针开始 |
| getFilePointer()          | 返回当前读写指针所处的位置                           |
| seek(long pos)            | 设定读写指针的位置，与文件的开头相隔pos个字节数      |
| setLength(long newLength) | 设置此文件的长度                                     |
| readLine()                | 从指定文件当前指针读取下一行内容                     |

### 文件的读写操作

```java
public class Demo {
    /**
     * RandomAccessFile类实现文件的读写操作
     */
    @Test
    public void test() {
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            randomAccessFile1 = new RandomAccessFile(new File("带土.jpg"), "r");
            randomAccessFile2 = new RandomAccessFile(new File("带土111.jpg"), "rw");

            //（2）数据的读入
            int num;
            byte[] b = new byte[3];
            while ((num = randomAccessFile1.read(b)) != -1) {
                randomAccessFile2.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）流的关闭操作
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### 数据的插入操作

```java
public class Demo {
    /**
     * RandomAccessFile类实现数据的插入
     */
    @Test
    public void test() {
        RandomAccessFile randomAccessFile = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            randomAccessFile = new RandomAccessFile(new File("hello.txt"), "rw");

            //（2）数据的操作
            randomAccessFile.seek(3);//将文件记录指针定位到 3 的位置
            //保存指针3后面的所有数据到stringBuffer中
            StringBuffer stringBuffer = new StringBuffer((int) (new File("hello.txt").length()));
            byte[] b = new byte[5];
            int num;
            while ((num = randomAccessFile.read(b)) != -1) {
                String str = new String(b, 0, num);
                stringBuffer.append(str);
            }
            //调回指针写入数据
            randomAccessFile.seek(3);//将文件记录指针定位到 3 的位置
            randomAccessFile.write("123".getBytes());//覆盖
            //将stringBuffer中的数据再写入到文件
            randomAccessFile.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）流的关闭操作
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

## NIO

### I/O 模型基本说明

（1）I/O 模型简单的理解：用什么样的通道进行数据的发送和接收，很大程度上决定了程序通信的性能

（2）Java共支持3种网络编程模型/IO模式：BIO、NIO、AIO

| 网络编程模型 | 简介                                                         |
| ------------ | ------------------------------------------------------------ |
| BIO          | 同步并阻塞(传统阻塞型)，就是传统的java IO 编程，其相关的类和接口在 java.io包下，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进行处理，如果这个连接不做任何事情会造成不必要的线程开销。 |
| NIO          | 同步非阻塞，服务器实现模式为一个线程处理多个请求(连接)，即客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有I/O请求就进行处理 |
| AIO（NIO.2） | 异步非阻塞，AIO 引入异步通道的概念，采用了 Proactor 模式，简化了程序编写，有效的请求才启动线程，它的特点是先由操作系统完成后才通知服务端程序启动线程去处理，一般适用于连接数较多且连接时间较长的应用 |

（3）BIO、NIO、AIO适用场景分析

| 网络编程模型 | 适用场景                                                     |
| ------------ | ------------------------------------------------------------ |
| BIO          | 适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4以前的唯一选择，但程序简单易理解 |
| NIO          | 适用于连接数目多且连接比较短（轻操作）的架构，比如聊天服务器，弹幕系统，服务器间通讯等。编程比较复杂，JDK1.4开始支持 |
| AIO（NIO.2） | 适用于连接数目多且连接比较长（重操作）的架构，比如相册服务器，充分调用OS参与并发操作，编程比较复杂，JDK7开始支持 |

（4）BIO、NIO、AIO对比

| 对比     | BIO      | NIO                   | AIO        |
| -------- | -------- | --------------------- | ---------- |
| IO模型   | 同步阻塞 | 同步非阻塞 (多路复用) | 异步非阻塞 |
| 编程难度 | 简单     | 复杂                  | 复杂       |
| 可靠性   | 差       | 好                    | 好         |
| 吞吐量   | 低       | 高                    | 高         |

### NIO 基本介绍

（1）Java NIO（New IO，Non-Blocking IO）是从Java 1.4版本开始引入的一套新的IO API，可以替代标准的Java IO API，提供了一系列改进的输入/输出的新特性，相关类都被放在 java.nio 包及子包下，并且对原 java.io 包中的很多类进行改写

（2）NIO与原来的IO有同样的作用和目的，但是使用的方式完全不同，NIO支持面向缓冲区的（IO是面向流的）、基于通道的IO操作，将以更加高效的方式进行文件的读写操作。

（3）NIO 有三大核心部分：Channel(通道)、Buffer(缓冲区)、Selector(选择器)

| 核心   | 简介                                                         |
| ------ | ------------------------------------------------------------ |
| 通道   | Channel(通道)表示到实体如硬件设备、文件、网络套接字或可以执行一个或多个不同I/O操作的程序组件的开放的连接，Channel和传统IO中的Stream很相似 |
| 缓冲区 | 缓冲区有直接缓冲区和非直接缓冲区之分，实际上也是一段内存空间，在NIO库中，所有数据都是用缓冲区处理的。在读取数据时，它是直接读到缓冲区中的； 在写入数据时，它也是写入到缓冲区中的 |
| 选择器 | Selector类是NIO的核心类，提供了选择已经就绪的任务的能力      |

（4）BIO 以流的方式处理数据，而 NIO 以块的方式处理数据，块 I/O 的效率比流 I/O 高很多

### AIO 基本介绍

（1）AIO 即 NIO2.0，叫做异步不阻塞的 IO，随着 JDK 7 的发布，Java对NIO进行了极大的扩展，增强了对文件处理和文件系统特性的支持，以至于称他们为 NIO.2。

（2）因为 NIO 提供的一些功能，NIO已经成为文件处理中越来越重要的部分，Netty 也是基于NIO，而不是AIO

（3）Jdk 7.0 时，引入了 Path、Paths、Files三个类，此三个类声明在java.nio.file包下

| 类    | 简介                                                         |
| ----- | ------------------------------------------------------------ |
| Path  | Path类中包含了常用的操作路径的方法，可以看做是java.io.File类的升级版本 |
| Paths | Paths工具类包含了两个返回Path对象的静态方法，提供的静态 get() 方法用来获取 Path 对象 |
| Files | Files是一个操作文件的工具类，包含了大量静态方法，对旧的IO常用的功能进行了高度封装 |

#### Paths

| 静态方法                                     | 简介                       |
| -------------------------------------------- | -------------------------- |
| static Path get(String first, String … more) | 用于将多个字符串串连成路径 |
| static Path get(URI uri)                     | 返回指定uri对应的Path路径  |

```java
@Test
publicvoidtest1(){
	//使用Paths实例化Path
	Pathpath1=Paths.get("E:\\nio\\hello.txt");//newFile(Stringfilepath)
	Pathpath2=Paths.get("E:\\","nio\\hello.txt");//newFile(Stringparent,Stringfilename);
	System.out.println(path1);//E:\nio\hello.txt
	System.out.println(path2);//E:\nio\hello.txt
}
```

#### Path

| 常用方法                         | 简介                                                      |
| -------------------------------- | --------------------------------------------------------- |
| String toString()                | 返回调用 Path 对象的字符串表示形式                        |
| boolean  startsWith(String path) | 判断是否以 path 路径开始                                  |
| boolean  endsWith(String path)   | 判断是否以 path 路径结束                                  |
| boolean isAbsolute()             | 判断是否是绝对路径                                        |
| Path getParent()                 | 返回Path对象包含整个路径，不包含  Path 对象指定的文件路径 |
| Path getRoot()                   | 返回调用 Path 对象的根路径                                |
| Path getFileName()               | 返回与调用 Path 对象关联的文件名                          |
| int getNameCount()               | 返回Path 根目录后面元素的数量                             |
| Path getName(int idx)            | 返回指定索引位置 idx 的路径名称                           |
| Path toAbsolutePath()            | 作为绝对路径返回调用 Path 对象                            |
| Path resolve(Path p)             | 合并两个路径，返回合并后的路径对应的Path对象              |
| File toFile()                    | 将Path转化为File类的对象                                  |

```java
public class PathTest {

    /**
     * 使用Paths实例化Path
     */
    @Test
    public void test1() {
        Path path1 = Paths.get("E:\\nio\\hello.txt");// new File(String filepath)
        Path path2 = Paths.get("E:\\", "nio\\hello.txt");//new File(String parent,String filename);

        System.out.println(path1);// E:\nio\hello.txt
        System.out.println(path2);// E:\nio\hello.txt
    }

    /**
     * Path中的常用方法
     */
    @Test
    public void test2() {
        Path path1 = Paths.get("E:\\", "nio\\nio1\\nio2\\hello.txt");
        Path path2 = Paths.get("hello.txt");

        // String toString() ： 返回调用 Path 对象的字符串表示形式
        System.out.println(path1);

        // boolean startsWith(String path) : 判断是否以 path 路径开始
        System.out.println(path1.startsWith("d:\\nio"));
        // boolean endsWith(String path) : 判断是否以 path 路径结束
        System.out.println(path1.endsWith("hello.txt"));
        // boolean isAbsolute() : 判断是否是绝对路径
        System.out.println(path1.isAbsolute() + "~");
        System.out.println(path2.isAbsolute() + "~");
        // Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
        System.out.println(path1.getParent());
        System.out.println(path2.getParent());
        // Path getRoot() ：返回调用 Path 对象的根路径
        System.out.println(path1.getRoot());
        System.out.println(path2.getRoot());
        // Path getFileName() : 返回与调用 Path 对象关联的文件名
        System.out.println(path1.getFileName() + "~");
        System.out.println(path2.getFileName() + "~");
        // int getNameCount() : 返回Path 根目录后面元素的数量
        // Path getName(int idx) : 返回指定索引位置 idx 的路径名称
        for (int i = 0; i < path1.getNameCount(); i++) {
            System.out.println(path1.getName(i) + "*****");
        }

        // Path toAbsolutePath() : 作为绝对路径返回调用 Path 对象
        System.out.println(path1.toAbsolutePath());
        System.out.println(path2.toAbsolutePath());
        // Path resolve(Path p) :合并两个路径，返回合并后的路径对应的Path对象
        Path path3 = Paths.get("d:\\", "nio");
        Path path4 = Paths.get("nioo\\hi.txt");
        path3 = path3.resolve(path4);
        System.out.println(path3);

        // File toFile(): 将Path转化为File类的对象
        File file = path1.toFile();//Path--->File的转换
        Path newPath = file.toPath();//File--->Path的转换
    }
}
```

#### Files

（1）常用方法

| 常用方法                                               | 简介                                    |
| ------------------------------------------------------ | --------------------------------------- |
| Path copy(Path src,  Path dest, CopyOption … how)      | 文件的复制                              |
| Path  createDirectory(Path path, FileAttribute … attr) | 创建一个目录                            |
| Path createFile(Path  path, FileAttribute … arr)       | 创建一个文件                            |
| void delete(Path  path)                                | 删除一个文件/目录，如果不存在，执行报错 |
| void  deleteIfExists(Path path)                        | Path对应的文件/目录如果存在，执行删除   |
| Path move(Path src,  Path dest, CopyOption…how)        | 将 src 移动到 dest 位置                 |
| long size(Path path)                                   | 返回 path 指定文件的大小                |

（2）用于判断

| 常用方法                                             | 简介               |
| ---------------------------------------------------- | ------------------ |
| boolean exists(Path  path, LinkOption … opts)        | 判断文件是否存在   |
| boolean  isDirectory(Path path, LinkOption … opts)   | 判断是否是目录     |
| boolean  isRegularFile(Path path, LinkOption … opts) | 判断是否是文件     |
| boolean isHidden(Path  path)                         | 判断是否是隐藏文件 |
| boolean  isReadable(Path path)                       | 判断文件是否可读   |
| boolean  isWritable(Path path)                       | 判断文件是否可写   |
| boolean  notExists(Path path, LinkOption … opts)     | 判断文件是否不存在 |

（3）用于操作内容

| 常用方法                                                     | 简介                                       |
| ------------------------------------------------------------ | ------------------------------------------ |
| SeekableByteChannel  newByteChannel(Path path, OpenOption…how) | 获取与指定文件的连 接，how  指定打开方式。 |
| DirectoryStream  newDirectoryStream(Path path)               | 打开 path 指定的目录                       |
| InputStream  newInputStream(Path path, OpenOption…how)       | 获取 InputStream 对象                      |
| OutputStream  newOutputStream(Path path, OpenOption…how)     | 获取 OutputStream 对象                     |

```java
/**
 * Files工具类的使用：操作文件或目录的工具类
 */
public class FilesTest {

    @Test
    public void test1() throws IOException {
        Path path1 = Paths.get("d:\\nio", "hello.txt");
        Path path2 = Paths.get("atguigu.txt");

        // Path copy(Path src, Path dest, CopyOption … how) : 文件的复制
        //要想复制成功，要求path1对应的物理上的文件存在。path1对应的文件没有要求。
        // Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);

        // Path createDirectory(Path path, FileAttribute<?> … attr) : 创建一个目录
        //要想执行成功，要求path对应的物理上的文件目录不存在。一旦存在，抛出异常。
        Path path3 = Paths.get("d:\\nio\\nio1");
        // Files.createDirectory(path3);

        // Path createFile(Path path, FileAttribute<?> … arr) : 创建一个文件
        // 要想执行成功，要求path对应的物理上的文件不存在。一旦存在，抛出异常。
        Path path4 = Paths.get("d:\\nio\\hi.txt");
        // Files.createFile(path4);

        // void delete(Path path) : 删除一个文件/目录，如果不存在，执行报错
        // Files.delete(path4);

        // void deleteIfExists(Path path) : Path对应的文件/目录如果存在，执行删除.如果不存在，正常执行结束
        Files.deleteIfExists(path3);

        // Path move(Path src, Path dest, CopyOption…how) : 将 src 移动到 dest 位置
        // 要想执行成功，src对应的物理上的文件需要存在，dest对应的文件没有要求。
        // Files.move(path1, path2, StandardCopyOption.ATOMIC_MOVE);

        // long size(Path path) : 返回 path 指定文件的大小
        long size = Files.size(path2);
        System.out.println(size);

    }

    @Test
    public void test2() throws IOException {
        Path path1 = Paths.get("d:\\nio", "hello.txt");
        Path path2 = Paths.get("atguigu.txt");
        // boolean exists(Path path, LinkOption … opts) : 判断文件是否存在
        System.out.println(Files.exists(path2, LinkOption.NOFOLLOW_LINKS));

        // boolean isDirectory(Path path, LinkOption … opts) : 判断是否是目录
        // 不要求此path对应的物理文件存在。
        System.out.println(Files.isDirectory(path1, LinkOption.NOFOLLOW_LINKS));

        // boolean isRegularFile(Path path, LinkOption … opts) : 判断是否是文件

        // boolean isHidden(Path path) : 判断是否是隐藏文件
        // 要求此path对应的物理上的文件需要存在。才可判断是否隐藏。否则，抛异常。
        // System.out.println(Files.isHidden(path1));

        // boolean isReadable(Path path) : 判断文件是否可读
        System.out.println(Files.isReadable(path1));
        // boolean isWritable(Path path) : 判断文件是否可写
        System.out.println(Files.isWritable(path1));
        // boolean notExists(Path path, LinkOption … opts) : 判断文件是否不存在
        System.out.println(Files.notExists(path1, LinkOption.NOFOLLOW_LINKS));
    }

    /**
     * StandardOpenOption.READ：表示对应的Channel是可读的。
     * StandardOpenOption.WRITE：表示对应的Channel是可写的。
     * StandardOpenOption.CREATE：如果要写出的文件不存在，则创建。如果存在，忽略
     * StandardOpenOption.CREATE_NEW：如果要写出的文件不存在，则创建。如果存在，抛异常
     */
    @Test
    public void test3() throws IOException {
        Path path1 = Paths.get("d:\\nio", "hello.txt");

        // InputStream newInputStream(Path path, OpenOption…how):获取 InputStream 对象
        InputStream inputStream = Files.newInputStream(path1, StandardOpenOption.READ);

        // OutputStream newOutputStream(Path path, OpenOption…how) : 获取 OutputStream 对象
        OutputStream outputStream = Files.newOutputStream(path1, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // SeekableByteChannel newByteChannel(Path path, OpenOption…how) : 获取与指定文件的连接，how 指定打开方式。
        SeekableByteChannel channel = Files.newByteChannel(path1, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // DirectoryStream<Path>  newDirectoryStream(Path path) : 打开 path 指定的目录
        Path path2 = Paths.get("e:\\teach");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path2);
        Iterator<Path> iterator = directoryStream.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

