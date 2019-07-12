import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Double d1 = 3d;
        Double d2 = 3d;
        System.out.println(d1.equals(d2));
        Double double1 = -0.0000001;
        System.out.println(double1 > 0);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Integer integer1 = 1;
        Integer integer4 = 4;
        System.out.println(set.contains(integer1) + "    " + set.contains(integer4));
        Integer integer3 = integer4 - 1;
        System.out.println("integer3 = " + integer3);

        BigDecimal b11 = new BigDecimal(3999);
        BigDecimal b22 = new BigDecimal(0.01);
        if (b11.compareTo(b22) > 0) {
            System.out.println(b11.compareTo(b22) > 0);
        }

        Double d = -0.1D;
        System.out.println("double.equals.bigDecimal = " + new BigDecimal(d).compareTo(new BigDecimal(0)));
        BigDecimal amount = new BigDecimal(120.00);
        Double imcomeRation = 8D;
        BigDecimal ratio = new BigDecimal(imcomeRation);
        BigDecimal income = amount.multiply(ratio).divide(new BigDecimal(100));
        System.out.println("收益：" + income.setScale(2, BigDecimal.ROUND_HALF_UP));

        BigDecimal b1 = new BigDecimal(0);
        BigDecimal b2 = new BigDecimal(0.0);
        System.out.println("b1 + b2 = " + b1.add(b2).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println("b1 - b2 = " + b1.subtract(b2).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println("b1.compareTo(0) = " + b1.compareTo(new BigDecimal(0)));
        System.out.println("b1.compareTo(b2) = " + b1.compareTo(b2));
        BigDecimal total = new BigDecimal(0);
        List<BigDecimal> list = new ArrayList<>();
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        for (BigDecimal tmp : list) {
            total = total.add(tmp);
        }
        System.out.println("total：" + total.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println("Hello World!");
        String ip = "10.1.128.231";
        //分割得到数组，获取下标3的数据
        ip = ip.split("\\.")[3];
        System.out.println("ip地址：" + ip);
        long start = System.currentTimeMillis() % 100000000000L;
        String orderNo = start + String.format("%03d", count.getAndIncrement()) + String.format("%03d", Integer.parseInt(ip));
        Long lastUserId = 3836234L % 10;
        orderNo = orderNo + lastUserId.toString();
        System.out.println("生成的orderNo：" + orderNo);
    }
}
