package ovo.lpacket.packet.play.client;


import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInBlockDig extends LPacket {

    private final BlockPosition blockPosition;
    private final EnumWrappers.PlayerDigType playerDigType;

    public LPacketPlayInBlockDig(PacketContainer packetContainer) {
        this.blockPosition = packetContainer.getBlockPositionModifier().read(0);
        this.playerDigType = packetContainer.getPlayerDigTypes().read(0);
    }
}
