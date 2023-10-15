package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInEnchantItem extends LPacket {

    private final int windowId;
    private final int button;

    public LPacketPlayInEnchantItem(PacketContainer packetContainer) {
        StructureModifier<Integer> integers = packetContainer.getIntegers();

        this.windowId = integers.read(0);
        this.button = integers.read(1);
    }
}
