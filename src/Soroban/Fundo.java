package Soroban;

import javax.microedition.lcdui.*;

public class Fundo 
{
    
    private Image imgT;
    private Graphics g;
    
    public Fundo(Graphics G) 
    {
        g=G;
        try
        {
            imgT = Image.createImage("/Soroban/Ceu.jpg");
        } 
        catch (Exception e) 
        {
            System.out.println("-- Erro:" + e.toString());
        }
    }
    
    public void show()
    {
        try
        {
            g.drawImage(imgT, 0, 0, 0); 
        } catch (Exception e) 
        {
            System.out.println("-- Erro:" + e.toString());
        }
    }
    
}
