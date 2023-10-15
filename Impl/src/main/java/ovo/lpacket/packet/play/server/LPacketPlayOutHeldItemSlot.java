package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayOutHeldItemSlot extends LPacket {

    private final int slot;

    public LPacketPlayOutHeldItemSlot(PacketContainer packetContainer) {
        this.slot = packetContainer.getIntegers().read(0);
    }

}
