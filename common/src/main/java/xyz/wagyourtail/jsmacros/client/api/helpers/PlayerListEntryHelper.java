package xyz.wagyourtail.jsmacros.client.api.helpers;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.world.WorldSettings;
import xyz.wagyourtail.jsmacros.core.helpers.BaseHelper;

/**
 * @author Wagyourtail
 * @since 1.0.2
 */
@SuppressWarnings("unused")
public class PlayerListEntryHelper extends BaseHelper<NetworkPlayerInfo> {

    public PlayerListEntryHelper(NetworkPlayerInfo p) {
        super(p);
    }

    /**
     * @since 1.1.9
     * @return
     */
    public String getUUID() {
        GameProfile prof = base.getProfile();
        if (prof == null) return null;
        return prof.getId().toString();
    }

    /**
     * @since 1.0.2
     * @return
     */
    public String getName() {
        GameProfile prof = base.getProfile();
        if (prof == null) return null;
        return prof.getName();
    }

    /**
     * @since 1.6.5
     * @return
     */
    public int getPing() {
        return base.getLatency();
    }

    /**
     * @since 1.6.5
     * @return null if unknown
     */
    public String getGamemode() {
        WorldSettings.GameType gm = base.getGameMode();
        if (gm == null) return null;
        return gm.getName();
    }

    /**
     * @since 1.1.9
     * @return
     */
    public TextHelper getDisplayText() {
        return new TextHelper(base.getDisplayName());
    }

    public String toString() {
        return String.format("Player:{\"uuid\": \"%s\", \"name\":\"%s\"}", this.getUUID(), this.getName());
    }
}
