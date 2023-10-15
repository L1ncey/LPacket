package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayOutDestoryEntity extends LPacket {

    private int[] entitys;

    public LPacketPlayOutDestoryEntity(PacketContainer packetContainer) {
        this.entitys = packetContainer.getIntegerArrays().read(0);
    }
}
