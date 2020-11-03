package com.jreynolds97.plugin;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

public class bowListener implements Listener{
    @EventHandler
    public void onBowFire(EntityShootBowEvent event){
        if (event.getEntityType().equals(EntityType.PLAYER)){
            Player shooter = (Player) event.getEntity();
            Location loc = shooter.getLocation();
            Double force = Double.valueOf(event.getForce()) * 3.0F;

            Double motX = (double) (-Math.sin(Math.toRadians(loc.getYaw())) * Math.cos(Math.toRadians(loc.getPitch())));
            Double motZ = (double) (Math.cos(Math.toRadians(loc.getYaw())) * Math.cos(Math.toRadians(loc.getPitch())));
            Double motY = (double) (-Math.sin(Math.toRadians(loc.getPitch())));
            
            Double f2 = Math.sqrt(motX * motX + motZ * motZ + motY * motY);

            motX /= f2;
            motZ /= f2;
            motY /= f2;
            // The bukkit 1.7.10 code has a source of random here, by removing it and replicating the rest of the code
            // we can force all arrows to travel along the same vector given constant facing and bow draw
            motX *= force;
            motY *= force;
            motZ *= force;

            event.getProjectile().setVelocity(new Vector(motX, motY, motZ));
        }
    }
}
