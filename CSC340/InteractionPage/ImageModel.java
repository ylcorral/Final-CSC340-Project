/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.InteractionPage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Translate String to Image Icon
 * @author David Bowles Last Updated: 12/1/2020
 */
public class ImageModel {

    public ImageModel() {
        System.out.println("ImageModelMade");
    }

    public ImageIcon urlStringToImageIcon(String _urlString) {
        try {
            System.out.println("URL String urlStringToImageIcon = " + _urlString);
            URL url = new URL(_urlString);
            ImageIcon image = new ImageIcon(ImageIO.read(url));
            return image;
        } catch (Exception ex) {
            Logger.getLogger(ImageModel.class.getName()).log(Level.SEVERE, null, ex);

        }
        System.out.println("return null");
        return null;
    }
}
