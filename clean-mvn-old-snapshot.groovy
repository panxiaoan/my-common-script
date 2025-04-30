
// 用途：清理本地 Maven 仓库中老的 Snapshot 包
// 使用方法：在 Shell 中运行该文件：`groovy clean-mvn-old-snapshot.groovy` (前提条件是本地已经配置好 Groovy 的开发环境)

// Maven 仓库路径
def m2repo = System.getProperty('user.home') + '/.m2/repository'

count = 0
delCount = 0

start = System.currentTimeMillis()

// 清理所有老的 snapshot jar
pattern = /.*\-\d{8}\.\d{6}\-\d+\.[\w\.]+$/
new File(m2repo).eachFileRecurse {
    count++
    if (it.name.matches(pattern)) {
        println "Deleting ${it.name}" + ", file lenght [${it.length()}] bytes."
        it.delete()
        delCount++
    }
}

// 清理 .lastUpdated 和 
new File(m2repo).eachFileRecurse {
    count++
    if (it.name.endsWith('.lastUpdated') ) {
        println "Deleting ${it.name}" + ", file lenght [${file.length()}] bytes."
        it.delete()
        delCount++
    }
}

println ">>> 删除成功, 总文件：$count, 删除文件：$delCount, 保留文件：${count - delCount}, time: ${System.currentTimeMillis() - start} ms"