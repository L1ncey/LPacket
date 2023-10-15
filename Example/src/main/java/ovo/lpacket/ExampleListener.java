package ovo.lpacket;

import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class ExampleListener extends PacketAdapter {

    public ExampleListener() {
        super(ExamplePlugin.INSTANCE, ListenerPriority.NORMAL, LWrapper.getProcessedPackets());
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        LPacket wrappedPacket = LWrapper.wrap(event.getPacketType(), event.getPacket());

        handle(wrappedPacket);
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        LPacket wrappedPacket = LWrapper.wrap(event.getPacketType(), event.getPacket());

        handle(wrappedPacket);
    }

    public void handle(LPacket packet) {
//        DO SMTH
    }
}
