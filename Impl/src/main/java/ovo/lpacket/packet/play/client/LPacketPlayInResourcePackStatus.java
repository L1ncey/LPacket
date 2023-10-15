package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInResourcePackStatus extends LPacket {

    private final EnumWrappers.ResourcePackStatus resourcePackStatus;

    public LPacketPlayInResourcePackStatus(PacketContainer packetContainer) {
        this.resourcePackStatus = packetContainer.getResourcePackStatus().read(0);
    }
}
