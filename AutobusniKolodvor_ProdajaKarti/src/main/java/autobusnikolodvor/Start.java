/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package autobusnikolodvor;

import autobusnikolodvor.view.SplashScreen;

/**
 *
 * @author Dino
 */
public class Start {

    public Start(){
        new SplashScreen().setVisible(true);
    }

    public static void main(String[] args) {
        new Start();
    }
}
