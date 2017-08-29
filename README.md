# 定时任务系统

在每个系统找不可避免的需要添加一些定时循环执行的任务，或定时执行一次的任务。
在以前这样的任务只能在项目中添加定时器（timer）才能完成，但是定时器这东西不太好用，不能准确执行。
另外在集群环境中会部署多个实例，而有些定时任务只能被执行一次，这样部署起来就很不方便，
所以就另外独立出一个项目，专门跑定时任务，而那些需要执行的任务，通过接口暴露出来 提供给定时任务项目通过 api 执行。


使用 spring boot + quartz + freemarker + mybatis + mysql \
前端使用技术  vue2.x + vue-resource + element(饿了么开源的基于 vue 的前段ui库) \

项目目录 \
web-timer-task \
  | \
  |----timer-common \
  |----timer-model \
  |----timer-dao \
  |----timer-service \
  |----timer-config \
  |----timer-web \
