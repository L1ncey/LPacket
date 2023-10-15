package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInHeldItemSlot extends LPacket {

    private final int slot;

    public LPacketPlayInHeldItemSlot(PacketContainer packetContainer) {
        this.slot = packetContainer.getIntegers().read(0);
    }

}
