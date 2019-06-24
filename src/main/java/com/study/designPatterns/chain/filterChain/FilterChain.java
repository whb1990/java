package main.java.com.study.designPatterns.chain.filterChain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/6/13 14:17
 * @description: 定义责任链
 */


//过滤链条
public class FilterChain implements Filter {
    //用List集合来存储过滤规则
    List<Filter> filters = new ArrayList<>();
    //用于标记规则的引用顺序
    int index = 0;

    //往规则链条中添加规则
    public FilterChain addFilter(Filter f) {
        filters.add(f);
        //代码的设计技巧:Chain链添加过滤规则结束后返回添加后的Chain，方便我们下面doFilter函数的操作
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //index初始化为0,filters.size()为3，不会执行return操作
        if (index == filters.size()) {
            return;
        }
        //每添加一个过滤规则，index自增1
        Filter f = filters.get(index);
        index++;
        //根据索引值获取对应的规律规则对字符串进行处理
        f.doFilter(request, response, chain);
    }

    /**
     * 责任链测试
     * 数据消息在进入数据库之前，要被多种过滤规则进行处理，多种规则形成一种链，依次处理给定的数据消息
     *
     * @param args
     */
    public static void main(String[] args) {
        //设定过滤规则，对msg字符串进行过滤处理
        String msg = ":):,<script>,敏感,被就业,网络授课";
        //过滤请求
        Request request = new Request();
        //将待处理的字符串传进去
        request.setRequestStr(msg);
        //处理结束给出响应
        Response response = new Response();
        //设置响应信息
        response.setResponseStr("response:");
        //FilterChain，过滤规则形成拦截链条
        FilterChain fc = new FilterChain();
        //规则链条添加过滤规则，采用链式调用
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter()).addFilter(new FaceFilter());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.doFilter(request, response, fc);
        //打印请求信息
        System.out.println(request.getRequestStr());
        //打印响应信息
        System.out.println(response.getResponseStr());
    }
}
