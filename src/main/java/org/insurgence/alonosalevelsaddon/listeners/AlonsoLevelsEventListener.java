package org.insurgence.alonosalevelsaddon.listeners;

import com.alonsoaliaga.alonsolevels.api.AlonsoLevelsAPI;
import com.alonsoaliaga.alonsolevels.api.events.ExperienceChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.models.booster.GlobalBoosterManager;
import org.insurgencedev.insurgenceboosters.settings.IBoostersPlayerCache;

public final class AlonsoLevelsEventListener implements Listener {

    @EventHandler
    public void onReceive(ExperienceChangeEvent event) {
        String type = "Levels";
        final String NAMESPACE = "ALONSO_LEVELS";
        double totalMulti = 1;
        Player player = event.getPlayer();
        int difference = event.getNewExperience() - event.getOldExperience();

        IBoostersPlayerCache.BoosterFindResult pResult = IBoosterAPI.getCache(player).findActiveBooster(type, NAMESPACE);
        if (pResult instanceof IBoostersPlayerCache.BoosterFindResult.Success boosterResult) {
            totalMulti += boosterResult.getBooster().getMultiplier();
        }

        GlobalBoosterManager.BoosterFindResult gResult = IBoosterAPI.getGlobalBoosterManager().findBooster(type, NAMESPACE);
        if (gResult instanceof GlobalBoosterManager.BoosterFindResult.Success boosterResult) {
            totalMulti += boosterResult.getBooster().getMultiplier();
        }

        AlonsoLevelsAPI.setExperience(player.getUniqueId(), (int) (event.getOldExperience() + calculateAmount(difference, totalMulti)));
    }



    private long calculateAmount(double amount, double multi) {
        return (long) (amount * (multi < 1 ? 1 + multi : multi));
    }
}
