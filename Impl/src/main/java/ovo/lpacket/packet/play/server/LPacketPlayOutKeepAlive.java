package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayOutKeepAlive extends LPacket {

    private final int key;

    public LPacketPlayOutKeepAlive(PacketContainer packetContainer) {
        this.key = packetContainer.getIntegers().read(0);
    }
}
