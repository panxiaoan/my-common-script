#!/usr/bin/expect

set timeout 30

# 获取参数
set port [lindex $argv 0]
set user [lindex $argv 1]
set host [lindex $argv 2]
set password [lindex $argv 3]

spawn ssh -p $port $user@$host

expect {
    "(yes/no)?" {
        send "yes\n"
        exp_continue
    }
    "password:" {
        # 关闭终端回显
        stty -echo
        send "$password\r"
        # 恢复终端回显
        stty echo
    }
}

interact