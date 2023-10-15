package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInTabComplete extends LPacket {

    private final String message;

    public LPacketPlayInTabComplete(PacketContainer packetContainer) {
        this.message = packetContainer.getStrings().read(0);
    }
}