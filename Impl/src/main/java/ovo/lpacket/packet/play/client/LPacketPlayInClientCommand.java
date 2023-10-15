package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInClientCommand extends LPacket {

    private final EnumWrappers.ClientCommand clientCommand;

    public LPacketPlayInClientCommand(PacketContainer packetContainer) {
        this.clientCommand = packetContainer.getClientCommands().read(0);
    }
}
