package main.java.com.study.designPatterns.chain.filterChain;

/**
 * @author: whb
 * @date: 2019/6/13 14:25
 * @description: 定义的过滤敏感字眼的过滤规则
 */
public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //处理字符串中的敏感信息，将被就业和谐成就业
        request.requestStr = request.requestStr.replace("被就业", "就业").replace("敏感", "")
                //后面添加的是便于我们观察代码执行步骤的字符串
                + "----SensitiveFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "----SensitiveFilter()";
    }
}
