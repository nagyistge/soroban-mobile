package Soroban;

import javax.microedition.lcdui.*;

public class Tama 
{
    
    private int x=0,y=0;
    private int w=20, h=30; // Baseado na figura tama.png.
    private int xc=0, yc=0, wc=10000, hc=10000;
    private Graphics g;
    private Image imgT;
    
    public Tama(Graphics G) 
    {
        
        g=G;
        
        try
        {
            imgT = Image.createImage("/Soroban/Sol.gif");
        } 
        catch (Exception e) 
        {
            System.out.println("-- Erro:" + e.toString());
        }
    }
    
    public void setXY(int X, int Y)
    {
        x=X; y=Y;
    }

    public void show()
    {
        try
        {
            g.drawImage(imgT, x, y, g.TOP|g.LEFT);
        } 
        catch (Exception e) 
        {
            System.out.println("-- Erro:" + e.toString());
        }
    }
    
    public void move(int dx, int dy)
    {
        x+=dx;
        y+=dy;
        
        // Mantém tama dentro da área delimitada (clipping).
        if (x <= xc) x = xc;
        if (x >= xc + wc - w) x = xc + wc - w - 1;
        if (y <= yc) y = yc;
        if (y >= yc + hc - h) y = yc + hc - h - 1;
    }
    
    public int getHeight()
    {
        return h;
    }

    public int getWidth()
    {
        return w;
    }

    public void setClip(int Xc, int Yc, int Wc, int Hc)
    {
        xc = Xc;
        yc = Yc;
        wc = Wc;
        hc = Hc;
    }

    public void drawClipArea()
    {
        g.fillRect(xc, yc, wc, hc); // Usa cor corrente
    }

    public void jumpLeft()
    {
        x = xc;
    }

    public void jumpRight()
    {
        x = xc + wc - w;
    }
    
     public void jumpRight2()
    {
        x = xc + wc - w - 120;
    }

    public void jumpUp()
    {
        y = yc;
    }

    public void jumpDown()
    {
        y = yc + hc - h;
    }
    
}
