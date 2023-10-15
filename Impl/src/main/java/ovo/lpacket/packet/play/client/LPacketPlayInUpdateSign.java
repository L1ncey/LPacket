package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import ovo.lpacket.LPacket;

public class LPacketPlayInUpdateSign extends LPacket {

    private final BlockPosition blockPosition;
    private final WrappedChatComponent[] chatComponents;

    public LPacketPlayInUpdateSign(PacketContainer packetContainer) {
        this.blockPosition = packetContainer.getBlockPositionModifier().read(0);
        this.chatComponents = packetContainer.getChatComponentArrays().read(0);
    }
}
