package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInSetCreativeSlot extends LPacket {

    private final int slot;
    private final ItemStack itemStack;

    public LPacketPlayInSetCreativeSlot(PacketContainer packetContainer) {
        this.slot = packetContainer.getIntegers().read(0);
        this.itemStack = packetContainer.getItemModifier().read(0);
    }

}
