# 工作中常用的一些 Groovy 脚本

## 配置 Groovy 开发环境

1. 下载 Groovy SDK：https://groovy.apache.org/download.html
![Groovy SDK bundle](asserts/download-groovy.png)

2. 配置环境变量 (macOS)

```bash
 export GROOVY_HOME=$HOME/groovy-4.0.14
 export PATH=$GROOVY_HOME/bin:$PATH
```

生效环境变量 `source .bash_profile`

3. 测试配置是否配置成功

```bash

~ groovy -v

Groovy Version: 4.0.14 JVM: 1.8.0_372 Vendor: Azul Systems, Inc. OS: Mac OS X

```

4. 运行一个本地 Maven 仓库中老的 Snapshot 文件

```bash

~ groovy clean-mvn-old-snapshot.groovy

>>> 删除成功, 总文件：28335, 删除文件：0, 保留文件：28335, time: 382 ms

```