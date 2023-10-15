package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInKeepAlive extends LPacket {

    private final int id;

    public LPacketPlayInKeepAlive(PacketContainer packetContainer) {
        StructureModifier<Integer> ints = packetContainer.getIntegers();


//        id 是 int 我是笨蛋，使用 long
//        不过在 1.12+ 确实使用long 无所谓
//        以后在考虑是否添加对1.12的支持
        this.id = ints.read(0);
    }
}
