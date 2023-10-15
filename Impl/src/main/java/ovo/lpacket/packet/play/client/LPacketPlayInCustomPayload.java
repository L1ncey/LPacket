package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInCustomPayload extends LPacket {

    private final String payload;

    public LPacketPlayInCustomPayload(PacketContainer packetContainer) {
        this.payload = packetContainer.getStrings().read(0);
    }
}
