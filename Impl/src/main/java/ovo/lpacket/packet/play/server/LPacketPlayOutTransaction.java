package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayOutTransaction extends LPacket {

    private final int windowId;
    private final short transactionId;
    private final boolean accepted;

    public LPacketPlayOutTransaction(PacketContainer packetContainer) {
        this.windowId = packetContainer.getIntegers().read(0);
        this.transactionId = packetContainer.getShorts().read(0);
        this.accepted = packetContainer.getBooleans().read(0);
    }

}
