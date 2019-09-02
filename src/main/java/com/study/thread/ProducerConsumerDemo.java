package main.java.com.study.thread;

/**
 * @author: whb
 * @date: 2019/9/2 17:18
 * @description: 生产者消费者模型测试
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}

/**
 * 仓库
 */
class Depot {
    /**
     * 仓库的容量
     */
    private int capacity;
    /**
     * 仓库的实际数量
     */
    private int size;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 生产
     *
     * @param val
     */
    public synchronized void produce(int val) {
        try {
            // left 表示“想要生产的数量”(有可能生产量太多，需多此生产)
            int left = val;
            while (left > 0) {
                // 库存已满时，等待“消费者”消费产品。
                while (size >= capacity) {
                    wait();
                }
                // 获取“实际生产的数量”(即库存中新增的数量)
                // 如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
                // 否则“实际增量”=“想要生产的数量”
                int inc = (size + left) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                // 通知“消费者”可以消费了。
                notifyAll();
            }
        } catch (InterruptedException e) {
        }
    }

    /**
     * 消费
     *
     * @param val
     */
    public synchronized void consume(int val) {
        try {
            // left 表示“客户要消费数量”(有可能消费量太大，库存不够，需多此消费)
            int left = val;
            while (left > 0) {
                // 库存为0时，等待“生产者”生产产品。
                while (size <= 0) {
                    wait();
                }
                // 获取“实际消费的数量”(即库存中实际减少的数量)
                // 如果“库存”<“客户要消费的数量”，则“实际消费量”=“库存”；
                // 否则，“实际消费量”=“客户要消费的数量”。
                int dec = (size < left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, dec, size);
                notifyAll();
            }
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return "capacity:" + capacity + ", actual size:" + size;
    }
}

/**
 * 生产者
 */
class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    /**
     * 消费产品：新建一个线程向仓库中生产产品。
     *
     * @param val
     */
    public void produce(final int val) {
        new Thread(() -> depot.produce(val)).start();
    }
}

/**
 * 消费者
 */
class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    /**
     * 消费产品：新建一个线程从仓库中消费产品。
     *
     * @param val
     */
    public void consume(final int val) {
        new Thread(() -> depot.consume(val)).start();
    }
}