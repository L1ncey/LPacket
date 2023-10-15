package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;


@Getter
public class LPacketPlayInChat extends LPacket {

    private final String length;

    public LPacketPlayInChat(PacketContainer packetContainer) {
        this.length = packetContainer.getStrings().read(0);
    }
}
