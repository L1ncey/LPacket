<div align="center">
  <h1 style="margin-bottom: -1cm"> LPacket </h1>
  <a><img alt="Server Version" src="https://img.shields.io/badge/Server%20Version-1.8.8-blue"></a>
  <a><img alt="Api Type" src="https://img.shields.io/badge/API-ProtocolLib-blue"></a>
  <a><img alt="Authors" src="https://img.shields.io/badge/Authors-Lincey-aqua"></a>
</div>
<div align="left">

### 用途
读取 外部协议库 提供的数据包的内容并构建新的包(Lpacket), 使其不分 "Send" 和 "Receive"。

### 原因
Minecraft 的协议分为inbound和outbound (Play)

很多时候我们都需要用到这些协议来更好的为玩家提供游戏环境。
但是现在市面上主流协议库都将这些协议分为了 "Send" 和 "Receive" 这两类, 使用者需要 onPacketReceive(Send) 和 onPacketReceive(Receive) 来正常处理数据包，这可能会造成数据不同步/强迫症震怒。

因此我将之前写的LPacket整理了下, 并适配了高版本的协议, 使其可以读取这些数据包的内容并构建新的包(Lpacket), 该数据包不分 "Send" 和 "Receive"。

### 注意
虽然这些包被重写了, 但是 Send 和 Receive 仍然有着 主/支线程 的区分。
</div>