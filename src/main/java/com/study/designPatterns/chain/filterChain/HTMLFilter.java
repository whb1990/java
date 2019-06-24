package main.java.com.study.designPatterns.chain.filterChain;

/**
 * @author: whb
 * @date: 2019/6/13 14:17
 * @description: 定义脚本过滤规则，处理字符串中的HTML标记
 */
public class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //将字符串中出现的"<>"符号替换成"[]"
        request.requestStr = request.requestStr.replace('<', '[').replace('>', ']')
                //后面添加的是便于我们观察代码执行步骤的字符串
                + "----HTMLFIlter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "----HTMLFilter()";
    }
}
