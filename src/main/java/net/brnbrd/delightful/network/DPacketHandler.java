package net.brnbrd.delightful.network;

import io.netty.buffer.ByteBuf;
import net.brnbrd.delightful.Delightful;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record DPacketHandler(int value) implements CustomPacketPayload {
    public static final Type<DPacketHandler> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(Delightful.MODID, "example"));
    public static final StreamCodec<ByteBuf, DPacketHandler> STREAM_CODEC =
            ByteBufCodecs.VAR_INT.map(DPacketHandler::new, DPacketHandler::value);

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() { return TYPE; }

    /*
    public static void init() {
        // Serverbound
        if (Modid.BTA.loaded()) {
            STREAM_CODEC.registerMessage(0, BotaniaLCP.class, BotaniaLCP::encode, BotaniaLCP::decode,
                    makeServerBoundHandler(BotaniaLCP::handle));
        }
    }

    private static <T> BiConsumer<T, Supplier<NetworkEvent.Context>> makeServerBoundHandler(TriConsumer<T, MinecraftServer, ServerPlayer> handler) {
        return (m, ctx) -> {
            handler.accept(m, Objects.requireNonNull(ctx.get().getSender()).getServer(), ctx.get().getSender());
            ctx.get().setPacketHandled(true);
        };
    }

    private static <T> BiConsumer<T, Supplier<NetworkEvent.Context>> makeClientBoundHandler(Consumer<T> consumer) {
        return (m, ctx) -> {
            consumer.accept(m);
            ctx.get().setPacketHandled(true);
        };
    }

    interface TriConsumer<T, U, R> {
        void accept(T var1, U var2, R var3);
    }

     */
}