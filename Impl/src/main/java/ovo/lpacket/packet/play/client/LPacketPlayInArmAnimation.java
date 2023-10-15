package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInArmAnimation extends LPacket {

    private final long timestamp;

    public LPacketPlayInArmAnimation(PacketContainer packetContainer) {
            this.timestamp = packetContainer.getLongs().read(0);
    }
}
