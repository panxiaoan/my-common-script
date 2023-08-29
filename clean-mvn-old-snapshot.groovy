
// 清理本地 Maven 仓库中老的 Snapshot 包

// 在 Shell 中运行改文件：`groovy clean-mvn-old-snapshot.groovy` (前提条件是本地已经配置好 Groovy 的开发环境)

m2repo = '/Users/panxiaoan/.m2/repository'

pattern = /.*\-\d{8}\.\d{6}\-\d+\.[\w\.]+$/

count = 0
delCount = 0

start = System.currentTimeMillis()

new File(m2repo).eachFileRecurse {
    count++
    if (it.name.matches(pattern)) {
        println "Deleting ${it.name}"
        it.delete()
        delCount++
    }
}

println ">>> 删除成功, 总文件：$count, 删除文件：$delCount, 保留文件：${count - delCount}, time: ${System.currentTimeMillis() - start} ms"