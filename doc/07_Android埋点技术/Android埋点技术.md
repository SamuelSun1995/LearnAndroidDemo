# [Android埋点技术分析]( https://blog.csdn.net/earbao/article/details/82145653 )

# 一、概念

 埋点，是对网站、App或者后台等应用程序进行数据采集的一种方法。通过埋点，可以收集用户在应用中的产生行为，进而用于分析和优化产品后续的体验，也可以为产品的运营提供数据支撑，其中常见的指标有PV、UV、页面时长和按钮的点击等，通常可以采集到下面这些数据。 

- 行为数据：时间、地点、人物、交互的内容等
- 质量数据：App运行情况、浏览器加载情况、错误异常等
- 环境数据：手机型号、操作系统版本、浏览器UA、地理、运营商、网络环境等
- 运营数据：PV、UV、点击量、日活、留存、渠道来源等

 采集行为数据时，通常需要在Web页面/App里面添加一些代码，当用户的行为达到某种条件时，就会向服务器上报用户的行为。其实添加这些代码的过程就可以叫做“埋点”，在很久以前就已经出现了这种技术。随着技术的发展和大家对数据采集要求的不断提高，我认为埋点的技术方案走过了下面几个阶段： 







# 什么是pv和uv? 

PV：页面访问量，即PageView，用户每次对网站的访问均被记录，用户对同一页面的多次访问，访问量累计。 UV：独立访问用户数：即UniqueVisitor，访问网站的一台电脑客户端为一个访客。00:00-24:00内相同的客户端只被计算一次。