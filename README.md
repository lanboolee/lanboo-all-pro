## zookeeper
### 1. 节点类型
|类型|描述|命令
|:---|:---|:------|
|PERSISTENT|持久节点|create /node
|PERSISTENT_SEQUENTIAL|持久序号节点| create -s /node
|EPHEMERAL|临时节点(不可拥有子节点)| create -e /node
|EPHEMERAL_SEQUENTIAL|临时序号节点(不可拥有子节点) |create -s -e /node

#### stat 命令
    stat /node   查看节点状态信息
    cZxid = 0x3c1       创建当前节点的事务id
    ctime =              创建时间
    mzxid =              修改当前节点的事务id
    mtime =              修改时间
    pZxid =              子节点发生创建或删除(不包括修改)
    ephemeralOwner =      不为空即临时节点   空为0x0
    cversion =            子节点增加或删除的次数
    dataversion =       
#### watch 命令
    watch命令是一次性的 
    set -w /node      监听当前节点的数据是否变更
    ls -w /node    监听子节点是否变更 之间听节点, 不包括数据
    
#### acl权限设置
acl全称为Access Control List(访问控制列表), 用于控制资源的访问权限. ZooKeeper
使用acl来控制对其znode的访问.基于scheme:id:permission的方式进行权限控制.scheme表示授权模式,id模式对应值
,permission即具体的增删改权限位

scheme:认知模型

|方案|描述|
|:---|:---|
|world|开放模式, 默认设置|
|ip|ip模式, 限定客户端ip访问|
|auth|用户密码认证模式, 只有在会话中添加认证才可以访问, 明文|
|digest|sha-1+base64加密后的密码, 实际使用中更常见|

permission权限为

|权限位|权限|描述
|:---|:---|:---|
|c|create|可以创建子节点
|d|delete|可以删除子节点(仅下一级节点)
|r|read|读取节点数据及显示子节点列表
|w|write|可以设置节点数据
|a|admin|可以设置节点访问控制列表控制权限

