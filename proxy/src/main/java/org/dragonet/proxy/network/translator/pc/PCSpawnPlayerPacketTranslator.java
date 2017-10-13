package org.dragonet.proxy.network.translator.pc;

import com.github.steveice10.mc.protocol.data.game.entity.metadata.EntityMetadata;
import org.dragonet.proxy.network.UpstreamSession;
import org.dragonet.proxy.network.cache.CachedEntity;
import org.dragonet.proxy.network.translator.EntityMetaTranslator;
import org.dragonet.proxy.network.translator.PCPacketTranslator;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnPlayerPacket;
import sul.metadata.Bedrock137;
import sul.protocol.bedrock137.play.AddPlayer;
import sul.protocol.bedrock137.play.PlayerList;
import sul.protocol.bedrock137.types.McpeUuid;
import sul.utils.Packet;
import sul.utils.Tuples;

public class PCSpawnPlayerPacketTranslator implements PCPacketTranslator<ServerSpawnPlayerPacket> {

    @Override
    public Packet[] translate(UpstreamSession session, ServerSpawnPlayerPacket packet) {
        try {
            CachedEntity entity = session.getEntityCache().newPlayer(packet);

            // TODO: Do we need to register the player here ?
            AddPlayer pkAddPlayer = new AddPlayer();
            pkAddPlayer.entityId = entity.eid;

            for (EntityMetadata meta : packet.getMetadata()) {
                if (meta.getId() == 2) {
                    pkAddPlayer.username = meta.getValue().toString();
                    break;
                }
            }
            
            if (pkAddPlayer.username == null) {
                if(session.getPlayerInfoCache().containsKey(packet.getUUID())){
                    pkAddPlayer.username = session.getPlayerInfoCache().get(packet.getUUID()).getProfile().getName();
                }else{
                    return null;
                }
            }

            pkAddPlayer.uuid = new McpeUuid(packet.getUUID().getMostSignificantBits(), packet.getUUID().getLeastSignificantBits());;

            pkAddPlayer.position = new Tuples.FloatXYZ((float) packet.getX(), (float) packet.getY() + 1.62f, (float) packet.getZ());
            pkAddPlayer.yaw = packet.getYaw();
            pkAddPlayer.pitch = packet.getPitch();

            pkAddPlayer.metadata = new Bedrock137();
            pkAddPlayer._buffer = EntityMetaTranslator.translateToPE(packet.getMetadata(), null).encode();
            
            PlayerList lst = new PlayerList(PlayerList.Add.ACTION);
            // TODO: send skin
            /* sul.protocol.bedrock137.types.PlayerList p = new sul.protocol.bedrock137.types.PlayerList(
                    new McpeUuid(packet.getUUID().getMostSignificantBits(), packet.getUUID().getLeastSignificantBits()),
                    packet.getEntityId(),
                    pkAddPlayer.username,
                    null//new Skin(DefaultSkin.getDefaultSkinName(), DefaultSkin.getDefaultSkin().getData())
            );
            PlayerList.Add add = lst.new Add(new sul.protocol.bedrock137.types.PlayerList[]{p}); */
            //TODO: get the default skin to work.
            return new Packet[]{/*add, */pkAddPlayer};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
