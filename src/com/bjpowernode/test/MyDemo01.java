package com.bjpowernode.test;

public class MyDemo01 {

    ThreadLocal<String> th = new ThreadLocal<>();
    // 变量
    private String content;

    private String getContent(){
        return th.get();
    }

    private void setContent(String content){
//        this. content = content;
        th.set(content);
    }

    public static void main(String[] args) {

        MyDemo01 demo = new MyDemo01();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
//                    System.out. println("-------------------------");
                    demo.setContent( Thread.currentThread().getName()+"的数据");
//                    System.out. println("-------------------------");
                    System.out. println(Thread.currentThread().getName()+"--->"+ demo.getContent());
                    System.out. println("-------------------------");
                    System.out.println("demo====="+demo.getContent());
                }
            });

            thread.setName("线程" + i);
            thread.start();

        }

    }
}
