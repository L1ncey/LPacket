package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInCloseWindow extends LPacket {

    private final int windowId;

    public LPacketPlayInCloseWindow(PacketContainer packetContainer) {
        this.windowId = packetContainer.getIntegers().read(0);
    }
}
