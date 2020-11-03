package com.jreynolds97.plugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.util.Vector;

public class bowListener implements Listener{
    @EventHandler
    public void onProjectileFire(ProjectileLaunchEvent event){
        Entity entity = event.getEntity();
        if(event.getEntityType() == EntityType.ARROW && (event.getEntity().getShooter() instanceof Player)){
            Player shooter = (Player) event.getEntity().getShooter();
            
            // Get the spherical representation of the coordinates. Have to offset by 90 because Minecraft is backwards
            Double Theta = Math.toRadians(shooter.getLocation().getYaw() + 90);
            Double Phi = Math.toRadians(shooter.getLocation().getPitch() + 90);
            Double Rho = entity.getVelocity().length();

            // Transform into Cartesian coordinates to use in minecraft
            Double newX = Rho * Math.sin(Phi) * Math.cos(Theta);
            Double newZ = Rho * Math.sin(Phi) * Math.sin(Theta);
            Double newY = Rho * Math.cos(Phi);

            // Overwrite the velocity with the new vector
            entity.setVelocity(new Vector(newX, newY, newZ));
        }
    }
}
